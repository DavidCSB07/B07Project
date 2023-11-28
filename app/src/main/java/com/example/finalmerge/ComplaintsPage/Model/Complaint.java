package com.example.finalmerge.ComplaintsPage.Model;

public class Complaint {

    String subject, complaint, email;

    public Complaint(String subject, String complaint, String email) {
        this.subject = subject;
        this.complaint = complaint;
        this.email = email;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public String getComplaint() {
        return complaint;
    }

    public String getEmail() {
        return email;
    }
}
