package com.panda.iweb.test.logger;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

/**
 * Created by chenlijiang on 2017/1/3.
 */
public class LoggerTest {
    private static final Logger logger = LoggerFactory.getLogger("test");

    @Test
    public void log(){
        logger.info("123");

        logger.info("123{}",4);


        logger.info(MarkerFactory.getMarker("test"),"123");
    }
}

