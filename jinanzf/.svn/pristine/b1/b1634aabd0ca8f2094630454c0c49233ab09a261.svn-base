package com.zt.jinanzf.common.conf;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Component
@Aspect
@Order(-100)
@Slf4j 
public class DataSourceSwitchAspect {

//    @Pointcut("execution (* com.zt.zwb.system.service..*.*(..))")
//    private void zhatuAspect() {
//    }

//    @Pointcut("execution (* com.zt.gateway.service..*.*(..))")
//    private void gatewayAspect() {
//    }

//    @Before( "zhatuAspect()" )
//    public void zhatu(JoinPoint joinPoint) {
//        log.info("切换到zhatu 数据源...");
//        setDataSource(joinPoint,DBTypeEnum.zhatu);
//    }
    
//    @Pointcut("@annotation(com.zt.zwb.config.DataSourceSwitch)")
//    public void gatewayAnnontation() {
//    	
//    }
    
    @Before("@annotation(com.zt.jinanzf.common.conf.DataSourceSwitch)")
    public void gateway (JoinPoint joinPoint) {
    	log.info("切换到gateway数据源");
    	//setDataSource(joinPoint, DBTypeEnum.gateway);
    	DbContextHolder.setDbType(DBTypeEnum.gateway);
    }
    
    @After("@annotation(com.zt.jinanzf.common.conf.DataSourceSwitch)")
    public void gateway2 (JoinPoint joinPoint) {
    	log.info("切换到zhatu_jn数据源");
    	//setDataSource(joinPoint, DBTypeEnum.zhatu);
    	DbContextHolder.setDbType(DBTypeEnum.zhatu);
    }    

//    @Before("gatewayAspect()" )
//    public void gateway (JoinPoint joinPoint) {
//        log.info("切换到gateway 数据源...");
//        setDataSource(joinPoint,DBTypeEnum.gateway);
//    }
//    
//    @After("gatewayAspect()")
//    public void getway2 (JoinPoint joinPoint) {
//    	log.info("自动切换同回主数据源");
//    	setDataSource(joinPoint, DBTypeEnum.zhatu);
//    }
    
    /**
     * 添加注解方式,如果有注解优先注解,没有则按传过来的数据源配置
     * @param joinPoint
     * @param dbTypeEnum
     */
//    private void setDataSource(JoinPoint joinPoint, DBTypeEnum dbTypeEnum) {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        DataSourceSwitch dataSourceSwitch = methodSignature.getMethod().getAnnotation(DataSourceSwitch.class);
//        if (Objects.isNull(dataSourceSwitch) || Objects.isNull(dataSourceSwitch.value())) {
//            DbContextHolder.setDbType(dbTypeEnum);
//        }else{
//            log.info("根据注解来切换数据源,注解值为:"+dataSourceSwitch.value());
//            switch (dataSourceSwitch.value().getValue()) {
//                case "zhatu":
//                    DbContextHolder.setDbType(DBTypeEnum.zhatu);
//                    break;
//                case "gateway":
//                    DbContextHolder.setDbType(DBTypeEnum.gateway);
//                    break;
//                default:
//                    DbContextHolder.setDbType(dbTypeEnum);
//            }
//        }
//    }
}

