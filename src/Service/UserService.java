package Service;

import Entity.User;

public interface UserService {
    /*
    该方法语义为接受一个 User 对象，然后验证该用户的登录，验证成功则返回 true，否则返回 false
    */
    public boolean loginCheck(User user);
    public boolean registUser(User user);
}
