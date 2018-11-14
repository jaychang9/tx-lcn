package com.example.demo2.util;

import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User         : zj
 * Date         : 17/7/11
 * Time         : 上午11:02
 * Description  : 高并发场景下System.currentTimeMillis()的性能问题的优化，
 *                System.currentTimeMillis()的调用比new一个普通对象要耗时的多（具体耗时高出多少我还没测试过，有人说是100倍左右，
 *                System.currentTimeMillis()之所以慢是因为去跟系统打了一次交道，
 *                后台定时更新时钟，JVM退出时，线程自动回收
 */

public class SystemClock {

    private final long period;

    private final AtomicLong now;

    private final static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm:ss:ms");

    private SystemClock(long period) {
        this.period = period;
        this.now = new AtomicLong(System.currentTimeMillis());
        scheduleClockUpdating();
    }

    private static class InstanceHolder {
        public static final SystemClock INSTANCE = new SystemClock(1);
    }

    private static SystemClock instance() {
        return InstanceHolder.INSTANCE;
    }

    private void scheduleClockUpdating() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "System Clock");
                thread.setDaemon(true);
                return thread;
            }
        });
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                now.set(System.currentTimeMillis());
            }
        }, period, period, TimeUnit.MILLISECONDS);
    }

    private long currentTimeMillis() {
        return now.get();
    }

    public static long now() {
        return instance().currentTimeMillis();
    }

    public static String nowDate() {
        return df.format(instance().currentTimeMillis());
    }

    public static void main(String[] args) {
        //System.out.println(SystemClock.nowDate());
    }

}
