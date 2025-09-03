package user;

import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String username, String password) {
		User user = this.get(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;

	}

	@Override
	public User get(String username) {
		// TODO Auto-generated method stub
		return userDao.get(username);
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
	    if (userDao.checkExistUsername(username)) {
	        return false;
	    }
	    java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

	    // Không set id, để DB tự tăng
	    User user = new User(email, username, fullname, password, "", phone, 5, date);
	    userDao.insert(user);
	    return true;
	}


	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.checkExistPhone(phone);

	}


}
