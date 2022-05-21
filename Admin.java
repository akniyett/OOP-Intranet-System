package finalProject;

import java.util.Vector;

public class Admin extends User implements Serializable{
	
	
	
    public Admin(String firstName, String midName, String lastName, String email, String password, String id) {
		super(firstName, midName, lastName, email, password, id);
	}


	public void add(User human) {
		
		if(human instanceof Teacher) {
			Teacher t = (Teacher) human;
			Database.getTeachers().add(t);
		}
		if(human instanceof Manager) {
			Manager m = (Manager) human;
			Database.getManagers().add(m);
		}
		if(human instanceof TechSupport) {
			TechSupport ts = (TechSupport) human;
			Database.getTechSupporters().add(ts);
			
		}
		if(human instanceof Student) {
			Student s = (Student) human;
			Database.getStudents().add(s);
		}
		
		Database.getUsers().add(human);

    }

    
    public void remove(User human) {
    	super.db.getUsers().remove(human);
    }

    public void updateStudent(Student s, int yos) {
    	s.setYearOfStudy(yos);
    }
    
    public void updateStudent(Student s, Faculty faculty) {
    	s.setFaculty(faculty);
    }
    
    public void updateTeacher(Teacher t, Status status) {
    	t.setStatus(status);
    }
  
    public void seeLogFiles() {
    	for(int i = 0; i < super.db.getUsers().size(); i++) {
			System.out.println(super.db.getUsers().get(i).getEmail() + " "+ super.db.getUsers().get(i).getPassword());
			
		}
    }
}

