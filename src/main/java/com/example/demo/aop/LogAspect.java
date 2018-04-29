package com.example.demo.aop;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.SysLogMapper;
import com.example.demo.entity.SysLog;
import com.example.demo.util.NetworkUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author Bob Simon
 * @Description
 * @Date :Created in 2018-04-21 16:07
 * @Modified By
 **/

/**aop依赖**/
@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogMapper logMapper;

    @Pointcut("@annotation(com.example.demo.aop.Log)")
    private void pointcut() {

    }

    @After("pointcut()")
    public void insertLogSuccess(JoinPoint jp){
        addLog(jp,getDesc(jp));
    }

    private void addLog(JoinPoint jp,String text){
        Log.LOG_TYPE type=getType(jp);
        SysLog log=new SysLog();
        RequestAttributes requestAttributes=RequestContextHolder.getRequestAttributes();
        //一些系统监控
        if(requestAttributes!=null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String ip= NetworkUtil.getIpAddr(request);
            log.setIp(ip);
        }
        log.setCreateTime(new Date());
        log.setType(type.toString());
        log.setText(text);
        log.setUserId(123);
        Object[] obj= jp.getArgs();
        StringBuffer buffer=new StringBuffer();
        if(obj!=null){
            for(int i=0;i<obj.length;i++){
                buffer.append("[参数"+(i+1)+":");
                buffer.append(JSON.toJSONString(obj[i]));
                buffer.append("]");
            }
        }

        log.setParam(buffer.toString());

        /*********/
       /* try {
            CurrentUser currentUser = ShiroUtil.getCurrentUse();
            log.setUserName(currentUser.getUsername());
        }catch (UnavailableSecurityManagerException e){

        }*/
        logMapper.insert(log);
    }

    /**
     * 记录异常
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value="pointcut()",throwing="e")
    public void afterException(JoinPoint joinPoint,Exception e){
        System.out.print("-----------afterException:"+e.getMessage());
        addLog(joinPoint,getDesc(joinPoint)+e.getMessage());
    }


    private String getDesc(JoinPoint joinPoint){
        MethodSignature methodName = (MethodSignature)joinPoint.getSignature();
        Method method = methodName.getMethod();
        return method.getAnnotation(Log.class).desc();
    }

    private Log.LOG_TYPE getType(JoinPoint joinPoint){
        MethodSignature methodName = (MethodSignature)joinPoint.getSignature();
        Method method = methodName.getMethod();
        return method.getAnnotation(Log.class).type();
    }

}
