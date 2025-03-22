/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author 84376
 */
public class viewRequest {
    private int requestID;
  
    private String fullName;
    private String phoneNumber;
    private String address;
 
    private Timestamp requestDate;
    private String status;
    private String description;
    private double basePrice;

    public viewRequest() {
    }

    public viewRequest(int requestID, String fullName, String phoneNumber, String address, Timestamp requestDate, String status, String description, double basePrice) {
        this.requestID = requestID;
        
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.requestDate = requestDate;
        this.status = status;
        this.description = description;
        this.basePrice = basePrice;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }



    
   
    
}
