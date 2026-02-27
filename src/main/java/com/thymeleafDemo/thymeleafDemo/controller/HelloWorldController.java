package com.thymeleafDemo.thymeleafDemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    // controller method to show initial HTML form
    @RequestMapping("showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // controller method to return template after processing input form
    @RequestMapping("processedForm")
    public String processedForm(Model theModel) {
        theModel.addAttribute("theDate",java.time.LocalDate.now() );
        return "helloworld-processed-form";
    }

    // method adding data to the model
    @RequestMapping("processedFormVersionTwo")
    public String processedFormVersionTwo (HttpServletRequest theRequest, Model theModel ) {

        // reading the request parameter from the HTML form
        String theName = theRequest.getParameter("studentName");

        // converting the input form data to uppercases
        theName = theName.toUpperCase();

        // creating the message
        String result = "Hi " + theName;

        // adding massage to the model
        theModel.addAttribute("message", result );

        return "helloworld-processed-form-second";
    }

    // method adding data to the model
    @PostMapping("processedFormVersionThree")
    public String processedFormVersionThree (@RequestParam("studentName") String theName, Model theModel ) {

        // binding param to he model is  made by Spring

        // converting the input form data to uppercases
        theName = theName.toUpperCase();

        // creating the message
        String result = "Welcome my dear " + theName + " in the third version of view";

        // adding massage to the model
        theModel.addAttribute("message", result );

        return "helloworld-processed-form-third";
    }
}
