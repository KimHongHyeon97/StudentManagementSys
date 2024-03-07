package StudentInfo.studentInfo.student;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum Grade {
    firstGrade("초등1학년"), secondGrade("초등2학년"), seventhGrade("중등1학년"), eighthGrade("중등2학년");
    private String grade_str;
    Grade(String grade_str){
        this.grade_str = grade_str;
    }

}
