package com.zt.jinanzf.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration; 
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream; 
import java.awt.*;  
import java.awt.image.*;  

import javax.imageio.ImageIO;  

/** 
* @ClassName: FileUtil 
* @Description: 文件操作类 
* @author  
* @date 2016年3月25日 上午8:39:37 
*/
public class FileUtil {

	 /**
	 * 所有上传的的文件保存的盘符路径
	 */
	public static final String STORE_DISK = "D:\\attachment\\";
	/**
	 * 所有上传的的ueditor保存的盘符路径
	 */
	public static final String STORE_DISK_UEDITOR = "D:\\attachment";
	/**
	 * 所有上传的的文件保存的盘符路径
	 */
	public static final String STORE_DISK_ERRORS = "D:\\errorsLog\\";
	
	/**
	 * word导出图片的盘符路径，其中/attachment已经保存在数据库的路径中
	 */
	public static final String VISIT_DISK = "D:";
	 
	/**
	 * 人工智能功能测试Demo
	 */
	public static final String STORE_DISK_SMART = "D:\\attachment\\personSmart\\";
	 /**
     * 功能:压缩多个文件成一个zip文件
     * @param srcfile 源文件列表
     * @param zipfile 缩后的文件
     */
    public static void zipFiles(File[] srcfile,File zipfile){
        byte[] buf=new byte[1024];
        try {
            //ZipOutputStream类：完成文件或文件夹的压缩
            ZipOutputStream out=new ZipOutputStream(new FileOutputStream(zipfile));
            for(int i=0;i<srcfile.length;i++){
                FileInputStream in=new FileInputStream(srcfile[i]);
                out.putNextEntry(new ZipEntry(srcfile[i].getName()));
                int len;
                while((len=in.read(buf))>0){
                    out.write(buf,0,len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    /**
     * 功能:解压缩
     * @param zipfile 需要解压缩的文件
     * @param descDir 解压后的目标目录
     */
    public static void unZipFiles(File zipfile,String descDir){
        try {
            ZipFile zf = new ZipFile(zipfile);
            for(Enumeration<?> entries=zf.entries();entries.hasMoreElements();){
                ZipEntry entry=(ZipEntry) entries.nextElement();
                String zipEntryName=entry.getName();
                InputStream in = zf.getInputStream(entry);
                OutputStream out=new FileOutputStream(descDir+zipEntryName);
                byte[] buf1=new byte[1024];
                int len;
                while((len=in.read(buf1))>0){
                    out.write(buf1,0,len);
                }
                in.close();
                out.close();
                zf.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 图片格式转换
     * @param imgFile 准备转换的图片
     * @param format 转换的格式 jpeg - gif - png - bmp
     * @param formatFile 转换成功后输出的图片
     * */
    public static void imgConverter(File imgFile,String format,File formatFile)
            throws IOException{
        BufferedImage bIMG =ImageIO.read(imgFile);
        ImageIO.write(bIMG, format, formatFile);
    }
    
    /**
	 * 压缩图片
	 * @param formatName 转换的格式
	 * @param inputDir 输入图路径+文件名
	 * @param outputDir 输出图路径
	 * @param outputFileName 输出图文件名
	 * @param width 设置图片长宽
	 * @param height 设置图片长宽
	 * @param gp 是否是等比缩放 标记
	 * 
	 * */
    public static boolean imgCompress(String formatName,String inputDir, String outputDir, String outputFileName, int width, int height,
			boolean gp) throws Exception {
        
    	return new CompressPic().compress(formatName,inputDir,outputDir,outputFileName,width,height,gp);
		 
    }
    
    /**
	 * 快速创建txt日志文件
	 * 
	 * @param log
	 */
	public static void createTxtLog(String log) {
		Date date = new Date();
		SimpleDateFormat sdfFileNameYear = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdfFileNameMorth = new SimpleDateFormat("MM");
		SimpleDateFormat sdfFileNameDay = new SimpleDateFormat("dd");
		String fileNameYear = sdfFileNameYear.format(date);
		String fileNameMorth = sdfFileNameMorth.format(date);
		String fileNameDay = sdfFileNameDay.format(date);

		String filePath = STORE_DISK_ERRORS + fileNameYear + "\\" + fileNameMorth
				+ "\\";
		String fileName = fileNameYear + fileNameMorth + fileNameDay + ".txt";
		createLog(filePath, fileName, log);
	}

	/**
	 * 创建日志文件
	 * @param filePath
	 * @param fileName
	 * @param log
	 */
	public static boolean createLog(String filePath, String fileName, String log) {
		boolean flag = false;
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		File file = new File(filePath);
		if (!file.isDirectory()) {
			file.mkdirs();
		}
		FileOutputStream logOut = null;
		log = time + ":  " + log +"\r\n";
		try {
			logOut = new FileOutputStream(filePath+fileName,true);
			logOut.write(log.getBytes("GBK"));
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(logOut != null){
				try {
					logOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
}

/**
 * 缩略图类（通用） 本java类能将jpg、bmp、png、gif图片文件，进行等比或非等比的大小转换。 具体使用方法
 * compressPic(大图片路径,生成小图片路径,大图片文件名,生成小图片文名,生成小图片宽度,生成小图片高度,是否等比缩放(默认为true))
 */
class CompressPic {

	
	private File file = null; // 文件对象
	private String formatName;//转换的格式
	private String inputDir; // 输入图路径
	private String outputDir; // 输出图路径
	private String outputFileName; // 输出图文件名
	private int outputWidth = 100; // 默认输出图片宽
	private int outputHeight = 100; // 默认输出图片高
	private boolean proportion = true; // 是否等比缩放标记(默认为等比缩放)

  
	private void setWidthAndHeight(int width, int height) {
		this.outputWidth = width;
		this.outputHeight = height;
	}


	// 图片处理
	private boolean compress() throws Exception {
		try {
			// 获得源文件
			file = new File(inputDir);
			//System.out.println(inputDir + inputFileName);
			if (!file.exists()) {
				throw new Exception("图片压缩操作，源文件不存在");
			}
			Image img = ImageIO.read(file);
			// 判断图片格式是否正确
			if (img==null || img.getWidth(null) == -1) {
				throw new Exception("压缩文件格式不正确，未进行压缩！");
			} else {
				int newWidth;
				int newHeight;
				// 判断是否是等比缩放
				if (this.proportion == true) {
					// 为等比缩放计算输出的图片宽度及高度
					double rate1 = ((double) img.getWidth(null))
							/ (double) outputWidth + 0.1;
					double rate2 = ((double) img.getHeight(null))
							/ (double) outputHeight + 0.1;
					// 根据缩放比率大的进行缩放控制
					double rate = rate1 > rate2 ? rate1 : rate2;
					newWidth = (int) (((double) img.getWidth(null)) / rate);
					newHeight = (int) (((double) img.getHeight(null)) / rate);
				} else {
					newWidth = outputWidth; // 输出的图片宽度
					newHeight = outputHeight; // 输出的图片高度
				}
				BufferedImage tag = new BufferedImage((int) newWidth,
						(int) newHeight, BufferedImage.TYPE_INT_RGB);

				/*
				 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
				 */
				tag.getGraphics().drawImage(
						img.getScaledInstance(newWidth, newHeight,
								Image.SCALE_SMOOTH), 0, 0, null);
				File f=new File(outputDir);
				if (!f.exists()){
					f.mkdirs(); 
				}
				
				/*
				//jdk6方案
				FileOutputStream out = new FileOutputStream(outputDir
						+ outputFileName);
				// JPEGImageEncoder可适用于其他图片类型的转换
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(tag);
				out.close();
				*/
				ImageIO.write(tag, formatName, new File(outputDir+outputFileName+"."+formatName));

				return true;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}

 

	/**
	 * 压缩图片
	 * @param formatName 转换的格式
	 * @param inputDir 输入图路径+文件名
	 * @param outputDir 输出图路径
	 * @param outputFileName 输出图文件名
	 * @param width 设置图片长宽
	 * @param height 设置图片长宽
	 * @param gp 是否是等比缩放 标记
	 * 
	 * */
	public boolean compress(String formatName,String inputDir, String outputDir, String outputFileName, int width, int height,
			boolean gp) throws Exception {
		this.formatName = formatName;
		// 输入图路径
		this.inputDir = inputDir;
		// 输出图路径
		this.outputDir = outputDir;
 
		// 输出图文件名
		this.outputFileName = outputFileName;
		// 设置图片长宽
		setWidthAndHeight(width, height);
		// 是否是等比缩放 标记
		this.proportion = gp;
		return compress();
	}
}

