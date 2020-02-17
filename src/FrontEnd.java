import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FrontEnd {
    private Scanner scan;
    private CourseCatalogue cat;
    private StudentList studentList; //This is here so we have a list of students instead of writing a lot of code in main to simulate students

    public FrontEnd() {
        scan = new Scanner(System.in);
        cat = new CourseCatalogue();
        studentList = new StudentList();
    }

    private void printMenu() {
        System.out.println("1. Search catalogue courses");
        System.out.println("2. Add course to student courses");
        System.out.println("3. Remove course from student courses");
        System.out.println("4. View All courses in catalogue");
        System.out.println("5. View all courses taken by student");
        System.out.println("6. Quit");
        System.out.println();
        System.out.print("Please enter your selection: ");
    }

    public void menu() {
        while (true) {
            printMenu();
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    searchCatalogue();
                    break;
                case 2:
                    addCourseToStudentCourses();
                    break;
                case 3:
                    removeCourseFromStudentCourses();
                    break;
                case 4:
                    viewAllCourses();
                    break;
                case 5:
                    viewAllCoursesTakenByStudent();
                    break;
                case 6:
                    System.out.println("Thanks for using this course system!");
                    return;
                default:
                    System.out.println("Wrong selection!");
                    break;
            }
        }
    }

    private void viewAllCourses() {
        System.out.println(cat);
        printStars();
    }

    private void viewAllCoursesTakenByStudent() {
        int ID = askForStudentID();
        Student student = studentList.searchForStudentID(ID);
        if (student == null)
            return;
        student.printCoursesTaken();
        printStars();
    }

    private void searchCatalogue() {
        String name = askForCourseName();
        int num = askForCourseNumber();

        Course temp = cat.searchCat(name, num);
        if (temp != null) {
            System.out.println(temp);
        }

        printStars();
        return;
    }

    private void addCourseToStudentCourses() {
        int ID = askForStudentID();
        Student student = studentList.searchForStudentID(ID);

        if (student == null)
            return;

        scan.nextLine();
        String name = askForCourseName();
        int num = askForCourseNumber();
        Course temp = cat.searchCat(name, num);
        temp.printCourseOfferings();

        int courseOffering = askForCourseSectionID();
        if (temp == null)
            return;

        Registration reg = new Registration();
        CourseOffering offering = temp.getCourseOfferingAt(courseOffering);

        if (offering != null)
            reg.completeRegistration(student, offering);

        return;
    }

    private void removeCourseFromStudentCourses() {
        int ID = askForStudentID();
        Student student = studentList.searchForStudentID(ID);

        if (student == null)
            return;

        scan.nextLine();
        String name = askForCourseName();
        int num = askForCourseNumber();
        Course temp = cat.searchCat(name, num);

        if (temp == null)
            return;

        student.removeFromClass(temp);
    }

    private int askForCourseSectionID() {
        System.out.println();
        System.out.print("What is the offering number?");
        int num = scan.nextInt();
        return num;
    }

    private int askForStudentID() {
        System.out.println();
        System.out.print("What is the Student's ID?: ");
        int num = scan.nextInt();
        return num;
    }

    private String askForCourseName() {
        System.out.println();
        System.out.print("What is the name of the course? : ");
        String line = scan.nextLine();
        return line;
    }

    private int askForCourseNumber() {
        System.out.println();
        System.out.print("What is the number of the course? : ");
        int num = scan.nextInt();
        return num;
    }

    private void printStars() {
        System.out.println("**************************");
    }

    private void createCourseOfferingsForSimulation() { // this code is only here to simulate course offerings ONLY FOR SIMULATION
        Course myCourse = this.cat.searchCat("ENGG", 233);
        Course myCourse2 = this.cat.searchCat("ENSF", 409);
        Course myCourse3 = this.cat.searchCat("PHYS", 259);
        Course myCourse4 = this.cat.searchCat("ENEL", 471);
        Course myCourse5 = this.cat.searchCat("ENEL", 441);
        Course myCourse6 = this.cat.searchCat("COMS", 363);
        Course myCourse7 = this.cat.searchCat("ENEL", 453);


        if (myCourse != null) {
            this.cat.createCourseOffering(myCourse, 1, 100);
            this.cat.createCourseOffering(myCourse, 2, 200);
        }
        if (myCourse2 != null) {
            this.cat.createCourseOffering(myCourse2, 1, 200);
            this.cat.createCourseOffering(myCourse2, 2, 100);
        }
        if (myCourse3 != null) {
            this.cat.createCourseOffering(myCourse3, 1, 100);
            this.cat.createCourseOffering(myCourse3, 2, 200);
        }
        if (myCourse4 != null) {
            this.cat.createCourseOffering(myCourse4, 1, 50);
            this.cat.createCourseOffering(myCourse4, 2, 240);
        }
        if (myCourse5 != null) {
            this.cat.createCourseOffering(myCourse5, 1, 40);
            this.cat.createCourseOffering(myCourse5, 2, 100);
        }
        if (myCourse6 != null) {
            this.cat.createCourseOffering(myCourse6, 1, 400);
            this.cat.createCourseOffering(myCourse6, 2, 40);
        }
        if (myCourse7 != null) {
            this.cat.createCourseOffering(myCourse7, 1, 10);
            this.cat.createCourseOffering(myCourse7, 2, 400);
        }
    }


    public static void main(String[] args) {
        FrontEnd front = new FrontEnd();
        front.createCourseOfferingsForSimulation(); // ONLY FOR SIMULATION
        front.menu();
    }
}
