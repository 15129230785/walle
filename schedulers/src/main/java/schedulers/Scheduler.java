package schedulers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by evan.wan on 2015/4/16.
 */
@Component("test")
public class Scheduler {
    private static Logger LOG = LoggerFactory.getLogger(Scheduler.class);

    public  void execute()
    {
        System.out.println("xx");
        LOG.error("xxxxc");
        LOG.info("now {}" , "1");
        LOG.info("now {}" , "eoooorr");
    }

}
