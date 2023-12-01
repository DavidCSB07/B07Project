package com.example.finalmerge.AnnouncementPage.Model;

public class Announcements {
    String annSubject, annDes, currentDate;

    public Announcements(){
    }
    public Announcements(String annSubject, String annDes, String currentDate) {
        this.annSubject = annSubject;
        this.annDes = annDes;
        this.currentDate = currentDate;
    }

    public Announcements(String annSubject, String annDes) {
        this.annSubject = annSubject;
        this.annDes = annDes;
    }

    public String getAnnSubject() {
        return annSubject;
    }

    public String getAnnDes() {
        return annDes;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setAnnSubject(String annSubject) {
        this.annSubject = annSubject;
    }

    public void setAnnDes(String annDes) {
        this.annDes = annDes;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
}
