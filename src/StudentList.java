import java.util.ArrayList;

public class StudentList { // Need for Simulation

    ArrayList<Student> enrolledStudents;

    public StudentList() {
        DBManager DB = new DBManager();
        enrolledStudents = DB.readFromDataBaseStudents();
    }

    public Student searchForStudentID(int ID) {
        for (Student student : enrolledStudents) {
            if (ID == student.getStudentId()) {
                return student;
            }
        }
        System.out.println("No student with that ID exists!");
        return null;
    }

}
