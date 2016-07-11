
package hellocontroller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Mapper {
    public static RowMapper<UserModel> getLstUsr() {
        RowMapper<UserModel> mapper = new RowMapper<UserModel>() {
            public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserModel obj = new UserModel();
                // obj.setUserID(rs.getInt("userid"));
                obj.setUserName(rs.getString("nickname"));
                obj.setAddress(rs.getString("address"));
                obj.setCity(rs.getString("city"));
                obj.setContactName(rs.getString("contact_name"));
                obj.setCountry(rs.getString("country"));
                obj.setEmailAdd(rs.getString("email"));
                obj.setPhone(rs.getString("phone"));
                // obj.setRole(rs.getInt("roleid"));
                return obj;
            }
        };
        return mapper;
    }
}
