package com.adminkiss.core.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 任务管理器
 *
 */
public class TaskManager {

	/**
	 * 同步执行服务 可以保证提交的服务能顺序完成
	 */
	private static ExecutorService syncExecuteService = Executors.newSingleThreadExecutor();

	/**
	 * 异步执行服务 不保证提交的服务顺序完成
	 */
	private static ExecutorService asyncExecuteService = Executors.newCachedThreadPool();

	private static TaskManager instance = new TaskManager();

	private TaskManager() {

	}

	/**
	 * 获取任务管理器实例
	 * 
	 * @return
	 */
	public static TaskManager getInstance() {
		return instance;
	}

	/**
	 * <pre>
	 * 提交需要同步执行的任务
	 * </pre>
	 * 
	 * @param callable
	 * @return
	 */
	public <T> Future<T> syncSubmit(Callable<T> task) {
		return syncExecuteService.submit(task);
	}

	/**
	 * 提交异步执行的任务
	 * 
	 * @param task
	 * @return
	 */
	public <T> Future<T> asyncSubmit(Callable<T> task) {
		return asyncExecuteService.submit(task);
	}

}