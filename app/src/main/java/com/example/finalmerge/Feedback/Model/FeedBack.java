package com.example.finalmerge.Feedback.Model;

public class FeedBack {

    public int numFeedback;
    public String shortFeedback;
    public String refKey;

    public FeedBack(int numFeedback, String shortFeedback) {
        this.numFeedback = numFeedback;
        this.shortFeedback = shortFeedback;
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
}
