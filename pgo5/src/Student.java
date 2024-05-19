import java.util.Date;
public class Student {
    private String fname;
    private String lname;
    private String email;
    private String address;
    private String phoneNumber;
    private Date date;
    private StudyProgramme programme;
    private int currentSemester;
    private String status;

    public Student(String fname, String lname,String email,String address,String phoneNumber,Date date){
        this.fname=fname;
        this.lname=lname;
        this.email=email;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.date=date;
        this.currentSemester = 0;
        this.status = "candidate";

    }
    public void enrollStudent(StudyProgramme programme) {
        this.programme = programme;
        this.currentSemester = 1;
        this.status = "student";
    }


}
