package com.example.finalmerge.ComplaintsStudent;

public class Complaints {

    String email;
    String subject;
    String complaint;

    public Complaints(String email, String subject, String complaint) {
        this.email = email;
        this.subject = subject;
        this.complaint = complaint;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getComplaint() {
        return complaint;
    }
}
