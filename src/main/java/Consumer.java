import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

    public final BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int count = 1;
        while (true) {
            try {
                String msg;
                msg = blockingQueue.take();
                System.out.println(msg);
                String SUFFER = "cтрада";
                if (msg.toLowerCase().contains(SUFFER)) {
                    System.out.println("count");
                    count++;

                }
                if (msg.equals(Producer.DEATH_PILL)){
                    System.out.println("vtor");
                    break;
                }
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println(count);
    }
}
