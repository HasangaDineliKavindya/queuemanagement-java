package com.example.dineli;

public class Customer {
    private String FirstName;
    private String LastName;
    private int BurgersRequired;

    public Customer(String FirstName, String LastName, int BurgersRequired){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.BurgersRequired = BurgersRequired;
    }



    public String getFirstName() {return FirstName;}

    public String getLastName() {return LastName;}

    public int getBurgersRequired() {return BurgersRequired;}



    @Override
    public String toString() {
        return getFirstName();
    }




}
