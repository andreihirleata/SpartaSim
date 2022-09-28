package com.sparta.models.util;

public enum Courses {
    JAVA("Java Course"),
    C_SHARP ("C# Course"),
    DATA("Data course"),
    DEVOPS("Devops course"),
    BUSINESS("Business course"),
    ;

    private final String courseName;

    public String getCourseName() {
        return courseName;
    }

    private Courses(String courseName){
        this.courseName= courseName;
    }

}
