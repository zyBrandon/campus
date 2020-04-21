package com.example.demo.model;

public class Feedback {
    public int feedback_id;
    public String feedback_user;
    public String feedback_title;
    public String feedback_content;
    public String feedback_time;

    public Feedback(){

    }

    public Feedback(int feedback_id,String feedback_user,String feedback_title,String feedback_content,String feedback_time){
        this.feedback_content = feedback_content;
        this.feedback_id = feedback_id;
        this.feedback_user = feedback_user;
        this.feedback_title = feedback_title;
        this.feedback_time = feedback_time;
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public String getFeedback_content() {
        return feedback_content;
    }

    public String getFeedback_time() {
        return feedback_time;
    }

    public String getFeedback_title() {
        return feedback_title;
    }

    public String getFeedback_user() {
        return feedback_user;
    }

    public void setFeedback_content(String feedback_content) {
        this.feedback_content = feedback_content;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public void setFeedback_time(String feedback_time) {
        this.feedback_time = feedback_time;
    }

    public void setFeedback_title(String feedback_title) {
        this.feedback_title = feedback_title;
    }

    public void setFeedback_user(String feedback_user) {
        this.feedback_user = feedback_user;
    }
}
