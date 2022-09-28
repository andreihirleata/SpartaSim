package com.sparta.models.factory;

import com.sparta.Trainee;
import com.sparta.models.util.Courses;
import com.sparta.models.util.Randomizer;

public class TraineeFactory {
    public static Trainee generateTrainee(){
        switch(Randomizer.getRandom(0,4)) {
            case 0 : return new Trainee(Courses.JAVA.getCourseName());
            case 1 : return new Trainee(Courses.C_SHARP.getCourseName());
            case 2 : return new Trainee(Courses.DATA.getCourseName());
            case 3 : return new Trainee(Courses.DEVOPS.getCourseName());
            case 4 : return new Trainee(Courses.BUSINESS.getCourseName());
           default:
               throw new IllegalStateException("Unexpected value: " + Randomizer.getRandom(0, 4));
       }
    }
}
