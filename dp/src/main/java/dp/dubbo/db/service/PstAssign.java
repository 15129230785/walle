package dp.dubbo.db.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by yeahmobi on 2014/10/22.
 */
public interface PstAssign {
    void setParam(PreparedStatement ps) throws SQLException;
}
