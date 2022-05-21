package finalProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;


/**
 */
public class Transcript implements Serializable{

//    public Transcript(String firstName, String midName, String lastName, String email, String password, String id,
//			int yos, Faculty faculty) {
//		super(firstName, midName, lastName, email, password, id, yos, faculty);
//		// TODO Auto-generated constructor stub
//	}
	

	private double gpa;

    private Student student;
    private String studentId;
    private double courseSum = 0;
    Vector<String>ids = new Vector<String>();
    
    public Transcript(String id) {
    	this.studentId = id;
    	
    }
    
    Vector<String> grades = new Vector<String>();
    public Student findStudent() {
    	Student s = null;
    	for(int i=0;i<Database.getStudents().size();i++) {
    		if(Database.getStudents().get(i).getId().equals(studentId)) {
    			s = Database.getStudents().get(i);
    			break;
    		}
    	}
    	this.student = s;
    	return student;
    }
//    private HashMap<Course, Marks> marks;
    
    public String trans(Course course, Marks mark) {
    	
//    	sum = mark.final_point + mark.first_attestation + mark.second_attestation;
    	int[] marks = {100, 95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 0};
        String[] gpa = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F"};
        double[] part = {4, 3.67, 3.33, 3, 2.67, 2.33, 2, 1.67, 1.33, 1, 0};
        int index = 0;
        double curGpa = 0;
        for(int i = 0; i < marks.length; i++){
            if(marks[i + 1] <= mark.sum() && mark.sum() <= marks[i]){
                index = i;
                break;
            }
        }
        mark.cur = part[index];
		return "Course: " + course.getName() + " credits: " + course.getCredits() + " total point: " + mark.sum() + " gpa: " + gpa[index] + " grade: " + part[index];	
    	
    }

    public double gpaCalc() {
    	findStudent();
    	for (Entry<Course, Marks> entry : student.courseMarks.entrySet()) {
            Course k = entry.getKey();
            Marks v = entry.getValue();
            String s  = trans(k, v);
            grades.add(s);
            ids.add(k.getId());
            courseSum += k.getCredits() * v.cur; 
        }
    	
    	return courseSum;
    }
    
    public double getGpa() {
    	findStudent();
		return gpaCalc()/student.getAllCredits();
    }
}

