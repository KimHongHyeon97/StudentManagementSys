package StudentInfo.studentInfo.student.info;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Assessment {
    int latestScore;
    String description;

    public Assessment(){}


}
