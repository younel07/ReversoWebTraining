package Dao;

import Dao.Connexion;
import entites.User;
import logs.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class DaoUser {

    public static User findByEmail(String filterEmail) throws Exception {
        PreparedStatement findByEmail = null;
        String sql = "SELECT * FROM users WHERE email = ?";
        Connection con = null;

        try {
            con = Connexion.startConnection();
            findByEmail = con.prepareStatement(sql);
            findByEmail.setString(1, filterEmail);
            ResultSet rs = findByEmail.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                return new User(username, email, password);
            } else {
                throw new DaoException("Impossible de trouver l'utilisateur avec cet e-mail", 2);
            }
        } catch (SQLException ex) {
            // Handle SQLException
            throw ex;
        } finally {
            // Close resources
            if (findByEmail != null) {
                findByEmail.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public static void createUser(User user) throws Exception {
        PreparedStatement createUser = null;
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        Connection con = Connexion.startConnection();

        try {
            //con.setAutoCommit(false);
            createUser = con.prepareStatement(sql);

            createUser.setString(1, user.getUsername());
            createUser.setString(2, user.getEmail());
            createUser.setString(3, user.getPassword());

            createUser.executeUpdate();

          //  con.commit();
        } catch (SQLException ex) {
            if (con != null) {
                MyLogger.LOGGER.log(Level.SEVERE, "Transaction create user rolled back, cause: " +
                        ex.getMessage(), ex);
           //    con.rollback();
            }
            if (ex.getErrorCode() == 1062) {
                throw new DaoException("user existe déja", 2);
            } else if (ex.getErrorCode() == 1406) {
                throw new DaoException("Trop de caractères ", 2);

            } else {
                MyLogger.LOGGER.log(Level.SEVERE, "Erreur: " + ex.getMessage() + " erreur: " + ex.getErrorCode(), ex);
                throw new SQLException(ex.getMessage());
            }
        }
            finally {
            // Close resources
            if (createUser != null) {
                createUser.close();
            }
           /* if (con != null) {
                con.setAutoCommit(true);
            }*/
        }
    }
}
