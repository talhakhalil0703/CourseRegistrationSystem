import java.util.ArrayList;

public class Course {

    private String courseName;
    private int courseNum;
    private ArrayList<Course> preReq;
    private ArrayList<CourseOffering> offeringList;

    public Course(String courseName, int courseNum) {
        this.setCourseName(courseName);
        this.setCourseNum(courseNum);
        // Both of the following are only association
        preReq = new ArrayList<Course>();
        offeringList = new ArrayList<CourseOffering>();
    }

    public void addOffering(CourseOffering offering) {
        if (offering != null && offering.getTheCourse() == null) {
            offering.setTheCourse(this);
            if (!offering.getTheCourse().getCourseName().equals(courseName)
                    || offering.getTheCourse().getCourseNum() != courseNum) {
                System.err.println("Error! This section belongs to another course!");
                return;
            }

            offeringList.add(offering);
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    @Override
    public String toString() {
        String st = "\n";
        st += getCourseName() + " " + getCourseNum();
        st += "\nAll course sections:\n";
        for (CourseOffering c : offeringList)
            st += c;
        st += "\n-------\n";
        return st;
    }

    public void printCourseOfferings() {
        int numOfOfferings = offeringList.size();
        System.out.print("These are the following sections offerd: ");
        for (int i = 0; i < numOfOfferings; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public CourseOffering getCourseOfferingAt(int i) {
        if (i < 0 || i >= offeringList.size()) {
            System.out.println("This offering number does not exist!");
            return null;
        } else
            return offeringList.get(i);
    }

}
