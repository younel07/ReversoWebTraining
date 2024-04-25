package entites;

import outils.EmailPattern;

public class User {
    private String username;
    private String email;
    private String password;

    // Constructors
    public User() {
    }

    public User(String p_username, String p_email, String p_password) throws EntitiesException {
        setUsername(p_username);
        setEmail(p_email);
        setPassword(p_password);
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String p_username) throws EntitiesException {
        if(p_username != null && !p_username.isEmpty() && p_username.length() < 20) {
            username = p_username;
        }else throw new EntitiesException("Username erroné", 1);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String p_email) throws EntitiesException {
        if(p_email != null && EmailPattern.isValidEmail(p_email)) {
            email = p_email;
        }else throw new EntitiesException("Email invalide ou manquant", 1);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
