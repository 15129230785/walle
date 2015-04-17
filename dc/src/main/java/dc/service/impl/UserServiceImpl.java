package dc.service.impl;

import dc.exception.ExceptionCode;
import dc.exception.ServiceException;
import dc.service.UserService;
import dp.dubbo.db.service.TestDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by evan.wan on 2015/4/8.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private TestDubbo testDubbo;

//    public TestDubbo getTestDubbo() {
//        return testDubbo;
//    }
//
//    public void setTestDubbo(TestDubbo testDubbo) {
//        this.testDubbo = testDubbo;
//    }

    public String getStr(int n)
    {
        if(testDubbo==null) return "";
        if (n > 10) {
            throw new ServiceException(ExceptionCode.MUST_BE_LESS_THAN_10);
        }
        return testDubbo.getStr();
    }
}
