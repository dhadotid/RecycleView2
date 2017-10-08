package com.example.dhadotid.recycleview.Model;

/**
 * Created by dhadotid on 08/10/2017.
 */

public class DataModel {
    int id;
    String task;
    long deadline;
    long createdTime;
    int status;

    public DataModel(int id, String task, long deadline, long createdTime, int status) {
        this.id = id;
        this.task = task;
        this.deadline = deadline;
        this.createdTime = createdTime;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public long getDeadline() {
        return deadline;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public int getStatus() {
        return status;
    }
}
