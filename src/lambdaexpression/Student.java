package lambdaexpression;

import java.time.LocalDate;

/**
 *
 * @author Al-Amin Islam <alaminislam3555@gmail.com>
 */
public class Student {
    private long studentId;
    private String name;
    private double gpa;

    public Student() {
    }

    public Student(long studentId, String name, double gpa) {
        this.studentId = studentId;
        this.name = name;
       
        this.gpa = gpa;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
    return "student{" + "studentId=" + studentId + ", name=" + name + ", gpa=" + gpa + '}';
    }
    
}
