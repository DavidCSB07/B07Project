package com.example.finalmerge.EventPage.Model;

public class Event {


    private String postKey;
    private String title;
    private String description;
    private String refKey;
    private int confirmation; // 0 --> not joined 1 otherwise
    private Object timeStamp;

    public Event(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Event() {

    }

    public void setPostKey(String postKey) {
        this.postKey = postKey;
    }

    public String getPostKey() {
        return postKey;
    }



    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Object getTimeStamp() {
        return timeStamp;
    }

    public int getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(int confirmation) {
        this.confirmation = confirmation;
    }
}