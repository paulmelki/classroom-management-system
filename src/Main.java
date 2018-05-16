import java.util.ArrayList;

public class Main {

    static ArrayList<Classroom> classrooms = new ArrayList<Classroom>();

    public static void main(String[] args) {

        Classroom c1 = new Classroom();
        c1.setCode_classroom("CSIS278");
        c1.setTitle_classroom("Software Engineering");
        c1.setInstructorName_classroom("Omar Chebaro");
//        c1.setNumberOfEnrolledStudents(5);

        c1.setMaximumNumberOfStudents(8);

        Student s1 = new Student();
        s1.setId_student("A1611161");
        s1.setName_student("Paul Melki");
        Student s2 = new Student();
        s2.setId_student("A169771");
        s2.setName_student("Ragnar Lothbrok");
        Student s3 = new Student();
        s3.setId_student("A1874441");
        s3.setName_student("Uhtred of Babbenburg");
        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        c1.enrollStudent(s3);
        System.out.println(c1.getNumberOfEnrolledStudents());
//        Test t1 = new Test();
//        t1.setTitle_test("Test 1");
//        c1.addTest(t1);
//        Classroom c2 = new Classroom();
//        c2.setCode_classroom("CSIS231");
//        c2.setTitle_classroom("Java Technologies");
//        classrooms.add(c1);
//        classrooms.add(c2);
//        MainMenu newMainMenu = new MainMenu();


        Classroom_View classroom_view = new Classroom_View(c1);


//        Classroom_Creator cc = new Classroom_Creator();
//        Classroom_Picker cp = new Classroom_Picker();
    }
}
