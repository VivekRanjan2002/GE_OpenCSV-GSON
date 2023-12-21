package com.bridgeLabz;
import com.opencsv.bean.CsvBindByName;
//Java POJO is CSVUser class with all fields are of string type
public class CSVUser {
    @CsvBindByName
    private String name;
     @CsvBindByName(column="email", required = true)
    private String email;
     @CsvBindByName
    private String phoneNo;
     @CsvBindByName
    private  String country;
    // setter method
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    // getter methods
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public String getCountry() {
        return country;
    }

    @Override
    public String toString(){
         return "CSVUser{"+
                 "name='" + name + '\'' +
                 ", email='" + email + '\'' +
                 ", phoneNo='" + phoneNo + '\'' +
                 ", country='" + country + '\'' +
                 '}';
     }
}
