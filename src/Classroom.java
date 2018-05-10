import java.util.ArrayList;
import java.util.Date;

public class Classroom {


    /**
     * DATA MEMBERS
     */
    private String code_classroom;
    private String title_classroom;
    private String instructorName_classroom;
    private Date dateCreated_classroom;
    private Date dateEnds_classroom;
    private int maximumNumberOfStudents;
    private int numberOfEnrolledStudents = 0;
    private int numberOfTests;
    private ArrayList<Student> enrolledStudents;


    /**
     * CONSTRUCTOR
     */

    public Classroom() {

        this("", "", "", new Date(0), new Date(0), 0);
    }


    public Classroom(String code_classroom, String title_classroom, String instructorName_classroom,
                     Date dateCreated_classroom, Date dateEnds_classroom, int maximumNumberOfStudents) {

        this.code_classroom = code_classroom;
        this.title_classroom = title_classroom;
        this.instructorName_classroom = instructorName_classroom;
        this.dateCreated_classroom = dateCreated_classroom;
        this.dateEnds_classroom = dateEnds_classroom;
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

    public void setDateCreated_classroom(Date dateCreated_classroom) {

        this.dateCreated_classroom = dateCreated_classroom;
    }

    public void setDateEnds_classroom(Date dateEnds_classroom) {

        this.dateEnds_classroom = dateEnds_classroom;
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

    public Date getDateCreated_classroom() {

        return this.dateCreated_classroom;
    }

    public Date getDateEnds_classroom() {

        return this.dateEnds_classroom;
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

    /**
     * Function that enrolls a new student in this classroom
     *
     * @param newStudent
     * @return true if the enrollment process is successful, false otherwise
     */
    public boolean enrollStudent(Student newStudent) {

        if (newStudent != null) {

            if (this.enrolledStudents.size() < this.maximumNumberOfStudents) {
                this.enrolledStudents.add(newStudent);

                return true;
            } else {
                System.out.println("Maximum number of Students reached");
                return false;
            }
        } else {

            return false;
        }
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


}
