package util;



import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Class Name : ThreadPool
 * @Description:
 * @Author hunk qin
 * @Date 2013-8-22 下午06:50:16
 */
public class ThreadPool {
    private static Logger logger = LoggerFactory.getLogger(ThreadPool.class);

    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(200);

    public static void execute(Runnable command) {
        logger.info("当前线程激活数量>>>" + executor.getActiveCount() + " ，当前队列数量>>>" + executor.getQueue().size()
                + ",已经完成任务>>" + executor.getCompletedTaskCount());
        executor.execute(command);
    }

    public static void execute(Runnable command, long delayseconds) {
        logger.info("当前线程激活数量>>>" + executor.getActiveCount() + " ，当前队列数量>>>" + executor.getQueue().size());
        executor.schedule(command, delayseconds, TimeUnit.SECONDS);
    }

    public static void shutdown() {
        executor.shutdown();
    }


    public static void remove(Runnable Task) {
        executor.remove(Task);
    }
}
