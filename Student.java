package finalProject;

import java.util.HashMap;
import java.util.Vector;


public class Student extends User implements OrderDeliver, Serializable, Comparable {
	
	
    

    
    private int yearOfStudy;
    private Faculty faculty;
    private Transcript transcript = new Transcript(this.getId());
    Vector<Course> myCourses = new Vector<Course>();
    private int allCredits;
    Vector<Course>coveredCourses = new Vector<Course>();
	HashMap<Course, Marks>courseMarks = new HashMap<Course, Marks>();
	public boolean isPassed = false;
	
	public Student(String firstName, String midName, String lastName, String email, String password, String id, int yos, Faculty faculty) {
		super(firstName, midName, lastName, email, password, id);
		this.yearOfStudy = yos;
		this.faculty = faculty;
	}
    
    public void registerCourse(Course course) {
    	if(Database.getCourses().contains(course) && course != null && !myCourses.contains(course)) {
    		allCredits += course.getCredits();

    		course.getTeacher().students.add(this);
    		myCourses.add(course);
			if(course.getPrerquesites()!= null && this.transcript.ids.contains(course.getPrerquesites().getId()))
				coveredCourses.add(course.getPrerquesites());
    	}
    }

    
	public void dropCourse(Course course) {
		if(Database.getCourses().contains(course) && myCourses.contains(course) && course != null)
			myCourses.remove(course);
    }

    public void showSchedule() {
    	for(int i=0;i<myCourses.size();i++) {
    		System.out.println(myCourses.get(i).getCourseSchedule());
    	}
    }

    public void sendOrder(Order order) {
    	Database.getOrders().add(order);
    }
    
    public void viewMarks(Course course) {
    	System.out.println(courseMarks.get(course));
    }
    
    public void viewCourseFiles(Course course) {
    	course.viewFiles();
    }

	@Override
	public String toString() {
		return super.toString() + "[category = Student" + ", yearOfStudy = " + yearOfStudy + ", faculty = " + faculty + "]";
	}
    
    
    public int getAllCredits() {
		return allCredits;
	}


	public void setAllCredits(int allCredits) {
		this.allCredits = allCredits;
	}


	public int getYearOfStudy() {
		return yearOfStudy;
	}


	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}


	public Faculty getFaculty() {
		return faculty;
	}


	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}


	public Transcript getTranscript() {
		
		return transcript;
	}


	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	@Override
	public int compareTo(Student s) {
		 return this.getFirstName().compareTo(s.getFirstName());
	}

	@Override
	public int compareTo() {
		// TODO Auto-generated method stub
		return 0;
	}
}

