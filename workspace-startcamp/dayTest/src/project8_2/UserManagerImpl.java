package project8_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserManagerImpl implements IUserManager {

	private final int MAX_SIZE = 100;
	
	//private User[] userList = new User[MAX_SIZE];
	private List<User>userList = new ArrayList<>();

	private int size = 0;

	private static UserManagerImpl um = new UserManagerImpl();

	private UserManagerImpl() {
	};

	public static UserManagerImpl getInstance() {
		return um;
	}

	public void add(User user) {
		if (userList.size() < MAX_SIZE) {
			userList.add(user);
		} else {
			System.out.println("유저의 수가 100을 넘었습니다. 등록 불가.");
		}
	}

	public User[] getList() {
		User[] temp=new User[userList.size()];
		return userList.toArray(temp);
	}

	public User[] getUsers() {

		int cnt = 0;

		for (int i = 0; i < userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) {
				cnt++;
			}
		}

		if (cnt == 0)
			return null;

		User[] res = new User[cnt];

		for (int i = 0, index = 0; i < userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) {
				res[index++] = userList.get(i);
			}
		}

		return res;

	}

	public VipUser[] getVipUsers() {

		int cnt = 0;

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i) instanceof VipUser) {
				cnt++;
			}
		}

		if (cnt == 0)
			return null;

		VipUser[] res = new VipUser[cnt];

		for (int i = 0, index = 0; i <userList.size(); i++) {
			if (userList.get(i) instanceof VipUser) {
				res[index++] = (VipUser) userList.get(i);
			}
		}

		return res;

	}

	public User[] searchByName(String name) {

		int cnt = 0;

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().contains(name)) {
				cnt++;
			}
		}

		if (cnt == 0)
			return null;

		User[] res = new User[cnt];

		for (int i = 0, index = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().contains(name)) {
				res[index++] = userList.get(i);
			}
		}

		return res;
	}

	public double getAgeAvg() {

		int sum = 0;

		for (int i = 0; i < userList.size(); i++) {
			sum += userList.get(i).getAge();
		}

		return sum / userList.size();

	}

}
