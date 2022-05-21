package finalProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class Database {

	private static Database dataBase;
	
    private static Vector<Student> students = new Vector<Student>();
    private static Vector<User>users = new Vector<User>();
    private static Vector<Teacher> teachers = new Vector<Teacher>();
    private static Vector<Course> courses = new Vector<Course>();
    private static Vector<News>news = new Vector<News>();
    private static Vector<Manager>managers = new Vector<Manager>();
    private static Vector<TechSupport>techSupporters = new Vector<TechSupport>();
    private static Vector<Admin>admins = new Vector<Admin>();
    private static Vector<Order> orders = new Vector<Order>();
    
    static FileInputStream fis;
	static FileOutputStream fos;
	static ObjectOutputStream oos;
	static ObjectInputStream oin;
	
	static String path = "C:\\Users\\77077\\OneDrive\\pathh\\";
    
    private Database() {}

    public static Database getDatabase() {
    	if(dataBase == null) {
    		dataBase = new Database();
    	}
    	return dataBase;
    }

    
	public static Vector<Order> getOrders() {
		return orders;
	}

	public static void setOrders(Vector<Order> orders) {
		Database.orders = orders;
	}

	public static Vector<Student> getStudents() {
		return students;
	}

	public static void setStudents(Vector<Student> students) {
		Database.students = students;
	}

	public static Vector<User> getUsers() {
		return users;
	}

	public static void setUsers(Vector<User> users) {
		Database.users = users;
	}

	public static Vector<Teacher> getTeachers() {
		return teachers;
	}

	public static void setTeachers(Vector<Teacher> teachers) {
		Database.teachers = teachers;
	}

	public static Vector<Course> getCourses() {
		return courses;
	}

	public static void setCourses(Vector<Course> courses) {
		Database.courses = courses;
	}

	public static Vector<News> getNews() {
		return news;
	}

	public static void setNews(Vector<News> news) {
		Database.news = news;
	}

	public static Vector<Manager> getManagers() {
		return managers;
	}

	public static void setManagers(Vector<Manager> managers) {
		Database.managers = managers;
	}

	public static Vector<TechSupport> getTechSupporters() {
		return techSupporters;
	}

	public static void setTechSupporters(Vector<TechSupport> techSupporters) {
		Database.techSupporters = techSupporters;
	}

	public static Vector<Admin> getAdmins() {
		return admins;
	}

	public static void setAdmins(Vector<Admin> admins) {
		Database.admins = admins;
	}
    
    public static void serUsers(){
    	
//    	fos = new FileOutputStream("users.txt");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.txt"))){
			oos.writeObject(courses);
			oos.flush();
		}catch(IOException e) {
			System.out.println("IOException users");
		}
    }
    
    public static void desUsers(){
		try {
			fis = new FileInputStream("users.txt");
			oin = new ObjectInputStream(fis);
			users = (Vector<User>) oin.readObject();
			oin.close();
			fis.close();
		} catch (IOException e) {
            users = new Vector<>();
            System.err.println("IOException users");
        }
        catch (ClassNotFoundException e) {
            users = new Vector<>();
            System.err.println("ClassNotFoundException users");
        }   
	}
  
    public static void serAdmin(){
    	
//    	fos = new FileOutputStream("admin.txt");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("admin.txt"))){
			oos.writeObject(admins);
			oos.flush();;
		}
		catch(IOException e) {
			System.out.println("IOException admin");
		}
    }
    
    public static void desAdmin(){
    	try {
			fis = new FileInputStream("admin.txt");
			oin = new ObjectInputStream(fis);
			admins = (Vector<Admin>) oin.readObject();
	//		fis.close();
			oin.close();
    	}
    	 catch (IOException e) {
             admins = new Vector<>();
             System.err.println("IOException admin");
         }
         catch (ClassNotFoundException e) {
             admins = new Vector<>();
             System.err.println("ClassNotFoundException admin");
         }   
	}
  
    public static void serManager() {
    	
    	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("manager.txt"))){
			oos.writeObject(managers);
			oos.flush();;
    	}
    	catch(IOException e) {
			System.out.println("IOException manager");
		}
    }
    
    public static void desManager(){
		try {
			fis = new FileInputStream("manager.txt");
			oin = new ObjectInputStream(fis);
			managers = (Vector<Manager>) oin.readObject();
			fis.close();
			oin.close();
		}
		 catch (IOException e) {
		        managers = new Vector<>();
		        System.err.println("IOException manager");
		    }
		    catch (ClassNotFoundException e) {
		        managers = new Vector<>();
		        System.err.println("ClassNotFoundException manager");
		    }   
	}
  
    public static void serTechSupport() {
    	
    	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("techSupporters.txt"))){
			oos.writeObject(techSupporters);
			oos.flush();;
    	}
    	catch(IOException e) {
			System.out.println("IOException techSupporters");
		}
		
    }
    
    public static void desTechSupporters() throws IOException, ClassNotFoundException{
    	try {
			fis = new FileInputStream("techSupporters.txt");
			oin = new ObjectInputStream(fis);
			techSupporters = (Vector<TechSupport>) oin.readObject();
			oin.close();
			fis.close();
    	}
    	 catch (IOException e) {
             techSupporters = new Vector<>();
             System.err.println("IOException techSupporters");
         }
         catch (ClassNotFoundException e) {
             techSupporters = new Vector<>();
             System.err.println("ClassNotFoundException techSupporters");
         }   
	}
  
    public static void serTeacher() {
    	
    	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teachers.txt"))){
			oos.writeObject(teachers);
			oos.flush();;
    	}
    	catch(IOException e) {
			System.out.println("IOException teachers");
		}
    }
    
    public static void desTeacher() throws IOException, ClassNotFoundException{
		
    	try{
    		fis = new FileInputStream("teachers.txt");
    	
			oin = new ObjectInputStream(fis);
			teachers = (Vector<Teacher>) oin.readObject();
			oin.close();
			fis.close();
    	}
    	 catch (IOException e) {
             teachers = new Vector<>();
             System.err.println("IOException teachers");
         }
         catch (ClassNotFoundException e) {
             teachers = new Vector<>();
             System.err.println("ClassNotFoundException teachers");
         }   
	}
  
    public static void serStudent(){
    	
    	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.txt"))){
			oos.writeObject(students);
			oos.flush();;
    	}
    	catch(IOException e) {
			System.out.println("IOException students");
		}
    }
    
    public static void desStudent() throws IOException, ClassNotFoundException{
    	try {
			fis = new FileInputStream("students.txt");
			oin = new ObjectInputStream(fis);
			students = (Vector<Student>) oin.readObject();
			oin.close();
			fis.close();
    	} catch (IOException e) {
            students = new Vector<>();
            System.err.println("IOException students");
        }
        catch (ClassNotFoundException e) {
            students = new Vector<>();
            System.err.println("ClassNotFoundException students");
        }   
	}
    
    public static void serCourses() {
    	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("course.txt"))){
			oos.writeObject(courses);
			oos.flush();;
    	}
    	catch(IOException e) {
			System.out.println("IOException course");
		}
    }
    
    
    public static void desCourses() throws IOException, ClassNotFoundException{
		try {
	    	fis = new FileInputStream("course.txt");
			oin = new ObjectInputStream(fis);
			courses = (Vector<Course>) oin.readObject();
			oin.close();
	//		fis.close();
		} catch (IOException e) {
            courses = new Vector<>();
            System.err.println("IOException course");
        }
        catch (ClassNotFoundException e) {
            courses = new Vector<>();
            System.err.println("ClassNotFoundException course");
        }   
	}
    
    public static void serOrders(){
    	
    	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("order.txt"))){
			oos.writeObject(orders);
			oos.flush();;
    	}
    	catch(IOException e) {
			System.out.println("IOException order");
		}
    }
    
    public static void desOrders() throws IOException, ClassNotFoundException{
		try {
	    	fis = new FileInputStream("order.txt");
			oin = new ObjectInputStream(fis);
			orders = (Vector<Order>) oin.readObject();
		} catch (IOException e) {
            orders = new Vector<>();
            System.err.println("IOException order");
        }
        catch (ClassNotFoundException e) {
            orders = new Vector<>();
            System.err.println("ClassNotFoundException order");
        }   
	}
    
    public static void serNews(){
    	
    	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("news.txt"))){
			oos.writeObject(news);
			oos.flush();;
    	}
    	catch(IOException e) {
			System.out.println("IOException news");
		}
    }
    
    public static void desNews() throws IOException, ClassNotFoundException{
		try {
	    	fis = new FileInputStream("news.txt");
			oin = new ObjectInputStream(fis);
			news = (Vector<News>) oin.readObject();
			oin.close();
			fis.close();
		} catch (IOException e) {
            news = new Vector<>();
            System.err.println("IOException news");
        }
        catch (ClassNotFoundException e) {
            news = new Vector<>();
            System.err.println("ClassNotFoundException news");
        }   
	}
  
    public int compareTo() {
        return 0;
    }
    
    public static void store() throws IOException {
    	serAdmin();
    	serManager();
    	serTechSupport();
    	serTeacher();
    	serStudent();
    	serUsers();
    	serNews();
    	serOrders();
    	serCourses(); 	
    }
    
    public static void restore() throws ClassNotFoundException, IOException {
    	if(new File("courses").exists()) desCourses();
		if(new File("students").exists()) desStudent();
		if(new File("teachers").exists()) desTeacher();
		if(new File("manager").exists()) desManager();
		if(new File("admin").exists()) desAdmin();
		if(new File("techSupporters").exists()) desTechSupporters();
		if(new File("users").exists()) desUsers();
		if(new File("news").exists()) desOrders();
		if(new File("orders").exists()) desOrders();
    }


}









