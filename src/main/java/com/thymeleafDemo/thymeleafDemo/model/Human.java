package com.thymeleafDemo.thymeleafDemo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Human {
        private String firstName;

        @NotNull(message="is required")
        @NotBlank(message="cannot be blank")
        @Size(min=1, max=30, message="is required with 1-30 chars")
        private String lastName = "";

        private String country;


        public Human(){}

        public Human(String theFirstName, String theLastName, String theCountry) {
            firstName = theFirstName;
            lastName = theLastName;
            country = theCountry;
        }

        // for Thymeleaf method name must be getFirstName, not getterFirstName
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String theFirstName) {
            firstName = theFirstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String theLastName) {
            lastName = theLastName;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String theCountry) {
            country = theCountry;
        }
}
