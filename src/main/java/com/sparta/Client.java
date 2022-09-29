package com.sparta;

import com.sparta.models.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private int numRequired;
    private String courseReq;
    public List<Trainee> ClientTraineeList = new ArrayList<>();
public Client(String course){
    this.courseReq = course;
    this.numRequired = Randomizer.getRandom(15,100);
    setId(id++);
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumRequired() {
        return numRequired;
    }


    public String getCourseReq() {
        return courseReq;
    }

}
