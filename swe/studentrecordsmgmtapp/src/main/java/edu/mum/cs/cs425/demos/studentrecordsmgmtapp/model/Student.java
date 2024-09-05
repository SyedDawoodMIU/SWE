


package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




public class Student {
    private String studentId;
    private String name;
    private LocalDate dateOfAdmission;

    
    public Student() {
    }

    
    public Student(String studentId, String name, LocalDate dateOfAdmission) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
    }

    
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfAdmission = LocalDate.now();
    }

    
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    
    public static LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return LocalDate.parse(date, formatter);
    }
}
