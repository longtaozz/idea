package com.zt.jinanzf.common.util;

import java.util.ArrayList;
import java.util.List;

import com.zt.jinanzf.monitor.gpsfence.model.Gpsfence;



public class GeoUtils {

	private final static double PI = 3.14159265358979323; // 圆周率
	private final static double R = 6371229; // 地球的半径
	
	//private static double offsetDistance = 50;  //外扩的距离（米）
	//private static double latLngDis = Arith.div(offsetDistance, 110000d, 10); //距离换算大约的经纬度值
	
	/**
	 * 检查多边形的List是否包含了某点~ true 为包含在内（边界上的不算）
	 * 
	 * @param ztGpsfenceList
	 *            电子围栏的ZtGpsfence集合
	 * @param lng  要判断坐标点的经度值
	 * @param lat  要判断坐标点的纬度值
	 * @return boolean
	 */
	public static int ztGpsfenceListContainsPointFenceId(List<Gpsfence> ztGpsfenceList, double lng,double lat){
		for(int i = 0; i < ztGpsfenceList.size(); i++){
			Gpsfence ztGpsfence = ztGpsfenceList.get(i);
			if(fencePosContainsPoint(ztGpsfence.getFencePos(),lng,lat)){
				return ztGpsfence.getFenceId();
			}
		}
		return 0;
	}
	/**
	 * 检查多边形的List是否包含了某点~ true 为包含在内（边界上的不算）
	 * 
	 * @param ztGpsfenceList
	 *            电子围栏的ZtGpsfence集合
	 * @param lng  要判断坐标点的经度值
	 * @param lat  要判断坐标点的纬度值
	 * @return boolean
	 */
	public static boolean ztGpsfenceListContainsPoint(List<Gpsfence> ztGpsfenceList, double lng,double lat){
		for(int i = 0; i < ztGpsfenceList.size(); i++){
			Gpsfence ztGpsfence = ztGpsfenceList.get(i);
			if(fencePosContainsPoint(ztGpsfence.getFencePos(),lng,lat)){
				return true;
			}
		}
		return false;
	}
	/**
	 * 检查多边形是否包含了某点~ true 为包含在内（边界上的不算）
	 * 
	 * @param fencePos
	 *            一连串的字符型坐标点，取自zhatu的zt_gps_fence里面的fencePos值
	 * @param lng  要判断坐标点的经度值
	 * @param lat  要判断坐标点的纬度值
	 * @return boolean
	 */
	public static boolean fencePosContainsPoint(String fencePos,double lng,double lat) {
		Point point = new Point(lng, lat);
		List<Point> polygon = new ArrayList<Point>();
		if (StringUtil.isNotEmpty(fencePos)) {
			String[] fencePosValueArray = fencePos.split(";");
			for (int i = 0; i < fencePosValueArray.length; i++) {
				Point pointPos = new Point(Double.valueOf(fencePosValueArray[i].split(",")[0]), Double.valueOf(fencePosValueArray[i].split(",")[1]));
				polygon.add(pointPos);
			}
		}
		return containsPoint(polygon, point);
	}

	/**
	 * 检查多边形是否包含了某点~ true 为包含在内（边界上的不算）
	 * 
	 * @param polygon
	 *            点集合的多边形
	 * @param point
	 * @return boolean
	 */
	public static boolean containsPoint(List<Point> polygon, Point point) {
		
		int polygonCount = polygon.size();
		// 多边形少于三个点，返回false
		if (polygonCount < 3) {
			return false;
		}
		int nCross = 0;
		for (int i = 0; i < polygon.size(); ++i) {
			Point p1 = polygon.get(i);
			Point p2 = polygon.get((i + 1) % polygonCount);
			// 求解 y=p.y 与 p1 p2 的交点
			if (p1.getLat() == p2.getLat()) { // p1p2 与 y=p0.y平行
				continue;
			}
			if (point.getLat() < Math.min(p1.getLat(), p2.getLat())) { // 交点在p1p2延长线上
				continue;
			}
			if (point.getLat() >= Math.max(p1.getLat(), p2.getLat())) { // 交点在p1p2延长线上
				continue;
			}
			// 求交点的 X 坐标
			double x = (point.getLat() - p1.getLat())
					* (p2.getLng() - p1.getLng()) / (p2.getLat() - p1.getLat())
					+ p1.getLng();
			if (x > point.getLng()) { // 只统计单边交点
				nCross++;
			}
		}
		// 单边交点为偶数，点在多边形之外
		return (nCross % 2 == 1);
	}

	/**
	 * 求两个经纬度坐标之间的距离
	 * 
	 * @param point1
	 *            第一个坐标点
	 * @param point2
	 *            第二个坐标点
	 * @return double
	 */
	public static double getDistance(Point point1, Point point2) {
		double x = (point2.getLng() - point1.getLng())
				* PI
				* R
				* Math.cos(((point1.getLat() + point2.getLat()) / 2) * PI / 180)
				/ 180;
		double y = (point2.getLat() - point1.getLat()) * PI * R / 180;
		double distance = Math.hypot(x, y);
		return distance;
	}

	/**
	 * 判断两个经纬度之间的距离是否在指定距离范围内，在范围内返回true
	 * 
	 * @param point1
	 *            第一个坐标点
	 * @param point2
	 *            第二个坐标点
	 * @param allowedDistance
	 *            指定距离范围
	 * @return boolean
	 */
	public static boolean allowedDistance(Point point1, Point point2,
			double allowedDistance) {
		double distance = getDistance(point1, point2);
		if (distance <= allowedDistance) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param Pa
	 *            第一个坐标点
	 * @param Pb
	 *            第二个坐标点
	 * @param Pc   
	 *     		    第三个坐标点     
	 * @return boolean
	 * x 是  lng
	 * y 是  lat
	 *  * 已知两点得直线方程
	 * (x2-x1)*y = (y2-y1)*x + x2*y1 - y2*x1
	 * 垂线方程过第一点
	 * (y1-y2)*y = (x2-x1)*x + y1*y1-y2*y1+x1*x1-x2*x1
	 * 垂线方程过第二点
	 * (y1-y2)*y = (x2-x1)*x + y1*y2-y2*y2+x1*x2-x2*x2
	 * 平移直线方程，指定固定距离n    开方Math.sqrt(4)  pow(x,y)  返回 x 的 y 次幂。
	 *  Ax + By + C = 0  Ax + By + C + n*((A平方 + B平方))(开方) = 0
	 *  已知两个方程 求解 a*x + b*y = c   d*x + e*y = f
	 *  x = (ce-bf)/(ae -bd)     y = (af-cd)/(ae-bd)
	 * 平移直线方程，指定固定距离n    开方Math.sqrt(4)  pow(x,y)  返回 x 的 y 次幂。
	 * Ax + By + C = 0  Ax + By + C + n*((A平方 + B平方))(开方) = 0
	 * 已知两个方程 求解 a*x + b*y = c   d*x + e*y = f
	 * x = (ce-bf)/(ae -bd)     y = (af-cd)/(ae-bd)
	 *//*
	public static List<Point> middleOffsetTwoPoint(Point Pa,Point Pb,Point Pc){
		List<Point> result = new ArrayList<Point>();
		
		double A1 = Arith.sub(Pb.getLat(),Pa.getLat());
		double B1 = Arith.sub(Pa.getLng(),Pb.getLng());
		double C1 = Arith.sub(Arith.mul(Pb.getLng(), Pa.getLat()), Arith.mul(Pb.getLat(), Pa.getLng()));
		double C1ADD = Arith.add(C1, Arith.mul(latLngDis, Math.pow((Math.pow(A1,2) + Math.pow(B1,2)),0.5)));
		double C1SUB = Arith.sub(C1, Arith.mul(latLngDis, Math.pow((Math.pow(A1,2) + Math.pow(B1,2)),0.5)));
		
		double A2 = Arith.sub(Pc.getLat(),Pb.getLat());
		double B2 = Arith.sub(Pb.getLng(),Pc.getLng());
		double C2 = Arith.sub(Arith.mul(Pc.getLng(), Pb.getLat()), Arith.mul(Pc.getLat(), Pb.getLng()));
		double C2ADD = Arith.add(C2, Arith.mul(latLngDis, Math.pow((Math.pow(A2,2) + Math.pow(B2,2)),0.5)));
		double C2SUB = Arith.sub(C2, Arith.mul(latLngDis, Math.pow((Math.pow(A2,2) + Math.pow(B2,2)),0.5)));
		
		double addX = 0,addY = 0,subX = 0,subY = 0;
		if(Arith.sub(Arith.mul(A1, B2), Arith.mul(B1, A2)) == 0){
			if(B2 == 0 || B1== 0){
				addX = Arith.add(Pb.getLng(), latLngDis);
				addY = Pb.getLat();
				subX = Arith.sub(Pb.getLng(), latLngDis);
				subY = Pb.getLat();
			}else if(A1 == 0 || A2 == 0){
				addX = Pb.getLng();
				addY = Arith.add(Pb.getLat(), latLngDis);
				subX = Pb.getLng();
				subY = Arith.sub(Pb.getLat(), latLngDis);
			}else{
				addX = Pb.getLng();
				addY = Arith.div(Arith.sub(-C1ADD, Arith.mul(A1, Pb.getLng())), B1);
				subX = Pb.getLng();
				subY = Arith.div(Arith.sub(-C1SUB, Arith.mul(A1, Pb.getLng())), B1);
			}
			addX =  Arith.div(addX,1d,6);
			addY =  Arith.div(addY,1d,6);
			subX =  Arith.div(subX,1d,6);
			subY =  Arith.div(subY,1d,6);
		}else{
			addX = Arith.div(Arith.sub(Arith.mul(B1, C2ADD), Arith.mul(C1ADD, B2)), Arith.sub(Arith.mul(A1, B2), Arith.mul(B1, A2)), 6);
			addY = Arith.div(Arith.sub(Arith.mul(C1ADD, A2), Arith.mul(A1, C2ADD)), Arith.sub(Arith.mul(A1, B2), Arith.mul(B1, A2)), 6);
			subX = Arith.div(Arith.sub(Arith.mul(B1, C2SUB), Arith.mul(C1SUB, B2)), Arith.sub(Arith.mul(A1, B2), Arith.mul(B1, A2)), 6);
			subY = Arith.div(Arith.sub(Arith.mul(C1SUB, A2), Arith.mul(A1, C2SUB)), Arith.sub(Arith.mul(A1, B2), Arith.mul(B1, A2)), 6);
		}
		
		Point pointAdd = new Point(addX,addY);
		Point pointSub = new Point(subX,subY);
		
		result.add(pointAdd);
		result.add(pointSub);
		return result;
	}
	*/
	/**
	 * 检查多边形是否包含了某点~ true 为包含在内（边界上的不算）
	 * 
	 * @param fencePos
	 *            一连串的字符型坐标点，取自zhatu的zt_gps_fence里面的fencePos值
	 * @param lng  要判断坐标点的经度值
	 * @param lat  要判断坐标点的纬度值
	 * @return boolean
	 */
	/*public static String fencePosExtendBoundary(String fencePos) {
		String resultFencePos = "";
		List<Point> polygon = new ArrayList<Point>();
		if (StringUtil.isNotEmpty(fencePos)) {
			String[] fencePosValueArray = fencePos.split(";");
			for (int i = 0; i < fencePosValueArray.length; i++) {
				Point pointPos = new Point(Double.valueOf(fencePosValueArray[i].split(",")[0]), Double.valueOf(fencePosValueArray[i].split(",")[1]));
				polygon.add(pointPos);
			}
		}
		
		if(polygon.size() < 4){
			resultFencePos = fencePos;
		}else{
			List<Point> offsetPointLists = new ArrayList<Point>();
			
			//特殊处理围栏的第一个点和最后一个点，这两个点是一样的值
			List<Point> firstEndPointList = middleOffsetTwoPoint(polygon.get(polygon.size() - 2),polygon.get(0),polygon.get(1));
			Point firstEndPoint =  new Point();
			for(int i = 0; i < firstEndPointList.size(); i++){
				if(!containsPoint(polygon,firstEndPointList.get(i))){
					firstEndPoint = firstEndPointList.get(i);
					break;
				}
			}
			
			offsetPointLists.add(firstEndPoint);
			for(int i = 1; i < polygon.size() - 1; i++){
				Point point1 = polygon.get(i - 1);
				Point point2 = polygon.get(i);
				Point point3 = polygon.get(i + 1);
				
				List<Point> offsetPoint = middleOffsetTwoPoint(point1,point2,point3);
				for(int y = 0; y < offsetPoint.size(); y++){
					if(!containsPoint(polygon,offsetPoint.get(y))){
						offsetPointLists.add(offsetPoint.get(y));
						break;
					}
				}
			}
			offsetPointLists.add(firstEndPoint);
			
			for(int i = 0; i < offsetPointLists.size(); i++){
				Point point = offsetPointLists.get(i);
				resultFencePos += point.getLng() + "," + point.getLat();
				if(i != offsetPointLists.size() - 1){
					resultFencePos += ";";
				}
			}
			
		}
		
		return resultFencePos;
	}*/
	public static Point getCenterPoint(List<Point> geoCoordinateList) {
        int total = geoCoordinateList.size();
        double X = 0, Y = 0, Z = 0;
        for (Point g : geoCoordinateList) {
            double lat, lon, x, y, z;
            lat = g.getLat() * Math.PI / 180;
            lon = g.getLng() * Math.PI / 180;
            x = Math.cos(lat) * Math.cos(lon);
            y = Math.cos(lat) * Math.sin(lon);
            z = Math.sin(lat);
            X += x;
            Y += y;
            Z += z;
        }

        X = X / total;
        Y = Y / total;
        Z = Z / total;
        double Lon = Math.atan2(Y, X);
        double Hyp = Math.sqrt(X * X + Y * Y);
        double Lat = Math.atan2(Z, Hyp);
        return new Point(Lat * 180 / Math.PI, Lon * 180 / Math.PI);
    }

    /**
     * 根据输入的地点坐标计算中心点（适用于400km以下的场合）
     * @param geoCoordinateList
     * @return
     */
    public static Point getCenterPoint400(List<Point> geoCoordinateList) {
        // 以下为简化方法（400km以内）
        int total = geoCoordinateList.size();
        double lat = 0, lon = 0;
        for (Point g : geoCoordinateList) {
            lat += g.getLat() * Math.PI / 180;
            lon += g.getLng() * Math.PI / 180;
        }
        lat /= total;
        lon /= total;
        return new Point(lon * 180 / Math.PI,lat * 180 / Math.PI);
    }
}
