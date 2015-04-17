package dp.dubbo.db.service.impl.rowmapper;

import dp.dubbo.pojo.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by evan.wan on 2015/4/7.
 */
public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int index) throws SQLException
    {
        User u = new User();
        u.setId(rs.getLong("id"));
        u.setName(rs.getString("name"));
        u.setPassword(rs.getString("password"));
        return u;
    }
}
