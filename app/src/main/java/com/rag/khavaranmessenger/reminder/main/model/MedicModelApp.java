package com.rag.khavaranmessenger.reminder.main.model;

public class MedicModelApp {
    private int rowId;
    private String name;
    private String desccription;
    private String date;
    private String time;
    private int isActive;
    private String period;
    private String status;
    private String message;
    private String takeTime;

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesccription() {
        return desccription;
    }

    public void setDesccription(String desccription) {
        this.desccription = desccription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(String takeTime) {
        this.takeTime = takeTime;
    }
}
