package StudentInfo.studentInfo.student;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    public Student(){};
    public Student(String name, int age, String address, String phoneNumber){
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    private Long id;
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private Grade grade;

    public String toString(){
        return this.name + " " + this.age + " ";
    }
}
