package DAO;

import POJO.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends BaseDAO<User> {

    public UserDAO(Connection conn) {
        super(conn);
    }

    public void addUser(User user) throws SQLException {
        save("INSERT INTO user (role_id, given_name, family_name, username, email, password, phone) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)",
                new Object[]{user.getUserRole().getUserRoleId(),
                        user.getGivenName(),
                        user.getFamilyName(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getPhone()});
    }

    public void updateUser(User user) throws SQLException {
        save("UPDATE user "
                        + "SET role_id = ?, given_name = ?, family_name = ?, "
                        + "username = ?, email = ? , password = ? , phone = ? "
                        + "WHERE id = ?",
                new Object[]{user.getUserRole().getUserRoleId(),
                        user.getGivenName(),
                        user.getFamilyName(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getPhone(),
                        user.getUserId()});
    }

    public void deleteUser(User user) throws SQLException {
        save("DELETE FROM user WHERE id = ?",
                new Object[]{user.getUserId()});
    }

    public List<User> readUsers() throws ClassNotFoundException, SQLException {
        return read("SELECT * FROM user", null);
    }

    @Override
    protected List<User> extractData(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setUserId(rs.getInt("id"));
            user.getUserRole().setUserRoleId(rs.getInt("role_id"));
            user.setGivenName(rs.getString("given_name"));
            user.setFamilyName(rs.getString("family_name"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setPhone(rs.getString("phone"));
            users.add(user);
        }
        return users;
    }
}