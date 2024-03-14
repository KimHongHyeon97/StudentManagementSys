package StudentInfo.studentInfo.student;


import StudentInfo.studentInfo.student.info.Assessment;
import StudentInfo.studentInfo.student.info.Grades;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Student {
    public Student(){};
    public Student(String name, int age, String address, String phoneNumber, Grades grade, int latestScore, String description){
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.grade = grade;
        this.assessment = new Assessment(latestScore, description);
    }
    private Long id;
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private Grades grade;
    private Assessment assessment;

    public String toString(){
        return this.name + " " + this.age + " ";
    }


}

