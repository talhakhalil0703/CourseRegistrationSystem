import java.util.ArrayList;

public class DBManager {
	
	ArrayList <Course> courseList;
	ArrayList <Student> studentList;

	public DBManager () {
		courseList = new ArrayList<Course>();
		studentList =  new ArrayList<Student>();
	}

	public ArrayList readFromDataBaseCourses() {
		courseList.add(new Course ("ENGG", 233));
		courseList.add(new Course ("ENSF", 409));
		courseList.add(new Course ("PHYS", 259));
		courseList.add(new Course ("ENEL", 471));
		courseList.add(new Course ("ENEL", 441));
		courseList.add(new Course ("COMS", 363));
		courseList.add(new Course ("ENEL", 453));
		return courseList;
	}

	public ArrayList readFromDataBaseStudents() {
		studentList.add(new Student ("Sara", 1));
		studentList.add(new Student ("Sam", 2));
		studentList.add(new Student ("Tips", 3));
		studentList.add(new Student ("Herbe", 4));
		studentList.add(new Student ("Denis", 5));
		return studentList;
	}


}
