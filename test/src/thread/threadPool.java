package thread;
/*
 * 阻塞队列，线程池，LinkedBlockingQueue
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;


public class threadPool {


	/* Spring负责加载属性---begin--- */
	private String dealMsgBeanName;
	private int dealThreadCount;
	private int maxQeueSize;
	private String threadPoolName;
	/* Spring负责加载属性---end--- */

	private List<LinkedBlockingQueue<Object>> dataQueueList;

	
	/**
	 * 初始化方法-每个处理线程一个队列，再将所有处理线程放入一个线程池中

	 * @throws Exception 
	 */
	public threadPool(String dealMsgBeanName,int dealThreadCount,int maxQeueSize,String threadPoolName) throws Exception {
		this.dealMsgBeanName = dealMsgBeanName;
		this.dealThreadCount= dealThreadCount;
		this.maxQeueSize = maxQeueSize;
		this.threadPoolName = threadPoolName;
		
		System.out.println(this.threadPoolName + "初始化开始...处理线程池名:" + this.threadPoolName
				+ " 处理bean名:" + this.dealMsgBeanName + " 处理线程数:" + this.dealThreadCount);
		try{
			dataQueueList = new ArrayList<LinkedBlockingQueue<Object>>();
			ThreadPoolExecutor threadExcutor = new ThreadPoolExecutor(
					this.dealThreadCount + 10, this.dealThreadCount + 10, 60L,
					TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
			
			for (int i = 0; i < dealThreadCount; i++) {
				LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>();
				DealThread dealThread = new DealThread(queue,this.dealMsgBeanName,i);
				dataQueueList.add(queue);
				threadExcutor.execute(dealThread);
			}
			System.out.println(this.threadPoolName + "初始化结束...处理线程池名:" + this.threadPoolName
					+ " 处理bean名:" + this.dealMsgBeanName + " 处理线程数:" + this.dealThreadCount);
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(this.threadPoolName + "初始化报错...处理线程池名:" + this.threadPoolName
					+ " 处理bean名:" + this.dealMsgBeanName + " 处理线程数:" + this.dealThreadCount);
			throw ex;
		}
		
		
	}

	/**
	 * 判断是否可以通过队列分发到处理线程

	 * 
	 * @return
	 */
	public boolean canDispatch() {
		boolean flag = false;
		for (LinkedBlockingQueue<Object> queue : dataQueueList) {
			if (queue.size() < this.maxQeueSize) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * 将任务通过队列分发到处理线程

	 * 
	 * @param obj
	 */
	public void dispatch(Object obj) {
		LinkedBlockingQueue<Object> minQueue = null;
		int minSize = Integer.MAX_VALUE;
		for (LinkedBlockingQueue<Object> queue : dataQueueList) {
			int size = queue.size();
			if (size == 0) {
				minQueue = queue;
				break;
			} else {
				if (size < minSize) {
					minSize = size;
					minQueue = queue;
				}
			}
		}
		minQueue.add(obj);
	}
	public static void main(String[] args) throws Exception {
		threadPool threadpool=new threadPool("1",20,20,"thread");
		List<String> values=new ArrayList<String>();
		for(int i=0;i<20;i++) {
			values.add(i+"");
		}
		if (values != null) {
			for (Object obj : values) {
				threadpool.dispatch(obj);
			}
		}
	}

}
