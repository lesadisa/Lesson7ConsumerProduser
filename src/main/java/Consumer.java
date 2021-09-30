import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

    public final BlockingQueue<String> blockingQueue;
    private final String SUFFER = "страдания";
    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                String msg = blockingQueue.take();
                if (msg.contains(SUFFER)) {
                    System.out.println(msg);
                    System.out.println("найден");
                    count++;
                }
                if (msg.equals(Producer.DEATH_PILL)) {
                    System.out.println("поиск окончен");
                    break;
                }
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println(count);
    }
}
