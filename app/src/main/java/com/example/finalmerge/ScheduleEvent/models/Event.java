package com.example.finalmerge.ScheduleEvent.models;

public class Event {


    private String postKey;
    private String title;
    private String description;
    private String userId;
    private Object date;
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

    public String getUserId() {
        return userId;
    }

    public Object getDate() {
        return date;
    }

    public Object getTimeStamp() {
        return timeStamp;
    }

}
