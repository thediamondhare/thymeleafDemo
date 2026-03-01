package com.thymeleafDemo.thymeleafDemo.controller;

import com.thymeleafDemo.thymeleafDemo.model.Teacher;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {


    // adding an init binder to convert trim input string
    // removing leading and trailing whitespace
    // resolve issue for our validation

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }

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
            Teacher newTeacher = new Teacher(theTeacher.getFirstName(), theTeacher.getLastName(), theTeacher.getCountry(), theTeacher.getPostalCode(),
                    theTeacher.getYearsOfExperience(), theTeacher.getCourseName(), theTeacher.getCourseCode() );
            // creating the message
            String result = "Welcome in the Star Academy teacher "
                    + newTeacher.getFirstName() + " " + newTeacher.getLastName() +
                    " with cert ID " + newTeacher.getCertificate() +
                    " from " + newTeacher.getCountry() + " " + newTeacher.getPostalCode() ;

            String resultSecond =  "Learning " + newTeacher.getCourseName() + " (code: " +  newTeacher.getCourseCode()  + ") " +
            " for " +  newTeacher.getYearsOfExperience() + " years." ;

            // adding massage to the model
            theModel.addAttribute("message", result );
            theModel.addAttribute("messageSecond", resultSecond);

            return "teacher-form-processed";
        }

    }
}
