import java.util.LinkedList;


public class ThreadPool {
    private WorkerThread[] threads;
    private LinkedList<Runnable> taskQueue;

    public ThreadPool(int threadNumber) {
        taskQueue = new LinkedList<Runnable>();
        threads = new WorkerThread[threadNumber];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new WorkerThread();
            threads[i].start();
        }
    }

    public void execut(Runnable r) {
        synchronized (taskQueue) {
            taskQueue.addLast(r);
            taskQueue.notify();
        }
    }

    public class WorkerThread extends Thread {
        public void run() {
            Runnable r;
            while (true) {
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    r = (Runnable) taskQueue.removeFirst();
                }
                try {
                    r.run();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}