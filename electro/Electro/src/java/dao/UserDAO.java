package dao;

import model.User;

public interface UserDAO {	
	public void addUser(User u);
        
        public boolean checkUser(String username, String email);
        
        public boolean checkResetPassword(String username);
        
        public boolean loginUser(String username, String password);
        
	public void updateUser(User u);
        
	public User getUser(String username);
        
        public boolean removeUser(int ma_nguoi_dung);
        
        public int countUser();
}
