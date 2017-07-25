package four;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by zc on 17-7-25.
 */
public class RogueApplication {
    private static final Logger LOG = LoggerFactory.getLogger(RogueApplication.class);

    public static void main(String[] args) throws InterruptedException {
        int slowCount = 6;
        int fastCount = 15;
        for(int i = 0;i<slowCount;i++) {
            LOG.warn("This is a warning (slowCount)");
            Thread.sleep(5000);
        }

        for(int i = 0;i<fastCount;i++) {
            LOG.warn("This is a warning (fastCOunt)");
            Thread.sleep(1000);
        }

        for(int i = 0;i < slowCount;i++) {
            LOG.warn("This is awarning (slowCOunt)");
            Thread.sleep(5000);
        }
    }


}
