package finalProject;


import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

/**
 */
public class Teacher extends User implements OrderDeliver, Serializable {
	

	Vector<Student> students = new Vector<Student>();
	private Status status;
    Vector<Course> courses = new Vector<Course>();
    public String message;
    HashMap<Course, Student> studentOfCourse = new HashMap<Course, Student>();
    
    public Teacher(String firstName, String midName, String lastName, String email, String password, String id, Status status1) {
		super(firstName, midName, lastName, email, password, id);
		this.status = status1;
	}

    public boolean addCourse(Course course) {
    	if(course == null || courses.contains(course)) return false;
    	return courses.add(course);
    }
 
    public void viewStudents() {
    	for(int i=0;i<students.size();i++) {
    		System.out.println(students.get(i));
    	}
    }

    public void viewCourses() {
    	for(int i=0;i<courses.size();i++) {
    		System.out.println(courses.get(i));
    	}
    }

    public boolean addFiles(Course course, CourseFile file) {
    	if(course == null || file == null || course.courseFiles.contains(file)) return false;
    	return course.courseFiles.add(file);
    }

    public boolean removeFiles(Course course, CourseFile file) {
    	if(course == null || file == null || !course.courseFiles.contains(file)) return false;
    	return course.courseFiles.remove(file);
    }

    public void viewStudentMarks(Course course) {
    	if(course != null) {
    		for(int i = 0;i < students.size();i++) {
    			if(students.get(i).myCourses.contains(course)) {
    				System.out.println(students.get(i).courseMarks.get(course));
    			}
    		}
    	}
    }
    
    public void viewCourseStudents(Course course) {
    	if(course != null) {
    		for(int i = 0;i < students.size();i++) {
    			if(students.get(i).myCourses.contains(course)) {
    				System.out.println(students.get(i));
    			}
    		}
    	}
    }
    public void sendOrder(Order order) {
    	Database.getOrders().add(order);
//    	System.out.println("Order was sent " + " to " + TechSupport.getEmail());
    }
    
    public void putMarks(Student student, Course course, Marks mark) {//pattern
    	if(student != null && course != null) {
	    	student.courseMarks.put(course, mark);	
    	}
    }
    
    
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String msg) {
		message = msg;
	}
    
    @Override
    public String toString() {
    	  return super.toString() + "[category = Teacher" + ", status =" + status + "]";
    }
    	 
}

