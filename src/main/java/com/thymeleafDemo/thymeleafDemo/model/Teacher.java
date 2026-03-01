package com.thymeleafDemo.thymeleafDemo.model;

import com.thymeleafDemo.thymeleafDemo.validation.CourseCode;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.util.Random;

public class Teacher extends Human {

    private String certificate;

    // create custom error exception for case when user write String !!!
    @Min(value=0,  message = "must be greater than or equal to 0")
    @Max(value=80, message = "must be less than or equal to 60")
    private Integer yearsOfExperience;

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message = "must be 5 values - chars/digits")
    private String postalCode;

    private String courseName;
    @CourseCode(value="CODE", message="must start with CODE")
    private String courseCode;

    // constructors

    public Teacher(){}

    public Teacher(String theFirstName, String theLastName ) {
        super(theFirstName, theLastName, "Indie");
        certificate = generateCertificate();
        yearsOfExperience = 0;
        courseName = null;
        courseCode = null;
    }

    public Teacher(String theFirstName, String theLastName, Integer theYearsOfExperience) {
        super(theFirstName, theLastName, "Poland");
        certificate = generateCertificate();
        yearsOfExperience = theYearsOfExperience;
        courseName = null;
        courseCode = null;

    }

    public Teacher(String theFirstName, String theLastName, String theCountry, String thePostalCode,
                   Integer theYearsOfExperience, String theCourseName, String theCourseCode) {

        super(theFirstName,
                theLastName,
                (theCountry == null) ? "Poland" : theCountry );

        postalCode = ( thePostalCode == null ) ? "PL345"  : thePostalCode;
        yearsOfExperience = ( theYearsOfExperience == null ) ?  0 : theYearsOfExperience;

        certificate = generateCertificate();
        courseName = ( theCourseName == null ) ? "Java Programming" : theCourseName;
        courseCode = ( theCourseCode == null ) ? "PL00001" : theCourseCode;
    }

    // getters / setters

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String theCertificate) {
        certificate = theCertificate;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer theYearsOfExperience) {
        yearsOfExperience = theYearsOfExperience;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String thePostalCode) {
        postalCode = thePostalCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String theCourseName) {
        courseName = theCourseName;
    }


    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String theCourseCode) {
        courseCode = theCourseCode;
    }



    // method

    private String generateCertificate() {
         String CHARACTERS =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        Random random = new Random();
        int strLength = 9;
        StringBuilder tempCert = new StringBuilder(strLength);
        for (int i = 0; i < strLength; i++) {
            int index = random.nextInt( CHARACTERS.length() );
            tempCert.append(CHARACTERS.charAt(index));
        }

        return tempCert.toString();
    }

}
