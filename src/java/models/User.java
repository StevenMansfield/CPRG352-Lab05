package models;

public class User {
    String username; 
    String password; 

    public User() {
        this.username = "";
        this.password = "";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
