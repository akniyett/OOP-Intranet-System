package finalProject;

//import java.util.Scanner;

/**
 */
public class Manager extends User implements OrderDeliver, Serializable {
	
	
    private News news;
    private String messageFromTech;
    
    public String getMessageFromTech() {
		return messageFromTech;
	}

	public Manager(String firstName, String midName, String lastName, String email, String password, String id) {
 		super(firstName, midName, lastName, email, password, id);
 	}

    @Override
    public String toString() {
    	  return super.toString()+ "[category = Manager" + "]";
    }

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
	public void viewAllPerson() {
		for(int i = 0; i < super.db.getUsers().size(); i++) {
			System.out.println(super.db.getUsers().get(i).toString());
		 }
	}
	public void viewListStudents() {
	     for(int i = 0; i < super.db.getStudents().size(); i++) {
	    	 System.out.println(super.db.getStudents().get(i).toString());
	     }
	}

	public boolean approveCourse(Student student) {
		int cnt = 0;
		if(student == null || student.getYearOfStudy() <=0 || student.getFaculty() == null || student.myCourses.size() == 0) return false;
		if(student.getAllCredits()<=21) {
			for(int i=0;i<student.myCourses.size();i++) {
				if(student.coveredCourses.contains(student.myCourses.get(i).getPrerquesites()))
					cnt+=1;
			}
		}
		return cnt == student.myCourses.size();
    }

    public String sendMsgToTch(String email, String message1) {
    	for(int i=0;i<Database.getTeachers().size();i++) {
    		if(Database.getTeachers().get(i).getEmail().equals(email))
    			Database.getTeachers().get(i).setMessage(message1);
    	}
    	return "Message sent!";
    }

    public String removeNews(News news) {
    	super.db.getNews().remove(news);
    	return "News removed!";
    	
    }

    public String addNews(News news) {
    	super.db.getNews().add(news);
    	return "News added!";
    }

    public void createCourse(Course course,CourseSchedule scheduleOfCourse) {
    	course.setCourseSchedule(scheduleOfCourse);
    	super.db.getCourses().add(course);
    }

   
    public void sendOrder(Order order) {
    	Database.getOrders().add(order);

    }

	public void setMessageFromTech(String msg) {
		this.messageFromTech = msg;
		
	}
}

