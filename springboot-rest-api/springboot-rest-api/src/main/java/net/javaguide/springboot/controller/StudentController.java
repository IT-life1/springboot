package net.javaguide.springboot.controller;

import net.javaguide.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    // http:localhost:8080/students/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {

        Student student = new Student (
                1,
                "Alex",
                "Sova"
        );

        // return new ResponseEntity<>(student, HttpStatus.OK);
        // return ResponseEntity.ok(student);
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(student);
    }

    // http:localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student (1, "Alex", "Sova"));
        students.add(new Student (2, "Alex", "Kondrashkin"));
        students.add(new Student (3, "Artem", "Frank"));
        students.add(new Student (4, "Ilya", "Doil"));

        return ResponseEntity.ok(students);
    }

    // Spring BOOT REST API with Path Variable
    // {id} - URI template variable
    // http:localhost:8080/student/1
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int studentId,
                                  @PathVariable("first-name") String firstname,
                                  @PathVariable("last-name") String lastname) {
        Student student = new Student (studentId, firstname, lastname);

        return ResponseEntity.ok(student);
    }

    // Spring BOOT REST API with Request Param
    // http:localhost:8080/student/query?id=1
    @GetMapping("query")
    public ResponseEntity<Student> getStudentByRequestParameter(@RequestParam int id,
                                                @RequestParam String firstname,
                                                @RequestParam String lastname) {
        Student student = new Student (id, firstname, lastname);

        return ResponseEntity.ok(student);
    }

    // Spring BOOT REST API handling POST Request - creating new resource
    @PostMapping("create")
    // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring BOOT REST API handling PUT Request - updating resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,  @PathVariable int id) {
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return ResponseEntity.ok(student);
    }

    // Spring BOOT REST API handling HTTP DELETE Request - deleting resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        System.out.println(id);
        return ResponseEntity.ok("Student successfully deleted!");
    }


}
