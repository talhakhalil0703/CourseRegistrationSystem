import java.util.ArrayList;

public class Student {

    private String studentName;
    private int studentId;
    private ArrayList<Registration> studentRegList;
    private int studentClassesRegisteredFor = 0;

    public Student(String studentName, int studentId) {
        this.setStudentName(studentName);
        this.setStudentId(studentId);
        studentRegList = new ArrayList<Registration>();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        String st = "Student Name: " + getStudentName() + "\n" +
                "Student Id: " + getStudentId() + "\n\n";
        return st;
    }

    public void addRegistration(Registration registration) {
        if (studentClassesRegisteredFor <= 6) {
            studentRegList.add(registration);
            studentClassesRegisteredFor++;
            System.out.println("The student has been Registered!");
        } else {
            System.out.println("The student has registered for a maximum of 6 classes already!");
        }
        return;
    }

    public void removeRegistration(Registration registration) {
        if (studentRegList.size() > 0) {
            studentRegList.remove(registration);
            studentClassesRegisteredFor--;
            return;
        }
    }

    public ArrayList<Registration> getStudentRegList() {
        return studentRegList;
    }

    public void printCoursesTaken() {
        int num;
        String name;

        System.out.println("Student name: " + studentName + " is taking the following classes: ");
        for (Registration reg : getStudentRegList()) {
            num = reg.getTheOffering().getTheCourse().getCourseNum();
            name = reg.getTheOffering().getTheCourse().getCourseName();
            System.out.println(name + " " + String.valueOf(num));
        }
    }

    public void removeFromClass(Course temp) {
        for (Registration reg : getStudentRegList()) {
            if (reg.getTheOffering().getTheCourse() == temp) {
                reg.getTheOffering().removeStudent(this);
                break;
            }
        }
    }

}
