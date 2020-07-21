package com.aarshinkov.projects.pn;

public final class Gender {

    private String gender;

    public Gender(Integer number) {
        setGender(number);
    }

    private void setGender(Integer number) {
        gender = number % 2 == 0 ? "Мъж" : "Жена";
    }

    public String getGender() {
        return gender;
    }
}
