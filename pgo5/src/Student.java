import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public class Student {
    private static int studentCount = 0;
    private static List<Student> allStudents = new ArrayList<>();

    private String indexNumber;
    private String fname;
    private String lname;
    private String email;
    private String address;
    private String phoneNumber;
    private Date birthDate;
    private String[] subjects = new String[10];

    private int[] grades = new int[10];
    private int gradeCount = 0;
    private StudyProgramme programme;
    private int currentSemester;
    private String status;
    private int itns;

    public Student(String fname, String lname, String email, String address, String phoneNumber, Date birthDate) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.status = "candidate";
        this.indexNumber = "s" + (++studentCount);
        allStudents.add(this);
    }

    public void enrollStudent(StudyProgramme programme) {
        this.programme = programme;
        this.currentSemester = 1;
        this.status = "student";
    }


    public void addGrade(int grade, String subject) {
        if (gradeCount < subjects.length) {
            this.subjects[gradeCount] = subject;
            this.grades[gradeCount] = grade;
            gradeCount++;
            if (grade <= 2) {
                itns++;
            }
        } else {
            System.out.println("Nie można dodać więcej ocen, tablica pełna");
        }
    }

    public static void promoteAllStudents() {
        for (Student student : allStudents) {
            if (student.status.equals("student")) {
                student.promoteToNextSemester();
            }
        }
    }

    public static void displayInfoAboutAllStudents() {
        for (Student student : allStudents) {
            System.out.println("Student " + student.fname + " " + student.lname + ", Index Number: " + student.indexNumber + ", Current Semester: " + student.currentSemester + ", Status: " + student.status);

            for (int i = 0; i < student.gradeCount; i++) {
                System.out.println("Przedmiot: " + student.subjects[i] + ", Ocena: " + student.grades[i]);
            }
        }
    }
    private void promoteToNextSemester() {
        if (this.currentSemester < programme.getSemester() && itns < programme.getMaxITNs()) {
            this.currentSemester++;
            itns = 0;
        } else if (this.currentSemester == programme.getSemester()) {
            this.status = "graduate";
        }
    }
}
