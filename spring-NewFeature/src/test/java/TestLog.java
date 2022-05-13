import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2020-2022, XDU
 * FileName: TestLog
 * Author: Dingq
 * Date: 2022/5/13 11:18
 * Description:
 */

public class TestLog {
    private static final Logger log = LoggerFactory.getLogger(TestLog.class);

    @Test
    public void test(){
        log.info("hello log4j2!");
        log.warn("bye!");
    }
}