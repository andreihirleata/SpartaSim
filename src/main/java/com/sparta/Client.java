package com.sparta;

import com.sparta.models.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private static int idIncrement = 0;
    private final int id;
    private int numRequired;
    private String courseReq;
    private int monthsRunning = 0;
    private List<Trainee> ClientTraineeList = new ArrayList<>();
public Client(String course){
    this.courseReq = course;
    this.numRequired = Randomizer.getRandom(15,100);
    this.id = idIncrement++;
}

    public int getId() {
        return id;
    }

    public int getNumRequired() {
        return numRequired;
    }


    public String getCourseReq() {
        return courseReq;
    }

    public void setClientTraineeList(List<Trainee> clientTraineeList) {
        ClientTraineeList = clientTraineeList;
    }

    public List<Trainee> getClientTraineeList() {
        return ClientTraineeList;
    }

    public int getMonthsRunning() {
        return monthsRunning;
    }

    public void setMonthsRunning(int monthsRunning) {
        this.monthsRunning = monthsRunning;
    }

    public void assignToClient(Trainee tr) {
        if(tr.getCourse().equals(this.courseReq)) {
            this.getClientTraineeList().add(tr);
            Academy.benchList.remove(tr);
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", numRequired=" + numRequired +
                ", courseReq='" + courseReq + '\'' +
                ", ClientTraineeList=" + ClientTraineeList +
                '}';
    }
}
