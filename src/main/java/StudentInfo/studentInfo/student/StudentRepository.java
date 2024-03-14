package StudentInfo.studentInfo.student;


import StudentInfo.studentInfo.student.info.Assessment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class StudentRepository {
    private static Long sequenceNumber = 0L;
    private static final Map<Long, Student> repository = new HashMap<>();

    public void save(Student newStudent){
        log.info("new entity {}", newStudent.toString());
        newStudent.setId(++sequenceNumber);
        repository.put(newStudent.getId(), newStudent);
        log.info("{}th student has saved!", sequenceNumber);
    }
    public Optional<Student> findById(Long id){
        List<Student> allStudents = findAll();
        return allStudents.stream()
                .filter(student -> student.getId().equals(id)).findAny();

    }
    public List<Student> findAll(){
        return new ArrayList<Student>(repository.values());
    }

    public void deleteStudentById(Long id){
        if (findById(id).isEmpty()){
            log.info("Student with id = {} doesn't exist!", id);
        }
        else{
            repository.remove(id);
            log.info("Student with id = {} has removed", id);
        }
    }

    public void updateStudent(Long studentId, Student student_Updated, Assessment assessment){
        log.info("updateStudent method entered with id = {}", student_Updated.getId());
        Student student_original = findById(studentId).get();
        student_original.setName(student_Updated.getName());
        student_original.setAge(student_Updated.getAge());
        student_original.setAddress(student_Updated.getAddress());
        student_original.setPhoneNumber(student_Updated.getPhoneNumber());
        student_original.setGrade(student_Updated.getGrade());
        student_original.getAssessment().setLatestScore(assessment.getLatestScore());
        student_original.getAssessment().setDescription(assessment.getDescription());
    }


}
