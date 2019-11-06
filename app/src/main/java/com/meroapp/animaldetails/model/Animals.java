package com.meroapp.animaldetails.model;


public class Animals {

    private String name,gender,age;
    private int imageId;

    public Animals(String name, String gender, String age, int imageId) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
