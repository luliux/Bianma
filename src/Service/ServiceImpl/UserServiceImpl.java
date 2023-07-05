package Service.ServiceImpl;

import DAO.Impl.UserDaoImpl;
import DAO.UserDao;
import Entity.User;
import Service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public boolean loginCheck(User user) {
        boolean reslt = false;

        userDao = new UserDaoImpl();
        User returnUser = userDao.selbyUsername(user);
        if(returnUser == null){
            return false;
        }
        if(returnUser.getPassword().equals(user.getPassword())){
            return true;
        }
        return reslt;
    }

    @Override
    public boolean registUser(User user) {
        boolean result = false;

        userDao = new UserDaoImpl();
        User user2 = userDao.selbyUsername(user);
        if(user2 != null){
            return result;
        }
        int i = userDao.insertUser(user);
        if(i>0){
            result = true;
        }
        return result;
    }


}
