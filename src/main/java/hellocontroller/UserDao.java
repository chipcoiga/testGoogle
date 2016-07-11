
package hellocontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${dnb.gcs.sql.getAllUser}")
    private String getAllUser;

    public List<UserModel> getUser(int id) {
        List<UserModel> lstUser = new ArrayList<UserModel>();
        try {
            lstUser = this.jdbcTemplate.query(this.getAllUser, new Object[] {
                    id
            }, Mapper.getLstUsr());
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return lstUser;
    }
}
