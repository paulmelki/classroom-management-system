import java.util.Date;

public class Student {

    /**
     * DATA MEMBERS OF CLASS STUDENT
     */
    private String name_student;
    private String id_student;
    private String email_student;
    private boolean isMale_student;
    private Date dob_student;


    /**
     * No-arg Constructor
     */
    public Student() {

        this("", "", "", true, new Date(0));
    }

    public Student(String name, String id, String email, boolean isMale, Date dob) {

        this.name_student = name;
        this.id_student = id;
        this.email_student = email;
        this.isMale_student = isMale;
        this.dob_student = dob;

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

    void setDob_student(Date dob_student) {

        this.dob_student = dob_student;
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

    Date getDob_student() {

        return this.dob_student;
    }


}
