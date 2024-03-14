package StudentInfo.studentInfo.student.info;


import lombok.Getter;

@Getter
public enum Grades {
    firstGrade("초등1학년"),
    secondGrade("초등2학년"),
    seventhGrade("중등1학년"),
    eighthGrade("중등2학년");
    private String grade_str;
    Grades(String grade_str){
        this.grade_str = grade_str;
    }

}