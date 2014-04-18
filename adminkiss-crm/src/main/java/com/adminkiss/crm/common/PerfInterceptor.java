package com.adminkiss.crm.common;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 性能监控
 * 默认的，每当十个方法调用的时候，做一次记录，在任何方法响应时间超过500ms的时候给出警告
 *
 */
public class PerfInterceptor implements MethodInterceptor, Serializable{

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger("performance");
	
	private static ConcurrentHashMap<String, MethodStats> methodStats = new ConcurrentHashMap<String, MethodStats>();
	
	private static long statLogFrequency = 10;
	
    private static long methodWarningThreshold = 500;

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		long start = System.currentTimeMillis();
		try {
            return method.proceed();
        }
        finally {
            updateStats(method.getMethod().getName(),(System.currentTimeMillis() - start));
        }
	}
	
	private void updateStats(String methodName, long elapsedTime) {
        MethodStats stats = methodStats.get(methodName);
        if(stats == null) {
            stats = new MethodStats(methodName);
            methodStats.put(methodName,stats);
        }
        stats.count++;
        stats.totalTime += elapsedTime;
        if(elapsedTime > stats.maxTime) {
            stats.maxTime = elapsedTime;
        }
        if(elapsedTime > methodWarningThreshold) {
            logger.warn("method: " + methodName + "(), cnt = " + stats.count + ", lastTime = " + elapsedTime + ", maxTime = " + stats.maxTime);
        }
        if(stats.count % statLogFrequency == 0) {
            long avgTime = stats.totalTime / stats.count;
            long runningAvg = (stats.totalTime-stats.lastTotalTime) / statLogFrequency;
            logger.info("method: " + methodName + "(), cnt = " + stats.count + ", lastTime = " + elapsedTime + ", avgTime = " + avgTime + ", runningAvg = " + runningAvg + ", maxTime = " + stats.maxTime);
            //reset the last total time
            stats.lastTotalTime = stats.totalTime;  
        }
    }
	class MethodStats {
	    public String methodName;
	    public long count;
	    public long totalTime;
	    public long lastTotalTime;
	    public long maxTime;
	    public MethodStats(String methodName) {
	        this.methodName = methodName;
	    }
	}
}