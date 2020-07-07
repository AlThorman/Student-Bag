/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author althorman
 */
public class Student {
   private int addressID;
 private String firstName;
 private String lastName;
 private String password;
 private String email;
 private String phoneNumber;



    Student(int addressID,String firstName,String lastName,String password, String email,String phoneNumber)
    {
      this.addressID = addressID;
      this.firstName = firstName;
      this.lastName = lastName;
      this.password = password;
      this.email = email;
      this.phoneNumber = phoneNumber;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



 
    


    
}
