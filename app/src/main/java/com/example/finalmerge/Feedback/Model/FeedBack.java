package com.example.finalmerge.Feedback.Model;

public class FeedBack {

    public int numFeedback;
    public String shortFeedback;
    public String userName;
    public String refKey;

    public FeedBack(int numFeedback, String shortFeedback, String userName) {
        this.numFeedback = numFeedback;
        this.shortFeedback = shortFeedback;
        this.userName = userName;
    }

    public FeedBack() {

    }

    public int getNumFeedback() {
        return numFeedback;
    }

    public void setNumFeedback(int numFeedback) {
        this.numFeedback = numFeedback;
    }

    public String getShortFeedback() {
        return shortFeedback;
    }

    public void setShortFeedback(String shortFeedback) {
        this.shortFeedback = shortFeedback;
    }

    public String getRefKey() {
        return refKey;
    }

    public void setRefKey(String refKey) {
        this.refKey = refKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
