package com.example.finalmerge.AnnouncementsPage.Model;

public class Announcements {
    String annSubject, annDes;

    public Announcements(){
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
}
