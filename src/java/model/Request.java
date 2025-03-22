package model;
import java.sql.Timestamp;

public class Request {
    private int requestId;
    private int userId;
    private int serviceId;
    private Timestamp requestDate;
    private String status;

    public Request() {
    }

    public Request(int requestId, int userId, int serviceId, Timestamp requestDate, String status) {
        this.requestId = requestId;
        this.userId = userId;
        this.serviceId = serviceId;
        this.requestDate = requestDate;
        this.status = status;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
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
   
   
    
}
