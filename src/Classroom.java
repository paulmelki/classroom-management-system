import java.util.ArrayList;
import java.util.Date;

public class Classroom {


    /**
     * DATA MEMBERS
     */
    private String code_classroom;
    private String title_classroom;
    private String instructorName_classroom;
    private int maximumNumberOfStudents;
    private int numberOfEnrolledStudents = 0;
    private int numberOfTests;
    private ArrayList<Student> enrolledStudents = new ArrayList<Student>();
    private ArrayList<Test> tests = new ArrayList<Test>();


    /**
     * CONSTRUCTOR
     */

    public Classroom() {

        this("", "", "", 0);
    }


    public Classroom(String code_classroom, String title_classroom, String instructorName_classroom,
                     int maximumNumberOfStudents) {

        this.code_classroom = code_classroom;
        this.title_classroom = title_classroom;
        this.instructorName_classroom = instructorName_classroom;
        this.maximumNumberOfStudents = maximumNumberOfStudents;
    }


    /**
     * SETTERS AND GETTERS
     */
    public void setCode_classroom(String code_classroom) {

        this.code_classroom = code_classroom;
    }

    public void setTitle_classroom(String title_classroom) {

        this.title_classroom = title_classroom;
    }

    public void setInstructorName_classroom(String instructorName_classroom) {

        this.instructorName_classroom = instructorName_classroom;
    }

    public void setMaximumNumberOfStudents(int maximumNumberOfStudents) {

        this.maximumNumberOfStudents = maximumNumberOfStudents;
    }

    public void setNumberOfTests(int numberOfTests) {

        this.numberOfTests = numberOfTests;
    }

    public void setNumberOfEnrolledStudents(int numberOfEnrolledStudents) {

        this.numberOfEnrolledStudents = numberOfEnrolledStudents;
    }

    public String getCode_classroom() {

        return this.code_classroom;
    }

    public String getTitle_classroom() {

        return this.title_classroom;
    }

    public String getInstructorName_classroom() {

        return this.instructorName_classroom;
    }

    public int getMaximumNumberOfStudents() {

        return this.maximumNumberOfStudents;
    }

    public int getNumberOfTests() {

        return this.numberOfTests;
    }

    public int getNumberOfEnrolledStudents() {

        return this.numberOfEnrolledStudents;
    }

    public ArrayList<Student> getEnrolledStudents() {

        return this.enrolledStudents;
    }

    public ArrayList<Test> getTests() {

        return this.tests;
    }

    /**
     * Function that enrolls a new student in this classroom
     *
     * @param newStudent
     * @return true if the enrollment process is successful, false otherwise
     */
    public boolean enrollStudent(Student newStudent) {

        if (newStudent != null) {

            if (this.enrolledStudents == null) {
                this.enrolledStudents = new ArrayList<Student>();
            }

            if (this.enrolledStudents.size() < this.maximumNumberOfStudents) {
                this.enrolledStudents.add(newStudent);
                this.numberOfEnrolledStudents++;

                return true;
            } else {
                System.out.println("Maximum number of Students reached");
                return false;
            }
        } else {

            return false;
        }
    }


    public boolean disenrollStudent(Student student) {

        if (student != null) {

            for (int i = 0; i < this.enrolledStudents.size(); i++) {

                if (student.equals(this.enrolledStudents.get(i)))
                {
                    this.enrolledStudents.remove(i);
                    this.numberOfEnrolledStudents--;
                    return true;
                }
            }

            return false;
        }

        return false;

    }


    /**
     * Function that searches linearly through the list of enrolled students in order to find the student having
     * the argument id.
     *
     * @param id
     * @return the index of the student if it is found, -1 if the student is not found in the list
     */
    public int searchStudentByID(String id) {

        int index = -1;

        for (int i = 0; i < this.enrolledStudents.size(); i++) {

            if (this.enrolledStudents.get(i).getId_student().equals(id)) {
                index = i;
            }
        }

        return index;
    }


    /**
     * Function that removes a student based on their ID by searching for the student having this ID,
     * then removing it. If the ID is not found, nothing is removed
     *
     * @param id
     * @return true if the removal of the student is successful, false otherwise
     */
    public boolean removeStudentbyID(String id) {

        int index = this.searchStudentByID(id);

        if (index == -1) {
            System.out.println("Student not found!");
            return false;
        } else {
            this.enrolledStudents.remove(index);
            return true;
        }
    }


    /***
     * Function that adds a new test to this classroom. This method also directly adds all the students in this course
     * to the test
     * @param newTest
     * @return true if the course has been inserted, false if the course has not been added due to reaching the
     * maximum number of tests in this course
     */
    public boolean addTest(Test newTest) {

        if (this.tests == null) {

            this.tests = new ArrayList<Test>();
        }

        this.tests.add(newTest);
        this.numberOfTests++;

        for (int i = 0; i < this.numberOfEnrolledStudents; i++) {

            newTest.addStudent(this.enrolledStudents.get(i));
        }

        return true;

    }


}
