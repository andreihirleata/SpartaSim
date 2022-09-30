package com.sparta.models.util;

import com.sparta.Trainee;

public class CourseComparator {
    public static boolean checkSameCourse(Trainee t, String courseName) {
        return t.getCourse().equals(courseName);
    }
}
