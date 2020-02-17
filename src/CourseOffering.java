import java.util.ArrayList;

public class CourseOffering {

    private int secNum;
    private int secCap;
    private Course theCourse;
    //private ArrayList<Student> studentList;
    private ArrayList<Registration> offeringRegList;

    public CourseOffering(int secNum, int secCap) {
        this.setSecNum(secNum);
        this.setSecCap(secCap);
        offeringRegList = new ArrayList<Registration>();
    }

    public int getSecNum() {
        return secNum;
    }

    public void setSecNum(int secNum) {
        this.secNum = secNum;
    }

    public int getSecCap() {
        return secCap;
    }

    public void setSecCap(int secCap) {
        this.secCap = secCap;
    }

    public Course getTheCourse() {
        return theCourse;
    }

    public void setTheCourse(Course theCourse) {
        this.theCourse = theCourse;
    }

    @Override
    public String toString() {
        String st = "\n";
        st += getTheCourse().getCourseName() + " " + getTheCourse().getCourseNum() + "\n";
        st += "Section Num: " + getSecNum() + ", section cap: " + getSecCap() + "\n";
        for (Registration reg : offeringRegList){
        	st += reg.getTheStudent().getStudentName();
        	st += "\n";
		}
        return st;
    }

    public void addRegistration(Registration registration) {
        offeringRegList.add(registration);
    }

    public void removeRegistration(Registration registration) {
        offeringRegList.remove(registration);
    }

    public void removeStudent(Student student) {
        for (Registration reg : offeringRegList) {
            if (reg.getTheStudent() == student) {
                reg.removeRegistration();
                return;
            }
        }
    }
}
