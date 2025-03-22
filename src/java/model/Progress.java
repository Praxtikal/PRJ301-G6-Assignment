package model;

import java.util.Date;

public class Progress {
    private int progressID;
    private int contractID;
    private Date updateDate;
    private String status;
    private String notes;

    // Constructor không tham số
    public Progress() {}

    // Constructor đầy đủ
    public Progress(int progressID, int contractID, Date updateDate, String status, String notes) {
        this.progressID = progressID;
        this.contractID = contractID;
        this.updateDate = updateDate;
        this.status = status;
        this.notes = notes;
    }

    // Getter và Setter
    public int getProgressID() {
        return progressID;
    }

    public void setProgressID(int progressID) {
        this.progressID = progressID;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Phương thức toString() để debug
    @Override
    public String toString() {
        return "Progress{" +
                "progressID=" + progressID +
                ", contractID=" + contractID +
                ", updateDate=" + updateDate +
                ", status='" + status + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
