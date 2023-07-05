package DAO;

import Entity.User;

public interface UserDao {
    /*
    接受一个 User 对象，然后根据该对象的 username 属性值为条件，在数据库中查找，
    如果找到，则用数据库记录字段为属性值，返回一个 User 对象，否则返回 NULL
     */
    public User selbyUsername(User user);
    /*
    为在 user 表中插入一条记录，用户信息为 user 对象对应属性，然后返回受影响的行数。
     */
    public int insertUser(User user);
}
