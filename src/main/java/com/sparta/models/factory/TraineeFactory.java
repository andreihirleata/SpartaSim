package com.sparta.models.factory;

import com.sparta.Trainee;

public class TraineeFactory {
    public static Trainee generateTrainee(){
        return new Trainee("String");
    }
}
