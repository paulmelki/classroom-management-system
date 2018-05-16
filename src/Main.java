import java.util.ArrayList;

public class Main {

    static ArrayList<Classroom> classrooms = new ArrayList<Classroom>();
    static ArrayList<Student> students = new ArrayList<Student>();

    public static void main(String[] args) {

//        c1.enrollStudent(s1);
//        c1.enrollStudent(s2);
//        c1.enrollStudent(s3);
//        Test t1 = new Test();
//        t1.setTitle_test("Test 1");
//        c1.addTest(t1);
//        Classroom c2 = new Classroom();
//        c2.setCode_classroom("CSIS231");
//        c2.setTitle_classroom("Java Technologies");
//        classrooms.add(c1);
//        classrooms.add(c2);


        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        s1.setName_student("Paul Melki");
        s2.setName_student("Ragnar Lothbrok");
        s3.setName_student("Athina of Athens");
        s1.setId_student("A1611161");
        s2.setId_student("A1478521");
        s3.setId_student("A1236684");

        students.add(s1);
        students.add(s2);
        students.add(s3);



//        Student_Listing sl = new Student_Listing();
//        sl.createStudentListing();
        MainMenu newMainMenu = new MainMenu();

//        Classroom_View classroom_view = new Classroom_View(c1);


//        Classroom_Creator cc = new Classroom_Creator();
//        Classroom_Picker cp = new Classroom_Picker();
    }
}
