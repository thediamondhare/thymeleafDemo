package com.thymeleafDemo.thymeleafDemo.controller;

import com.thymeleafDemo.thymeleafDemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${defCounties}")
    private List<String> countriesList;
    @Value("${defLanguages}")
    private List<String> languagesList;
    @Value("${defOSList}")
    private List<String> operationSystemsList;

    public List<String> getCountriesList() { return countriesList; }

    @GetMapping("showStudentForm")
    public String showForm(Model theModel) {
        // creating a student object
        Student theStudent = new Student();

        // adding student object and countries list to the model
        theModel.addAttribute("studentObj", theStudent);
        theModel.addAttribute("countries", countriesList);
        theModel.addAttribute("languages", languagesList);
        theModel.addAttribute("osList", operationSystemsList);

        return "student-form";
    }

    @PostMapping("processedStudentForm")
    public String processForm(@ModelAttribute("studentObj") Student theStudent, Model theModel) {

        // creating the message
        String result = "Welcome in the Star Academy "
                + theStudent.getFirstName() + " " + theStudent.getLastName() +
                " liking " + theStudent.getLanguage() + " and " + theStudent.getFavoriteOS() +
                " from " + theStudent.getCountry() ;

        // adding massage to the model
        theModel.addAttribute("message", result );

        return "student-form-processed";
    }
}
