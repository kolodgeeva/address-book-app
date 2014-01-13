package data;

/**
 * Created with IntelliJ IDEA.
 * User: малыш
 * Date: 02.12.13
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
public class User {

    Integer id;
    String login;
    String password;

    public User() {};

    public User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public Integer getId() {
        return id;
    }
}
