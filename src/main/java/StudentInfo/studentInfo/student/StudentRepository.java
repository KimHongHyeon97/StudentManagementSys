package StudentInfo.studentInfo.student;


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
                .filter(student -> student.getId().equals(id)).findFirst();

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


}
