package finalProject;

import java.sql.Date;
import java.util.Vector;

public class Course implements Serializable{
  
    private String id;
    private String name;
    private int credits;
    private Teacher teacher;
    private String teacherId;
    private Date finalDate;
    private String description;
    private CourseSchedule courseSchedule;
    private Course prerquesites;
    Vector<CourseFile> courseFiles = new Vector<CourseFile>();
    
    

    public Course(String id, String name, int credits, String teacherId, String description, Course prerquesites) {
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.description = description;
		this.prerquesites = prerquesites;
//		this.teacher = findTeacher(teacherId);
		this.teacherId = teacherId;
		
	}

    public Teacher findTeacher(String id) {
    	Teacher t = null;
    	for(int i=0;i<Database.getTeachers().size();i++) {
			if(Database.getTeachers().get(i).getId().equals(id)) {
				t = Database.getTeachers().get(i);
				break;
			}
		}
    	return t;
    	
    }
	public void viewFiles() {
    	for(int i=0;i<courseFiles.size();i++) {
    		System.out.println(courseFiles.get(i));//убрать систем аут
    	}
    }
    
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", credits=" + credits + ", teacher=" + teacher + ", finalDate="
				+ finalDate + ", description=" + description + ", prerquesites=" + prerquesites + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CourseSchedule getCourseSchedule() {
		return courseSchedule;
	}

	public void setCourseSchedule(CourseSchedule courseSchedule) {
		this.courseSchedule = courseSchedule;
	}
	
    public Course getPrerquesites() {
		return prerquesites;
	}

	public void setPrerquesites(Course prerquesites) {
		this.prerquesites = prerquesites;
	}

	public Teacher getTeacher() {
		
		Teacher t = null;
    	for(int i=0;i<Database.getTeachers().size();i++) {
			if(Database.getTeachers().get(i).getId().equals(this.teacherId)) {
				t = Database.getTeachers().get(i);
				break;
			}
		}
    	this.teacher = t;
    	return t;
	}   
}

