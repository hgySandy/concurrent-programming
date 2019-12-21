package practice.syncronize;

/**
 * @ClassName SyncronizedTest2
 * @Description TODO
 * @Author Sandy
 * @Date 2019-12-21 11:49
 * @Version 1.0
 */
public class SyncronizedTest2 {

    public static int count = 0;
    private static final Object lock = new Object();

    public void increase() {
        synchronized (lock){
            count++;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        SyncronizedTest2 test1 = new SyncronizedTest2();
        SyncronizedTest2 test2 = new SyncronizedTest2();
        SyncronizedTest2 test3 = new SyncronizedTest2();
        Thread thread1 = new Thread(new Task2(test1));
        Thread thread2 = new Thread(new Task2(test2));
        Thread thread3 = new Thread(new Task2(test3));
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println(count);
    }

}


class Task2 implements Runnable {

    private SyncronizedTest2 test;

    public Task2(SyncronizedTest2 test) {
        this.test = test;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            test.increase();
        }
    }
}
