package com.thymeleafDemo.thymeleafDemo.model;

import java.util.Random;



public class Teacher extends Human {
    private String certificate;

    public Teacher(){}

    public Teacher(String theFirstName, String theLastName ) {
        super(theFirstName, theLastName, "Algeria");
        certificate = generateCertificate();
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String theCertificate) {
        certificate = theCertificate;
    }


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
