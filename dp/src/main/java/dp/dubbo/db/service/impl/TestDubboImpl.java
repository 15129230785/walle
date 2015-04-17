package dp.dubbo.db.service.impl;

import dp.dubbo.db.service.impl.rowmapper.UserRowMapper;
import dp.dubbo.pojo.User;
import dp.dubbo.db.service.AbstractExecute;
import dp.dubbo.db.service.TestDubbo;
import com.alibaba.dubbo.config.annotation.Service;
import util.ListUtil;

import java.util.List;

@Service(version="1.0.0")
public class TestDubboImpl extends AbstractExecute implements TestDubbo {

    public String getStr() {
        String sql = "SELECT * FROM user";
        List<User> list = getJdbcTemplate().query(sql, new UserRowMapper());
        if(ListUtil.isEmpty(list))
        {
            return "error";
        }
        return list.get(0).getName();
    }

}
