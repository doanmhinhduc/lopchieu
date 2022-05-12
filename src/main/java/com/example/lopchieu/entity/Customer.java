package com.example.lopchieu.entity;

import java.time.LocalDateTime;

public class Customer {

    private int Id;
    private String Name;
    private String phone;
    private String Image;
    private LocalDateTime dob;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private int status;

    public Customer() {

    }

    public Customer(int id, String name, String phone, String image, LocalDateTime dob, LocalDateTime createAt, LocalDateTime updateAt, int status) {
        Id = id;
        Name = name;
        this.phone = phone;
        Image = image;
        this.dob = dob;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", phone='" + phone + '\'' +
                ", Image='" + Image + '\'' +
                ", dob=" + dob +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
