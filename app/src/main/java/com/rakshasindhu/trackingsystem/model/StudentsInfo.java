package com.rakshasindhu.trackingsystem.model;

public class StudentsInfo {
    private String studentID;
    private String studentName;
    private String studentPhoto;

    public StudentsInfo(String studentID, String studentName, String studentPhoto) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentPhoto = studentPhoto;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhoto() {
        return this.studentPhoto;
    }

    public void setStudentPhoto(String studentPhoto) {
        this.studentPhoto = studentPhoto;
    }
}
