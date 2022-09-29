package com.sparta;

import com.sparta.models.TrainingCentres.Bootcamp;
import com.sparta.models.TrainingCentres.TechCentre;
import com.sparta.models.TrainingCentres.TrainingCenter;
import com.sparta.models.TrainingCentres.TrainingHub;
import com.sparta.models.factory.TrainingCentreFactory;
import com.sparta.models.util.Courses;

import java.util.ArrayList;
import java.util.List;

public class Academy {
    public static List<TrainingCenter> centerList = new ArrayList<>();
    public static List<TrainingCenter> closedCenterList = new ArrayList<>();

    int month = 0;
    int totalMonth = 0;

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
                TrainingCentreFactory.generateTrainingCentre();

            }
            Trainee.generateTrainees();
            TrainingCenter.openDoors();
            TrainingCenter.closeCenters();
            month++;
            System.out.println(this.toString());
        }
    }

    @Override
    public String toString()
    {
        int bootcampOpen = 0,bootcampClosed = 0,bootcampFull = 0,techCentreOpen = 0,techCentreClosed = 0,techCentreFull = 0,hubOpen = 0,hubClosed = 0,hubFull = 0;
        for(TrainingCenter center:centerList)
        {
            if(center.getClass()== Bootcamp.class)
            {
                if (center.isFull() == false) {
                    bootcampOpen++;
                }
                else{
                    bootcampFull++;
                }
            }
            if(center.getClass()== TechCentre.class)
            {
                if (center.isFull() == false) {
                    techCentreOpen++;
                }
                else{
                    techCentreFull++;
                }
            }
            if(center.getClass()== TrainingHub.class)
            {
                if (center.isFull() == false) {
                    hubOpen++;
                }
                else{
                    hubFull++;
                }
            }
        }

        for(TrainingCenter center:closedCenterList)
        {
            if(center.getClass()== Bootcamp.class)
            {
                bootcampClosed++;
            }
            if(center.getClass()== TechCentre.class)
            {
                techCentreClosed++;
            }
            if(center.getClass()== TrainingHub.class)
            {
                hubClosed++;
            }
        }

        int JavaTraining=0, JavaWaiting=0, CsharpTraining=0, CsharpWaiting=0, DataTraining=0, DataWaiting=0, DevOpsTraining=0, DevOpsWaiting=0, BusinessTraining = 0, BusinessWaiting = 0;

        for(TrainingCenter tc:centerList)
        {
            for(Trainee t:tc.getTraineeList())
            {
                if(t.getCourse().equals(Courses.JAVA.getCourseName()))
                {
                    JavaTraining++;
                }
                else if(t.getCourse().equals(Courses.C_SHARP.getCourseName()))
                {
                    CsharpTraining++;
                }
                else if(t.getCourse().equals(Courses.DATA.getCourseName()))
                {
                    DataTraining++;
                }
                else if(t.getCourse().equals(Courses.BUSINESS.getCourseName()))
                {
                    BusinessTraining++;
                }
                else if(t.getCourse().equals(Courses.DEVOPS.getCourseName()))
                {
                    DevOpsTraining++;
                }
            }
        }

        for(Trainee t:Trainee.getWaitingList())
        {
            if(t.getCourse().equals(Courses.JAVA.getCourseName()))
            {
                JavaWaiting++;
            }
            else if(t.getCourse().equals(Courses.C_SHARP.getCourseName()))
            {
                CsharpWaiting++;
            }
            else if(t.getCourse().equals(Courses.DATA.getCourseName()))
            {
                DataWaiting++;
            }
            else if(t.getCourse().equals(Courses.BUSINESS.getCourseName()))
            {
                BusinessWaiting++;
            }
            else if(t.getCourse().equals(Courses.DEVOPS.getCourseName()))
            {
                DevOpsWaiting++;
            }
        }

        int numTrainees = getNumberOfTraineesWaiting()+getNumberOfTraineesTraining();

        return "Month: "+month+
                "\n---\nNumber of centers: "+centerList.size()+"\nNumber of open centers: "+getNumberOfOpenCentres()+"\nNumber of full centers: "+getNumberOfFullCentres()+"\nNumber of closed centers: "+closedCenterList.size()+
                "\n---\nNumber of open boot camps: " +bootcampOpen+"\nNumber of full boot camps: " +bootcampFull+"\nNumber of closed boot camps: " +bootcampClosed+
                "\n---\nNumber of tech centres open: " +techCentreOpen+"\nNumbers of tech centres full: " +techCentreFull+"\nNumbers of tech centres closed: "+techCentreClosed+
                "\n---\nNumber of training hubs open: " +hubOpen+"\nNumber of training hubs full: " +hubFull+"\nNumber of training hubs closed: " +hubClosed+

                "\n---\nNumber of trainees: "+numTrainees+"\nNumber trainees in training: "+getNumberOfTraineesTraining()+"\nNumber of trainees waiting: " +getNumberOfTraineesWaiting()+
                "\n---\nNumber of Java trainees in training: "+JavaTraining+"\nNumber of Java trainees waiting: "+JavaWaiting+
                "\n---\nNumber of C# trainees in training: "+CsharpTraining+"\nNumber of C# trainees waiting: " +CsharpWaiting+
                "\n---\nNumber of Data trainees in training: "+DataTraining+"\nNumber of Data trainees waiting: " +DataWaiting+
                "\n---\nNumber of DevOps trainees in training: "+DevOpsTraining+"\nNumber of DevOps trainees waiting: " +DevOpsWaiting+
                "\n---\nNumber of Business trainees in training: "+BusinessTraining+"\nNumber of Business trainees waiting: " +BusinessWaiting+"\n\n";
    }
    public String summaryOfSimulator()
    {

        return "Total Month: "+totalMonth+"\nNumber of open centres:\n\tTraining centers: "
                +getNumberOfOpenCentres();
    }
}