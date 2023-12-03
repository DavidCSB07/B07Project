package com.example.finalmerge.EventPage.Model;

public class Event {


    String postKey;
    String title;
    String description;
    String refKey;
    String dateEvent;
    int participants;

    public Event( String title, String description, String date, int participants) {
        //this.postKey = postKey;
        this.title = title;
        this.description = description;
        //this.refKey = refKey;
        this.dateEvent = date;
        this.participants = participants;
    }

    public Event() {
    }

    public String getPostKey() {
        return postKey;
    }

    public void setPostKey(String postKey) {
        this.postKey = postKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRefKey() {
        return refKey;
    }

    public void setRefKey(String refKey) {
        this.refKey = refKey;
    }

    public String getDate() {
        return dateEvent;
    }

    public void setDate(String date) {
        this.dateEvent = date;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }
}