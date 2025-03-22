/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84376
 */
public class ContractDetail {
    private int contractDetail;
    private int contractID;
    private int employeeID;
    private int vehicleID;
    private int movingStaffCount;

    public ContractDetail() {
    }

    public ContractDetail(int contractDetail, int contractID, int employeeID, int vehicleID, int movingStaffCount, int driverStaffCount) {
        this.contractDetail = contractDetail;
        this.contractID = contractID;
        this.employeeID = employeeID;
        this.vehicleID = vehicleID;
        this.movingStaffCount = movingStaffCount;
    }

    public int getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(int contractDetail) {
        this.contractDetail = contractDetail;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getMovingStaffCount() {
        return movingStaffCount;
    }

    public void setMovingStaffCount(int movingStaffCount) {
        this.movingStaffCount = movingStaffCount;
    }

  
    

    
    
}
