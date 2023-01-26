package project4.daily7_3;

public interface IUserManager {
	public void add(User user);
	public User[] getList();
	public User[] getUsers();
	public VipUser[] getVipUsers();
	public User[] searchByName(String name);
	public double getAgeAvg();
}
