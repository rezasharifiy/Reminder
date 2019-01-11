package com.developerman.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "medic_table")
public class MedicModelData {
    @PrimaryKey(autoGenerate = true)
    private int rowId;
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "time")
    private String time;
    @ColumnInfo(name = "isActive")
    private int isActive;
    @ColumnInfo(name = "period")
    private String period;
    @ColumnInfo(name = "status")
    private String status;
    @ColumnInfo(name = "message")
    private String message;
    @ColumnInfo(name = "takeTime")
    private String takeTime;

    @Ignore
    public MedicModelData() {

    }

    public MedicModelData(int rowId,  String name,  String description,  String date, String time, int isActive, String period, String status, String message, String takeTime) {
        this.rowId = rowId;
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.isActive = isActive;
        this.period = period;
        this.status = status;
        this.message = message;
        this.takeTime = takeTime;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
