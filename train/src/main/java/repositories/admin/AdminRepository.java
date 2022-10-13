package repositories.admin;

import entities.Admin;
import repositories.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepository {

    Connection connection= ConnectionProvider.getConnection();

    private static final String FindUserByEmail="SELECT * FROM admins WHERE email=? and password=?";

    public boolean findUserByEmail(String email,String password){
        try {
            PreparedStatement statement=connection.prepareStatement(FindUserByEmail);
            statement.setString(1,email);
            statement.setString(2,password);
            ResultSet resultSet=statement.executeQuery();
            Admin admin=null;
            while (resultSet.next()){
                admin= Admin.builder()
                        .email(resultSet.getString("email"))
                        .password(resultSet.getString(("password")))
                        .build();
            }
            if(admin!=null){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
