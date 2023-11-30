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

    public String getAnnSubject() {
        return annSubject;
    }

    public String getAnnDes() {
        return annDes;
    }

    public String getCurrentDate() {
        return currentDate;
    }
}
