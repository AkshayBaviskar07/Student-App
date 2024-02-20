package com.telusko.StudentCrudApp.controller;

import com.telusko.StudentCrudApp.model.Student;
import com.telusko.StudentCrudApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/list")
    public String getStudents(Model model){
        System.out.println("In get students controller");
        List<Student> students = service.getStudents();
        model.addAttribute("students", students);
        return "studentlists";
    }
    @GetMapping("/form")
    public String showForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "register_form";
    }
    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute Student student){
        service.registerStudent(student);
        return "redirect:/list";
    }
    @GetMapping("/updateStudent")
    public String updateCustomer(@RequestParam Integer id, Model model){
        System.out.println("in update controller");
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "register_form";
    }

    @GetMapping("/deleteStudent")
    public String deleteCustomer(@RequestParam Integer id){
        System.out.println("In delete controller");
        service.deleteById(id);
        return "redirect:/list";
    }
}
