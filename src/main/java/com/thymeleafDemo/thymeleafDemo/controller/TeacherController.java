package com.thymeleafDemo.thymeleafDemo.controller;

import com.thymeleafDemo.thymeleafDemo.model.Teacher;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {

    @GetMapping("/showTeacherForm")
    public String showForm(Model theModel){
        Teacher theTeacher = new Teacher();

        theModel.addAttribute("teacherObj", theTeacher);

        return "teacher-form";
    }

    @PostMapping("/processedTeacherForm")
    public String processForm( @Valid @ModelAttribute("teacherObj") Teacher theTeacher,
                               BindingResult theBindingResultOfValidation, Model theModel){
        if( theBindingResultOfValidation.hasErrors() ){
            return "teacher-form";
        } else {
            Teacher newTeacher = new Teacher(theTeacher.getFirstName(), theTeacher.getLastName() );
            // creating the message
            String result = "Welcome in the Star Academy teacher "
                    + newTeacher.getFirstName() + " " + newTeacher.getLastName() +
                    " with cert ID " + newTeacher.getCertificate() +
                    " from " + newTeacher.getCountry() ;
            // adding massage to the model
            theModel.addAttribute("message", result );

            return "teacher-form-processed";
        }

    }
}
