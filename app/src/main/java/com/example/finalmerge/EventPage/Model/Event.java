package com.example.finalmerge.EventPage.Model;

public class Event {

    public String Title;
    public String Description;
    

    public Event(){

    }
    public Event(String title, String description) {
        Title = title;
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
