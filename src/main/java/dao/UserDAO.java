package dao;

import constraint.*;
import model.User;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public void register(User user) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            String sql = "INSERT INTO User (username, password) VALUES (?, ?)";
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println(SuccessMessage.REGISTER_SUCCESS);
            }
        }
        catch (SQLException e) {
            System.err.println(ErrorMessage.REGISTER_ERROR);
            e.printStackTrace();
        }
        finally{
            if(preparedStatement != null){
                try{
                    preparedStatement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                JdbcUtils.closeConnection(connection);
            }
        }
    }
    public void login(String username, String password) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println(SuccessMessage.LOGIN_SUCCESS);
            }

        }
        catch (SQLException e) {
            System.err.println(ErrorMessage.LOGIN_ERROR);
            e.printStackTrace();
        }
    }
    public boolean isUsernameExist(String username) {
        String sql = "SELECT id FROM users WHERE username = ?";

        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            // Nếu rs.next() là true nghĩa là tìm thấy dòng dữ liệu -> Đã tồn tại
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
