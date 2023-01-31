package projectSSAFY;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class UserManagerImpl implements IUserManager {

	private List<User> userList = new ArrayList<>();

	private final int MAX_SIZE = 100;

	private static UserManagerImpl um = new UserManagerImpl();

	private UserManagerImpl() {
		saveData();
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

		User[] res = new User[userList.size()];

		return this.userList.toArray(res);
	}

	public User[] getUsers() {

		List<User> list = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) {
				list.add(userList.get(i));
			}
		}

		User[] res = new User[list.size()];

		return list.toArray(res);

	}

	public VipUser[] getVipUsers() {

		List<VipUser> list = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) {
				list.add((VipUser) userList.get(i));
			}
		}
		
		VipUser[] res = new VipUser[list.size()];

		return list.toArray(res);

	}
	
	// 예외를 던진다고 선언
	public User[] searchByName(String name) throws NameNotFoundException {

		List<User> list = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().contains(name)) {
				list.add(userList.get(i));
			}
		}
		
		// 주어진 단어를 포함하는 사용자가 없으면 예외를 던진다.
		if(list.size() == 0) {
			throw new NameNotFoundException(name);
		}
		
		User[] res = new User[list.size()];

		return list.toArray(res);
	}

	public double getAgeAvg() {

		int sum = 0;

		for (int i = 0; i < userList.size(); i++) {
			sum += userList.get(i).getAge();
		}

		return sum / userList.size();

	}
	public void loadData() {
		try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream("user.dat"))){
			Object obj = oin.readObject();

        	if(obj !=null && obj instanceof List<?>) {
        		List<User> book = (List<User>)obj;
        		for (int i = 0; i < book.size(); i++) {
        			if(book.get(i)!=null) {
					System.out.println(book.get(i));
        			}
				}
        	}
        	else {
        		System.out.println("등록된 도서가 1없습니다.");
        	}
			
		}catch(IOException | ClassNotFoundException e ) {
			System.out.println("등록된 도서가 없습니다.");
		}
	}
		
	public void saveData() {

			try(ObjectOutputStream arr = new ObjectOutputStream(new FileOutputStream("user.dat"))){
				arr.writeObject(userList);
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}


}
