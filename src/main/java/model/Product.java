package model;

import java.util.Date;

public class Product {
    private int id;
    private String title;
    private Date endDate;
    private String description;
    private String status;
    private int userId;

    // Constructor with all fields
    public Product(String title, Date endDate, String description, String status, int userId) {
        this.title = title;
        this.endDate = endDate;
        this.description = description;
        this.status = status;
        this.userId = userId;
    }
    public Product() {}
    // Getters and setters
    // ID getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Title getter and setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // EndDate getter and setter
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // Description getter and setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Status getter and setter
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // UserId getter and setter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
