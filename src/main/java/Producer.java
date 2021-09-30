import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.BlockingQueue;

    public class Producer extends Thread {
    public static final String DEATH_PILL = "DEATH_PILL";
    private final BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("voyna.txt"));
            while (true) {
                String str = bufferedReader.readLine();
                if (str != null) {
                    blockingQueue.put(str);
                } else {
                    blockingQueue.put(DEATH_PILL);
                    break;
                }
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}