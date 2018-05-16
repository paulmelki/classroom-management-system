import java.util.Date;

public class Student {

    /**
     * DATA MEMBERS OF CLASS STUDENT
     */
    private String name_student;
    private String id_student;
    private String email_student;
    private boolean isMale_student;
    private boolean isGraduate;


    /**
     * No-arg Constructor
     */
    public Student() {

        this("", "", "", true, false);
    }

    public Student(String name, String id, String email, boolean isMale, boolean isGraduate) {

        this.name_student = name;
        this.id_student = id;
        this.email_student = email;
        this.isMale_student = isMale;
        this.isGraduate = isGraduate;

    }

    /**
     * SETTERS AND GETTERS
     */
    void setName_student(String name_student) {

        this.name_student = name_student;
    }

    void setId_student(String id_student) {

        this.id_student = id_student;
    }

    void setEmail_student(String email_student) {

        this.email_student = email_student;
    }

    void setMale_student(boolean isMale_student) {

        this.isMale_student = isMale_student;
    }

    String getName_student() {

        return this.name_student;
    }

    String getId_student() {

        return this.id_student;
    }

    String getEmail_student() {

        return this.email_student;
    }

    boolean isMale_student() {

        return this.isMale_student;
    }

    public boolean isGraduate() {
        return isGraduate;
    }

    public void setGraduate(boolean graduate) {
        isGraduate = graduate;
    }


}
