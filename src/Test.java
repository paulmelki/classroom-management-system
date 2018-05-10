import com.sun.org.glassfish.external.statistics.Stats;

import java.util.ArrayList;
import java.util.Date;

public class Test {


    /**
     * DATA MEMBERS
     */
    private String title_test;
    private Classroom class_test;
    private double overallGrade_test;
    private Date date_test;
    private String description_test;
    // A list of the students who are taking the test
    private ArrayList<Student> students_test;
    private ArrayList<Double> grades_test;


    public Test() {

        this("", new Classroom(), 100, new Date(0), "");

    }


    public Test(String title_test, Classroom class_test, double overallGrade_test, Date date_test, String description_test) {

        this.title_test = title_test;
        this.class_test = class_test;
        this.overallGrade_test = overallGrade_test;
        this.date_test = date_test;
        this.description_test = description_test;

    }


    /**
     * SETTERS AND GETTERS
     */

    public String getTitle_test() {
        return title_test;
    }

    public void setTitle_test(String title_test) {
        this.title_test = title_test;
    }

    public Classroom getClass_test() {
        return class_test;
    }

    public void setClass_test(Classroom class_test) {
        this.class_test = class_test;
    }

    public double getOverallGrade_test() {
        return overallGrade_test;
    }

    public void setOverallGrade_test(double overallGrade_test) {
        this.overallGrade_test = overallGrade_test;
    }

    public Date getDate_test() {
        return date_test;
    }

    public void setDate_test(Date date_test) {
        this.date_test = date_test;
    }

    public String getDescription_test() {
        return description_test;
    }

    public void setDescription_test(String description_test) {
        this.description_test = description_test;
    }

    public ArrayList<Student> getStudents_test() {

        return this.students_test;
    }


    /**
     * FUNCTION ADD STUDENT THAT ADDS A NEW STUDENT TO THE ARRAYLIST OF STUDENTS TAKING THE TEST
     */
    public void addStudent(Student newStudent) {

        if (!newStudent.getName_student().equals("")) {
            this.students_test.add(newStudent);
            this.grades_test.add(new Double(0));
        }
    }


    /**
     * Member function addGradeToStudent that adds the parameter grade to the parameter Student
     *
     * @param studentToGrade
     * @param grade
     * @return true if add operation is successful, false otherwise
     */
    public boolean addGradeToStudent(Student studentToGrade, double grade) {

        // Find the index of relevant student
        int indexOfStudent = this.students_test.indexOf(studentToGrade);

        if (indexOfStudent >= 0) {

            this.grades_test.set(indexOfStudent, new Double(grade));
            return true; // add grade operation is successful
        } else {

            System.out.println("Student not found!");
            return false;
        }
    }

    /**
     * Member function that finds the highest grade taken on this test and returns its index
     *
     * @return the index of the highest grade taken on this test
     */
    public int findHighestGrade() {

        Double maxGrade = this.grades_test.get(0);
        int indexOfMaxGrade = 0;

        for (int i = 1; i < this.grades_test.size() - 1; i++) {

            maxGrade = Math.max(maxGrade, this.grades_test.get(i));
            indexOfMaxGrade = this.grades_test.indexOf(maxGrade);
        }

        return indexOfMaxGrade;
    }

    /**
     * Member function that finds the student who has taken the highest grade on this test
     *
     * @return the student who has taken the highest grade on the test
     */
    public Student findStudentWithHighestGrade() {

        int indexOfMaxGrade = this.findHighestGrade();

        return this.students_test.get(indexOfMaxGrade);
    }


    /**
     * Member function that finds the lowest grade taken on this test and returns its index
     *
     * @return the index of the lowest grade taken on this test
     */
    public int findLowestGrade() {

        Double minGrade = this.grades_test.get(0);
        int indexOfMinGrade = 0;

        for (int i = 1; i < this.grades_test.size() - 1; i++) {

            minGrade = Math.min(minGrade, this.grades_test.get(i));
            indexOfMinGrade = this.grades_test.indexOf(minGrade);
        }

        return indexOfMinGrade;
    }

    /**
     * Member function that finds the student who has taken the lowest grade on this test
     *
     * @return the student who has taken the lowest grade on the test
     */
    public Student findStudentWithLowestGrade() {

        int indexOfMinGrade = this.findLowestGrade();

        return this.students_test.get(indexOfMinGrade);
    }


    /**
     * Member function calculates the average of the class
     *
     * @return the average of the class as a double
     */
    public double calculateGradesAverage() {

        double sumOfGrades = 0;
        for (int i = 0; i < this.grades_test.size(); i++) {
            sumOfGrades += this.grades_test.get(i);
        }

        return sumOfGrades / this.grades_test.size();
    }


}
