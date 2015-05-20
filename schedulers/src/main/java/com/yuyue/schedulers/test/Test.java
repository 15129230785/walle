package com.yuyue.schedulers.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by evan.wan on 2015/5/19.
 */
@Component("test")
public class Test {
    private static Logger LOG = LoggerFactory.getLogger(Test.class);

    public  void execute()
    {
        System.out.println("xx");
        LOG.error("xxxxc");
        LOG.info("now {}" , "1");
        LOG.info("now {}" , "eoooorr");
    }
}
