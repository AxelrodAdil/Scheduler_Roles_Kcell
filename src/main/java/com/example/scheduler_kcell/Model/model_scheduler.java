package com.example.scheduler_kcell.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "scheduler")
public class model_scheduler {

    private Long id;
    @NotBlank
    private String title;
    private String date;
    private String priority;
    private String description;

    public model_scheduler(Long id, String title, String date, String priority, String description){
        this.id = id;
        this.title = title;
        this.date = date;
        this.priority = priority;
        this.description = description;
    }

    public model_scheduler() {

    }

    @Id
    //@GeneratedValue
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "model_scheduler{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", priority='" + priority + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
