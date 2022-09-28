package com.sparta;

import com.sparta.models.TrainingCentres.TrainingCenter;
import com.sparta.models.factory.TrainingCentreFactory;

import java.util.ArrayList;
import java.util.List;

public class Academy {
    public static List<TrainingCenter> centerList = new ArrayList<>();

    int month = 0;

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

    public void simulate(int months) {
        for(int i=1;i<=months;i++)
        {
            if(i%2==0)
            {
                addCenter( TrainingCentreFactory.generateTrainingCentre());

            }
            Trainee.generateTrainees();
            TrainingCenter.openDoors();
            month++;
            System.out.println(this.toString());
        }
    }

    @Override
    public String toString()
    {
        return "Month: "+month+"\nNumber of open centers: "
                +this.getNumberOfOpenCentres()+"\nNumber of full centers: "
                +this.getNumberOfFullCentres()+"\nNumbers trainees in training: "
                +this.getNumberOfTraineesTraining()+"\nNumber of trainees on the waiting list: "
                +this.getNumberOfTraineesWaiting()+"\n";
    }
}