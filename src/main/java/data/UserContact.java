package data;

/**
 * Created with IntelliJ IDEA.
 * User: малыш
 * Date: 28.11.13
 * Time: 20:39
 * To change this template use File | Settings | File Templates.
 */
public class UserContact {

    public Integer id;
    public Integer userId;
    public String name;
    public String phone;

    public UserContact() {}

    public UserContact(Integer userId, String name, String phone)
    {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getUserId()
    {
        return this.userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }



}
