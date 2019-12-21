package practice.syncronize;

/**
 * @ClassName SyncronizedTest
 * @Description TODO
 * @Author Sandy
 * @Date 2019-12-21 11:49
 * @Version 1.0
 */
public class SyncronizedTest1 {

    public static int count = 0;

    public synchronized void increase() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        SyncronizedTest1 test = new SyncronizedTest1();
        Thread thread1 = new Thread(new Task1(test));
        Thread thread2 = new Thread(new Task1(test));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }


}


class Task1 implements Runnable {

    private SyncronizedTest1 test;

    public Task1(SyncronizedTest1 test) {
        this.test = test;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            test.increase();
        }
    }
}
