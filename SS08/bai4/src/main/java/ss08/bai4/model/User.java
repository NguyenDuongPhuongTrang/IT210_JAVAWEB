package ss08.bai4.model;

import ss08.bai4.annotation.PasswordMatches;

@PasswordMatches
public class User {
    private String name;
    private String password;
    private String comfirmPassword;

    public User(String name, String password, String comfirmPassword) {
        this.name = name;
        this.password = password;
        this.comfirmPassword = comfirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComfirmPassword() {
        return comfirmPassword;
    }

    public void setComfirmPassword(String comfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }
}