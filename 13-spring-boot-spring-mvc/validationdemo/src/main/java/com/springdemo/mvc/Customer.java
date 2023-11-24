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
    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to zero")
    private Integer freePasses;

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5chars/digits")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
