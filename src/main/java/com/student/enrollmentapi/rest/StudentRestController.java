package com.student.enrollmentapi.rest;
import com.student.enrollmentapi.entity.Admin;
import com.student.enrollmentapi.entity.AdminName;
import com.student.enrollmentapi.entity.Department;
import com.student.enrollmentapi.entity.Student;
import com.student.enrollmentapi.service.AdminNameService;
import com.student.enrollmentapi.service.AdminService;
import com.student.enrollmentapi.service.DepartmentService;
import com.student.enrollmentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class StudentRestController {

    private AdminService adminService;

    private AdminNameService adminNameService;

    private DepartmentService departmentService;

    private StudentService studentService;

    @Autowired
    public StudentRestController(AdminService adminService, AdminNameService adminNameService, DepartmentService departmentService, StudentService studentService) {
        this.adminService = adminService;
        this.adminNameService = adminNameService;
        this.departmentService = departmentService;
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.getStudents();
    }

    @PostMapping("/studentsByRoll")
    public List<Student> findAllByRoll(@RequestBody Student student) {
        return studentService.getStudentsbyRoll(student.getRoll());
    }

    @PostMapping("/studentsByDept/{theDept}")
    public List<Student> findAllByDepartment(@PathVariable String theDept) {
        return studentService.getStudentsbyDept(theDept);
    }

    @GetMapping("/students/{theId}")
    public Student findById(@PathVariable Integer theId) {
        return studentService.getStudent(theId);
    }

    @PostMapping(value = "/addStudent", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Student addStudent(@RequestParam MultipartFile file,
                              @RequestParam String name,
                              @RequestParam Integer roll,
                              @RequestParam String session,
                              @RequestParam String email,
                              @RequestParam String mobile,
                              @RequestParam String department) throws IOException {
        Student student = new Student();

        student.setName(name);
        student.setRoll(roll);
        student.setSession(session);
        student.setEmail(email);
        student.setMobile(mobile);
        student.setDepartment(department);
        student.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        studentService.saveStudent(student);
        return student;
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @PatchMapping("/updateStudent/{theId}")
    public Student updateStudent(@PathVariable Integer theId,@RequestBody Student student) {
        student.setId(theId);
        studentService.saveStudent(student);
        return student;
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteStudent/{theId}")
    public String deleteStudent(@PathVariable Integer theId) {
        studentService.deleteStudent(theId);
        return "Student Deleted successfully. Id= " + theId;
    }

    @GetMapping("/departments")
    public List<Department> findDepartment() {
        return departmentService.getDepartment();
    }

    @PostMapping(value = "/addDepartment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Department addDepartment(@RequestParam MultipartFile file,
                              @RequestParam String department) throws IOException {
        Department theDepartment = new Department();

        theDepartment.setDepartment(department);
        theDepartment.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        departmentService.saveDepartment(theDepartment);
        return theDepartment;
    }

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin){
        adminService.saveAdmin(admin);
        return admin;
    }

    @PostMapping("/isAdmin")
    public boolean getAdmin(@RequestBody Admin admin){
        return adminService.getAdmin(admin.getEmail());
    }

    @PostMapping("/addAdminName")
    public AdminName addAdminName(@RequestBody AdminName adminName){
        adminNameService.saveAdminName(adminName);
        return adminName;
    }

    @PostMapping("/adminName")
    public AdminName getAdminName(@RequestBody AdminName adminName){
        return adminNameService.getAdminName(adminName.getEmail());
    }

}
