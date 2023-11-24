package com.springdemo.mvc;

import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String firstName="";

    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String lastName="";

    //validating number range
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to zero")
    private int freePasses;


    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5chars/digits")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
