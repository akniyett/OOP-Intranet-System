package finalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public abstract class User implements Serializable {
	

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String id;
	private String midName;
	private boolean forgot = false;
	private boolean isAuthorized = false;
	Database db;
	
	public User(String firstName, String midName, String lastName, String email, String password, String id) {
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.id = id;
	}
	
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public boolean login() throws IOException{
//		for(int i=0;i<Database.getAdmins().size();i++) {
//			System.out.println(Database.getAdmins().get(i));
//		}
//		System.out.println("lol");
////		Scanner input = new Scanner(System.in);
//		System.out.println("Fill autorizathion data");
//		System.out.println("Enter email: ");
//		String in = input.readLine();
//		boolean isLogin = false;
		
//		for(int i=0; i<Database.users.size();i++) {
//			if(Database.users.get(i).getEmail().equals(in)) {
//				isLogin = true; 
//				break;
//			}
//				
//		}
//		if(!isLogin) {
//			System.err.println("Wrong email!");
//			return false;
//		}
	
		int cnt = 3;
		while(cnt>0) {
			
			System.out.println("Enter password: ");
			String in2 = input.readLine();
			if(in2.equals(this.password)) {
				this.isAuthorized = true;
				System.out.println("Success!");
				cnt = 0;
			}
			else {
				System.err.println("Wrong password!");
				this.isAuthorized = false;
				cnt -= 1;
			}
		}
		if(!this.isAuthorized) {
			System.err.println("Enter id to be authorized!");
			String idd = input.readLine();
			this.forgot = true;
			if(this.getId().equals(idd)) {
				isAuthorized = true;
			}
					
			
			
		}
		return isAuthorized;

	}
	
	public void changePassword() throws IOException {
		if(!this.isAuthorized) System.err.println("You are not authorized!");
		else {
			if(this.forgot) {
				System.out.println("Enter id: ");
				String idd = input.readLine();
				if(!this.getId().equals(idd)) System.out.println("Not correct id!");
				else {
					System.out.println("Enter new password: ");
					String newKey = input.readLine();
					this.password = newKey;
					System.out.println("Success!");
				}
			}
//			Scanner in = new Scanner(System.in);
			else{
				System.out.println("Enter old password: ");
				String oldKey = input.readLine();
				if(!oldKey.equals(this.password)) System.err.println("Password doesn't match!");
				
				else {
					System.out.println("Enter new password: ");
					String newKey = input.readLine();
					if(oldKey.equals(newKey)) System.err.println("Old password can't be repeated! Choose new one!");
					else {
						this.setPassword(newKey);
						System.out.println("Success!");
					}
				}
			}
		}
			
		
	}
	
	public void viewNews() {
		if(!this.isAuthorized) System.out.println("You are not authorized!");
		else {
			for(int i=0;i<Database.getNews().size();i++) {
				System.out.println(db.getNews().get(i));
			}
		}
	}


	@Override
	public String toString() {
		return "Full Name = " + firstName + " " + midName + " " + lastName 
		    + ", email = " + email + ", id = " + id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMidName() {
		return midName;
	}


	public void setMidName(String midName) {
		this.midName = midName;
	}
}

