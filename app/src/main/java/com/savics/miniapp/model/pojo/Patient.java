package com.savics.miniapp.model.pojo;

import androidx.annotation.NonNull;

public class Patient {

    private String fullName;
    private String email;
    private int age;
    private char gender;

    public Patient(String fullName, String email, int age, char gender) {
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @NonNull
    @Override
    public String toString() {
        return "Patient {fullname = '" + fullName + "', gender = '" + gender
                + "', age = " + age + "}";
    }
}
