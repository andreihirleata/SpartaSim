package com.sparta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Academy {
    public static List<TrainingCenter> centerList = new ArrayList<>();

    public void addCenter(TrainingCenter center) {
        centerList.add(center);
    }

    public int getNumberOfOpenCentres() {
        int num = 0;
        for(TrainingCenter t:centerList)
        {
            if (t.isFull() == false) {
                num++;
            }
        }
        return num;
    }

    public int getNumberOfFullCentres() {
        int num = 0;
        for(TrainingCenter t:centerList)
        {
            if (t.isFull() == true) {
                num++;
            }
        }
        return num;
    }

    public int getNumberOfTraineesTraining() {
        int num=0;
        for(TrainingCenter t:centerList)
        {
            num+=t.getTraineeList().size();
        }
        return num;
    }

    public int getNumberOfTraineesWaiting() {
        return Trainee.getWaitingList().size();
    }

    @Override
    public String toString()
    {
        return "Number of open centers: "+this.getNumberOfOpenCentres()+"\nNumber of full centers: "+this.getNumberOfFullCentres()+"\nNumbers trainees in training: "+this.getNumberOfTraineesTraining()+"\nNumber of trainees on the waiting list: "+this.getNumberOfTraineesWaiting();
    }
}