package finalProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test implements Serializable{
	
	
	public Test() throws ClassNotFoundException, IOException {
		Database.store();
//		Database.desCourses();
//		Database.desStudent();
//		Database.desTeacher();
//		Database.desManager();
//		Database.desAdmin();
//		Database.desTechSupporters();
//		Database.desUsers();
//		Database.desOrders();
		Database.restore();
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException  {
		
		
		
		BufferedReader reader = new  BufferedReader(new InputStreamReader(System.in));
		
		
//		Database.store();
//		Database.desCourses();
//		Database.desStudent();
//		Database.desTeacher();
//		Database.desManager();
//		Database.desAdmin();
//		Database.desTechSupporters();
//		Database.desUsers();
//		Database.desOrders();
		
		Admin admin1 = new Admin("Jade", "Middleton", "Elordy", "jElordy", "123456", "01admin");
		Database.getUsers().add(admin1);
		Database.getAdmins().add(admin1);
		
		Course oop = new Course("1", "oop", 3, "01teacher", "this is oop", null);
		Course algo = new Course("2", "algo", 3, "02teacher", "this is algo", null);
		Course data = new Course("3", "db", 3, "03teacher", "this is db", null);
		Database.getCourses().add(oop);
		Database.getCourses().add(algo);
		Database.getCourses().add(data);
		
//		Manager manager1 = null;
		Manager managerr = new Manager("Kate", "Brown", "Joullie", "kJoul", "123katy", "01manager");
		Order order1 = new Order(OrderType.FROMMANAGER);
		managerr.sendOrder(order1);

		TechSupport techGuy1 = new TechSupport("Timberlake", "Grande", "Gomez", "timgg", "444444", "01techguy");
//		Teacher teacherr = new Teacher("Lolly", "Beth", "Biverly", "lBeth", "teacher", "01teacher", Status.PHD);
//		Teacher teacherr1 = new Teacher("aksh", "aks", "kashh", "aa", "teacher2", "02teacher", Status.PHD);
//		Teacher teacherr2 = new Teacher("bobur", "Bob", "Bive", "bb", "teacher3", "03teacher", Status.PHD);
		Student studentt = new Student("Jake", "Jillenhoul", "Mettew", "jMettew", "jM09", "11student", 1, Faculty.ISE);
		Student studentt1 = new Student("Bake", "Jillenhoul", "Mettew", "lll", "lol", "12student", 1, Faculty.ISE);
		Student studentt2 = new Student("Cake", "Jillenhoul", "Mettew", "kjk", "kkk", "13student", 1, Faculty.ISE);
		Student studentt3 = new Student("Ake", "Jillenhoul", "Mettew", "cvc", "ccc", "14student", 1, Faculty.ISE);
		
		Database.getUsers().add(techGuy1);
		Database.getUsers().add(studentt);
		Database.getUsers().add(studentt1);
		Database.getUsers().add(studentt2);
		Database.getUsers().add(studentt3);
		Database.getUsers().add(managerr);
//		Database.getUsers().add(teacherr);
//		Database.getUsers().add(teacherr1);
//		Database.getUsers().add(teacherr2);
		Database.getManagers().add(managerr);
//		Database.getTeachers().add(teacherr);
		Database.getStudents().add(studentt);
		Database.getStudents().add(studentt1);
		Database.getStudents().add(studentt2);
		Database.getStudents().add(studentt3);
		Database.getTechSupporters().add(techGuy1);
//		Database.getTeachers().add(teacherr1);
//		Database.getTeachers().add(teacherr2);
		
		User userr = null;
//		
		while(true) {
			
			
			
			try {
//				Database.restore();
			
			
				System.out.println("Hello, if you'd like enter as an admin, press 1");
				System.out.println("if you'd like enter as a manager, press 2");
				System.out.println("if you'd like enter as a tech support, press 3");
				System.out.println("if you'd like enter as a teacher, press 4");
				System.out.println("if you'd like enter as a student, press 5");
				System.out.println("if you'd like enter exit, press 0");
				
				
				int start = Integer.parseInt(reader.readLine());
				if(start>0) {
					System.out.println("Fill autorizathion data");
					System.out.println("Enter email: ");
					String in = reader.readLine();
//					System.out.println(Database.users.size());
					for(User user: Database.getUsers()) {
						if(user.getEmail().equals(in))
							userr = user;
					}
					
					if(userr == null) {
						System.err.println("Wrong email!");
						break;
					}
					else {
						userr.login();
					}

				}
				if(start == 0)  {break;}
				else if(start == 1) {
					Admin admin = (Admin) userr;
					while(true) {
						System.out.println("Press 1 to change password");
						System.out.println("Press 2 to view news");
						System.out.println("Press 3 to add user");
						System.out.println("Press 4 to remove user");
						System.out.println("Press 5 to update user");
						System.out.println("Press 6 to see login files");
						System.out.println("Press 0 to exit");
						
						int adminStart = Integer.parseInt(reader.readLine());;
						if(adminStart == 0) {
							break; 
						}
						else if(adminStart == 1) { admin.changePassword();}
						else if(adminStart == 2) {admin.viewNews(); }
						else if(adminStart == 3) {
							System.out.println("To add manager press m");
							System.out.println("To add teacher press tch");
							System.out.println("To add tech support pres ts");
							System.out.println("To add student press s");
							String toAdd = reader.readLine();
							System.out.println("Please, fill the form in following form: first name, middle name, last name, email, password, id");
							String firstName = reader.readLine();
							String midName = reader.readLine();
							String lastName = reader.readLine();
							String email = reader.readLine();
							String password = reader.readLine();
							String id = reader.readLine();
							if(toAdd.equals("m")) {
								Manager manager = new Manager(firstName, midName, lastName, email, password, id);
								admin.add(manager);	
								System.out.println("Manager was added!");
							}
							else if(toAdd.equals("tch")) {
								System.out.println("What status teacher has?");
								System.out.println("Press 1 if PROFESSOR");
								System.out.println("Press 2 if SENOR_LECTURE");
								System.out.println("Press 3 if PHD");
								int status = Integer.parseInt(reader.readLine());
								if(status == 1) {
									Teacher teacher = new Teacher(firstName, midName, lastName, email, password, id, Status.PROFESSOR);
									admin.add(teacher);	
								}
								else if(status == 2) {
									Teacher teacher = new Teacher(firstName, midName, lastName, email, password, id, Status.SENIOR_LECTURE);
									admin.add(teacher);	
								}
								else if(status == 3) {
									Teacher teacher = new Teacher(firstName, midName, lastName, email, password, id, Status.PHD);
									admin.add(teacher);	
								}
								
								System.out.println("Teacher was added!");
							}
							else if(toAdd.equals("ts")) {
								TechSupport techSupport = new TechSupport(firstName, midName, lastName, email, password, id);
								admin.add(techSupport);	
								System.out.println("Tech Support was added!");
							}
							else if(toAdd.equals("s")) {
								System.out.println("Please, fill in student information in this order: year of study, faculty:");
								int yos = Integer.parseInt(reader.readLine());
								System.out.println("Press 1 if FIT");
								System.out.println("Press 2 if BS");
								System.out.println("Press 3 if FOG");
								System.out.println("Press 4 if GEOG");
								System.out.println("Press 5 if MCM");
								System.out.println("Press 6 if ISE");
								System.out.println("Press 7 if KMA");
								int faculty = Integer.parseInt(reader.readLine());
								if(faculty == 1) {
									Student student = new Student(firstName, midName, lastName, email, password, id, yos, Faculty.FIT);
									admin.add(student);	
								}
								else if(faculty == 2) {
									Student student = new Student(firstName, midName, lastName, email, password, id, yos, Faculty.BS);
									admin.add(student);	
								}
								else if(faculty == 3) {
									Student student = new Student(firstName, midName, lastName, email, password, id, yos, Faculty.FOG);
									admin.add(student);	
								}
								else if(faculty == 4) {
									Student student = new Student(firstName, midName, lastName, email, password, id, yos, Faculty.GEOG);
									admin.add(student);	
								}
								else if(faculty == 5) {
									Student student = new Student(firstName, midName, lastName, email, password, id, yos, Faculty.MCM);
									admin.add(student);	
								}
								else if(faculty == 6) {
									Student student = new Student(firstName, midName, lastName, email, password, id, yos, Faculty.ISE);
									admin.add(student);	
								}
								else {
									Student student = new Student(firstName, midName, lastName, email, password, id, yos, Faculty.KMA);
									admin.add(student);	
								}
								
								System.out.println("Student was added!");
							}

						}
						else if(adminStart == 4) {
							System.out.println("Enter the id of user that you want to remove:");
							String rId = reader.readLine();
							for(int i=0;i<Database.getUsers().size();i++) {
								if(Database.getUsers().get(i).getId().equals(rId)) {
									Database.getUsers().remove(i);
									break;
									//database method update
								}
							}
						
							
						}
						else if(adminStart == 5) {
							System.out.println("If you wannt to update student and his year of study, press 1");
							System.out.println("If you wannt to update student and his faculty, press 2");
							System.out.println("If you wannt to update teacher and his status, press 3");
							int upd = Integer.parseInt(reader.readLine());
							if(upd == 1) {
								System.out.println("Enter student id and year of study");
								String idd = reader.readLine();
								int yos = Integer.parseInt(reader.readLine());
								for(int i=0;i<Database.getStudents().size();i++) {
									if(Database.getStudents().get(i).getId().equals(idd)) {
										Database.getStudents().get(i).setYearOfStudy(yos);
										break;
									}
								}
							}
							else if(upd == 2) {
								System.out.println("Enter student id");
								String idd = reader.readLine();
								System.out.println("Press 1 to set FIT");
								System.out.println("Press 2 to set BS");
								System.out.println("Press 3 to set FOG");
								System.out.println("Press 4 to set GEOG");
								System.out.println("Press 5 to set MCM");
								System.out.println("Press 6 to set ISE");
								System.out.println("Press 7 to set KMA");
								int faculty =Integer.parseInt(reader.readLine());
								for(int i=0;i<Database.getStudents().size();i++) {
									if(Database.getStudents().get(i).getId().equals(idd)) {
										if(faculty == 1) {
											Database.getStudents().get(i).setFaculty(Faculty.FIT);
											break;
										}
										else if(faculty == 2) {
											Database.getStudents().get(i).setFaculty(Faculty.BS);
											break;
										}	
										else if(faculty == 3) {
											Database.getStudents().get(i).setFaculty(Faculty.FOG);
											break;
										}
										else if(faculty == 4) {
											Database.getStudents().get(i).setFaculty(Faculty.GEOG);
											break;
										}
										else if(faculty == 5) {
											Database.getStudents().get(i).setFaculty(Faculty.MCM);
											break;
										}
										else if(faculty == 6) {
											Database.getStudents().get(i).setFaculty(Faculty.ISE);
											break;
										}
										else if(faculty == 7) {
											Database.getStudents().get(i).setFaculty(Faculty.KMA);
											break;
										}
									}
					
								}
							
							}
							else if(upd == 3) {
								System.out.println("Enter teacher's id and set teacher's status");
								String idd = reader.readLine();
								System.out.println("Press 1 to set PHD");
								System.out.println("Press 2 to set SENIOT_LECTURE");
								System.out.println("Press 3 to set PROFESSOR");
								int st = Integer.parseInt(reader.readLine());
								for(int i=0;i<Database.getTeachers().size();i++) {
									if(Database.getTeachers().get(i).getId().equals(idd)) {
										if(st == 1) {
											Database.getTeachers().get(i).setStatus(Status.PHD);
											break;
										}
										else if(st == 2) {
											Database.getTeachers().get(i).setStatus(Status.SENIOR_LECTURE);
											break;
										}
										else if(st == 3) {
											Database.getTeachers().get(i).setStatus(Status.PROFESSOR);
											break;
										}
									}
									else System.err.println("Teacher not found");
								
								}
							}
							
						
						}
						else if (adminStart == 6) {
							admin.seeLogFiles();
							
						}
					
						
					}
				}
				
				else if(start == 2) {
					Manager manager1 = (Manager) userr;
					while(true) {
						System.out.println("Press 1 to change password");
						System.out.println("Press 2 to view news");
						System.out.println("Press 3 to create news");
						System.out.println("Press 4 to remove news");
						System.out.println("Press 5 to send message to teacher");
						System.out.println("Press 6 to create course");
						System.out.println("Press 7 to see message from tech support");
						System.out.println("Press 8 to approve course");
						System.out.println("Press 9 to send order");
						System.out.println("Press 10 to view student list");
					    System.out.println("Press 11 to view all people");
						System.out.println("Press 0 to exit");
						int managerStart = Integer.parseInt(reader.readLine());
						if(managerStart == 0) { break; }
						if(managerStart == 1) {manager1.changePassword(); }
						else if(managerStart == 2) {manager1.viewNews(); }
						else if(managerStart == 3) {
							System.out.println("Enter news' id and write news");
							int newsId = Integer.parseInt(reader.readLine());
							String forNews = reader.readLine();
							News news1 = new News(forNews, newsId);
							Database.getNews().add(news1);
							System.out.println("News was creared!");
							
						}
						else if(managerStart == 4) {
							System.out.println("Please, enter news' id:");
							int newsId = Integer.parseInt(reader.readLine());
							for(int i=0;i<Database.getNews().size();i++) {
								if(Database.getNews().get(i).getId() == newsId) {
									Database.getNews().remove(i);
									break;
								}
							}
							System.out.println("News was deleted!");
							
						}
						else if(managerStart == 5) {
							System.out.println("Please, write teacher's email and your message");
							String emaill = reader.readLine();
							String msg = reader.readLine();
							manager1.sendMsgToTch(emaill, msg);
							System.out.println("Message was sent!");
						
						}
						else if(managerStart == 6) {
							System.out.println("Please, enter data in the following form: id, name, credits, teacher's id, desciption, prerequisite's id");
							String idd = reader.readLine();
							String name = reader.readLine();
							int credits = Integer.parseInt(reader.readLine());
							String tchId = reader.readLine();
							String description = reader.readLine();
							System.out.println("If there if no prerequisites then enter null");
							String prereqId = reader.readLine();
						
							Course prepeq = null;
							
							for(int i=0;i<Database.getCourses().size();i++) {
								if(Database.getCourses().get(i).getId().equals(prereqId)) {
									prepeq = Database.getCourses().get(i);
									break;
								}
							}
							Course course = new Course(idd, name, credits, tchId, description, prepeq);
							CourseSchedule schedule = null;
							System.out.println("Please, enter course time: day, hour, minute, room");
							String day = reader.readLine();
							int hour = Integer.parseInt(reader.readLine());
							int minute = Integer.parseInt(reader.readLine());
							int room = Integer.parseInt(reader.readLine());
							if(day == "Monday") {
								schedule = new CourseSchedule(WeekDays.MON, hour, minute, room); 
							}
							else if(day == "Tuesday") {
								schedule = new CourseSchedule(WeekDays.TUE, hour, minute, room); 
							}
							else if(day == "Wednesday") {
								schedule = new CourseSchedule(WeekDays.WED, hour, minute, room); 
							}
							else if(day == "Thursday") {
								schedule = new CourseSchedule(WeekDays.THU, hour, minute, room); 
							}
							else if(day == "Friday") {
								schedule = new CourseSchedule(WeekDays.FRI, hour, minute, room); 
							}
							else {
								schedule = new CourseSchedule(WeekDays.SAT, hour, minute, room); 
							}
							manager1.createCourse(course, schedule);
							System.out.println("Course succesfully created!");
						}
							
						
						else if(managerStart == 7) {System.out.println(manager1.getMessageFromTech()); }
						else if(managerStart == 8) {
							System.out.println("Please, enter student's id");
							String idd = reader.readLine();
							Student student2 = null;
							for(int i=0;i<Database.getStudents().size();i++) {
								if(Database.getStudents().get(i).getId().equals(idd)) {
									student2 = Database.getStudents().get(i);
									break;
								}
							}
							if(manager1.approveCourse(student2)) System.out.println("Courses are approved!");
							else System.out.println("Courses aren't approved!");
							
						}
						else if(managerStart == 9) {
							Order order = new Order(OrderType.FROMMANAGER);
							manager1.sendOrder(order);
							System.out.println("Order was sent!");
							
						}
						else if(managerStart == 10) {
					        manager1.viewListStudents();
					        
					       }
						else if(managerStart == 11) {
					        manager1.viewAllPerson();
					      
				       }
					}
				}
				
				else if(start == 3) {
					TechSupport techGuy = (TechSupport) userr;
					while(true) {
						System.out.println("Press 1 to change password");
						System.out.println("Press 2 to view news");
						System.out.println("Press 3 to see accepted orders");
						System.out.println("Press 4 to see not processed orders");
						System.out.println("Press 5 to accept order");
						System.out.println("Press 0 to exit");
						int techStart = Integer.parseInt(reader.readLine());
						if(techStart == 0) {break; }
						else if(techStart == 1) {techGuy.changePassword(); }
						else if(techStart == 2) {techGuy.viewNews(); }
						else if(techStart == 3) {techGuy.viewAcceptedOrders(); }
						else if(techStart == 4) {techGuy.viewNotAcceptedOrders(); }
						else if(techStart == 5) {
							for(int i=0;i<Database.getOrders().size();i++) {
								if(Database.getOrders().get(i).getStatus() == OrderStatus.NOTPROCESSED)
									techGuy.acceptOrder(Database.getOrders().get(i));
							}
							System.out.println("Not processsed orders were processed!");
							
						}
					}
				}
				
				else if(start == 4) {
					Teacher teacher1 = (Teacher)userr;
					while(true) {
						System.out.println("Press 1 to change password");
						System.out.println("Press 2 to view news");
						System.out.println("Press 3 to add course");
						System.out.println("Press 4 to send order");
						System.out.println("Press 5 to put marks");
						System.out.println("Press 6 to view students marks");
						System.out.println("Press 7 to view courses");
						System.out.println("Press 8 to view course students");
						System.out.println("Press 9 to see message from manager");
						System.out.println("Press 10 to add course file");
						System.out.println("Press 11 to remove course file");
						System.out.println("Press 0 to exit");
						int tchStart = Integer.parseInt(reader.readLine());
						if(tchStart == 0) {break; }
						else if(tchStart == 1) {teacher1.changePassword(); }
						else if(tchStart == 2) {teacher1.viewNews();}
						else if(tchStart == 3) {
							System.out.println("Please, write id of course");
							String idd = reader.readLine();
							Course addingCourse = null;
							for(int i=0;i<Database.getCourses().size();i++) {
								if(Database.getCourses().get(i).getId().equals(idd)) {
									addingCourse = Database.getCourses().get(i);
									break;
								}
								
							}
							if(addingCourse == null)System.out.println("Such course doesn't exist!");
							else {
								teacher1.addCourse(addingCourse);
								System.out.println("Course was succesfully added!");
							}
							
						}
						else if(tchStart == 4) {
							System.out.println("What type of problem you have? a) registration, b) id, c) login, d)finance");
							String c = reader.readLine();
							Order order2 = null;
							if(c == "a") {
								order2 = new Order(OrderType.REGISTRATION);
							}
							else if(c == "b") order2 = new Order(OrderType.ID);
							else if(c == "c") order2 = new Order(OrderType.LOGIN);
							else if(c == "d") order2 = new Order(OrderType.FINANCE);
							else System.err.println("Error!");
							teacher1.sendOrder(order2);
							System.out.println("Order was sent");
							
						}
						else if(tchStart == 5) {
							System.out.println("Please, enter id of student and course");
							String sId = reader.readLine();
							String cId = reader.readLine();
							Course course1 = null;
							Student student2 = null;
							for(int i=0;i<teacher1.courses.size();i++) {
								if(teacher1.courses.get(i).getId().equals(cId)) {
									course1 = teacher1.courses.get(i);
									break;
								}
							}
							for(int i=0;i<teacher1.students.size();i++) {
								if(teacher1.students.get(i).getId().equals(sId)) {
									student2 = teacher1.students.get(i);
									break;
								}
							}
							if(course1 == null || student2 == null) System.err.println("Wrong id!");
							else {
								System.out.println("Please, enter first attestation, second attestation, final point");
								double firstAtt = Double.parseDouble(reader.readLine());
								double secondAtt = Double.parseDouble(reader.readLine());
								double finalPt = Double.parseDouble(reader.readLine()); 
								BuilderReal mark = (BuilderReal) new BuilderReal().setFirstAttestation(firstAtt).setSecondAttestation(secondAtt).setFinalPoint(finalPt);
								teacher1.putMarks(student2, course1, mark.mark);
								System.out.println("Points were awarded!");
							}
						
						}
						else if(tchStart == 6) {
							System.out.println("Enter course's id that you want");
							String idd = reader.readLine();
							Course curCourse = null;
							for(int i = 0;i < Database.getCourses().size();i++) {
								if(Database.getCourses().get(i).getId().equals(idd)) {
									curCourse = Database.getCourses().get(i);
									break;
								}	
							}
							if(curCourse == null || !teacher1.courses.contains(curCourse)) System.err.println("Wrong course!");
							else teacher1.viewStudentMarks(curCourse);
							
						}
						else if(tchStart == 7) {
							teacher1.viewCourses();
						
						}
						else if(tchStart == 8) {
							System.out.println("Please, enter course id");
							String idd = reader.readLine();
							Course curCourse = null;
							for(int i = 0;i < Database.getCourses().size();i++) {
								if(Database.getCourses().get(i).getId().equals(idd)) {
									curCourse = Database.getCourses().get(i);
									break;
								}	
							}
							if(curCourse == null || !teacher1.courses.contains(curCourse)) System.err.println("Wrong course!");
							else teacher1.viewCourseStudents(curCourse);
							
							
						}
						else if(tchStart == 9) {System.out.println(teacher1.getMessage());}
						else if(tchStart == 10) {
							System.out.println("Please, enter course id and file");
							String idd = reader.readLine();
							String file = reader.readLine();
							CourseFile cFile = new CourseFile(file);
							Course curCourse = null;
							for(int i = 0;i < Database.getCourses().size();i++) {
								if(Database.getCourses().get(i).getId().equals(idd)) {
									curCourse = Database.getCourses().get(i);
									break;
								}	
							}
							if(curCourse == null || !teacher1.courses.contains(curCourse)) System.err.println("Wrong course!");
							else {
								teacher1.addFiles(curCourse, cFile);
								System.out.println("File was added!");
							}
						}
						else if(tchStart == 11) {
							System.out.println("Please, enter course id and file");
							String idd = reader.readLine();
							String file = reader.readLine();
							CourseFile cFile = new CourseFile(file);
							Course curCourse = null;
							for(int i = 0;i < Database.getCourses().size();i++) {
								if(Database.getCourses().get(i).getId().equals(idd)) {
									curCourse = Database.getCourses().get(i);
									break;
								}	
							}
							if(curCourse == null || !teacher1.courses.contains(curCourse)) System.err.println("Wrong course!");
							else {
								teacher1.removeFiles(curCourse, cFile);
								System.out.println("File was removed!");
							}
						}
					}
				}
				
				else if(start == 5) {
					Student student1 = (Student)userr;
					while(true){
						System.out.println("Press 1 to change password");
						System.out.println("Press 2 to view news");
						System.out.println("Press 3 to register to course");
						System.out.println("Press 4 to drop course");
						System.out.println("Press 5 to show schedule");
						System.out.println("Press 6 to send order");
						System.out.println("Press 7 to view course marks");
						System.out.println("Press 8 to view transcript");
						System.out.println("Press 9 to view course file");
						System.out.println("Press 10 to view current courses");
						System.out.println("Press 11 to view covered couerses");
						System.out.println("Press 0 to exit");
						int stStart = Integer.parseInt(reader.readLine());
						if(stStart == 0) {break; }
						else if(stStart == 1) {student1.changePassword();}
						else if(stStart == 2) {student1.viewNews();}
						else if(stStart == 3) {
							System.out.println("Enter course's id");
							String idd = reader.readLine();
							Course regCourse = null;
							for(int i = 0;i < Database.getCourses().size();i++) {
								if(Database.getCourses().get(i).getId().equals(idd)) {
									regCourse = Database.getCourses().get(i);
									break;
								}	
							}
							if(regCourse == null || student1.myCourses.contains(regCourse)) System.err.println("Wrong course!");
							else {
								student1.registerCourse(regCourse);
								System.out.println(regCourse.getName() + " succesfully added!");
							}
							
						}
						else if(stStart == 4) {
							System.out.println("Enter course's id");
							String idd = reader.readLine();
							Course dropCourse = null;
							for(int i = 0;i < Database.getCourses().size();i++) {
								if(Database.getCourses().get(i).getId().equals(idd)) {
									dropCourse = Database.getCourses().get(i);
									break;
								}	
							}
							if(dropCourse == null || !student1.myCourses.contains(dropCourse)) System.err.println("Wrong course!");
							else {
								student1.dropCourse(dropCourse);
								System.out.println(dropCourse.getName() + " succesfully removed!");
							}
							
					
							
						}
						else if(stStart == 5) {
							student1.showSchedule();
							
						}
						else if(stStart == 6) {
							System.out.println("What type of problem you have? a) registration, b) id, c) login, d)finance");
							String c = reader.readLine();
							Order order2 = null;
							if(c.equals("a")) {
								order2 = new Order(OrderType.REGISTRATION);
								System.out.println("Order was sent");
							}
							else if(c.equals("b")) {
								order2 = new Order(OrderType.ID);
								System.out.println("Order was sent");
							}
							else if(c.equals("c")) {
								order2 = new Order(OrderType.LOGIN);
								System.out.println("Order was sent");
							}
							else if(c.equals("d")) {
								order2 = new Order(OrderType.FINANCE);
								System.out.println("Order was sent");
							}
							else {
								System.err.println("Error!");
							}
							student1.sendOrder(order2);
							
							
						}
						else if(stStart == 7) {
							System.out.println("Please, enter course id");
							String idd = reader.readLine();
							Course curCourse = null;
							for(int i = 0;i < Database.getCourses().size();i++) {
								if(Database.getCourses().get(i).getId().equals(idd)) {
									curCourse = Database.getCourses().get(i);
									break;
								}	
							}
							if(curCourse == null || !student1.myCourses.contains(curCourse)) System.err.println("Wrong course!");
							else student1.viewMarks(curCourse);
		
						}
						else if(stStart == 8) {
							System.out.println("Total GPA: " + student1.getTranscript().getGpa());
							 for(int i=0;i<student1.getTranscript().grades.size();i++) {
								 System.out.println(student1.getTranscript().grades.get(i));
							 }
							 
							 
						}
						else if(stStart == 9) {
							System.out.println("Please, enter course id");
							String idd = reader.readLine();
							Course curCourse = null;
							for(int i = 0;i < Database.getCourses().size();i++) {
								if(Database.getCourses().get(i).getId().equals(idd)) {
									curCourse = Database.getCourses().get(i);
									break;
								}	
							}
							if(curCourse == null || !student1.myCourses.contains(curCourse)) System.err.println("Wrong course!");
							else student1.viewCourseFiles(curCourse);
						}
						else if(stStart == 10) {
							for(int i=0;i<student1.myCourses.size();i++) {
								System.out.println(student1.myCourses.get(i));
							}
							
						}
						else if(stStart == 11) {
							for(int i=0;i<student1.coveredCourses.size();i++) {
								System.out.println(student1.coveredCourses.get(i));
							}
						}
					}
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
