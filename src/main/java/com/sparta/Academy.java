package com.sparta;

import com.sparta.models.TrainingCentres.Bootcamp;
import com.sparta.models.TrainingCentres.TechCentre;
import com.sparta.models.TrainingCentres.TrainingCenter;
import com.sparta.models.factory.TrainingCentreFactory;
import com.sparta.models.util.Courses;

import java.util.ArrayList;
import java.util.List;

public class Academy {
    public static List<TrainingCenter> centerList = new ArrayList<>();

    int month = 0;
    int totalMonth = 0;

    public void addCenter(TrainingCenter center) {
        centerList.add(center);
    }

    public int getNumberOfOpenCentres() {
        int num = 0;
        for(TrainingCenter t:centerList)
        {
            if (t.isFull() == false && t.closed==false) {
                num++;
            }
        }
        return num;
    }

    public int getNumberOfFullCentres() {
        int num = 0;
        for(TrainingCenter t:centerList)
        {
            if (t.isFull() == true && t.closed==false) {
                num++;
            }
        }
        return num;
    }
    public int getNumberOfClosedCentres() {
        int num = 0;
        for(TrainingCenter t:centerList)
        {
            if(t.closed==true)
            {
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
            month++;
            System.out.println(this.toString());
        }
    }

    @Override
    public String toString()
    {
        int bootcampOpen = 0;
        int bootcampClosed = 0;
        int bootcampFull = 0;
        for(TrainingCenter boot:centerList)
        {
            if(boot.closed==true)
            {
                bootcampClosed++;
            }
            else if(boot.getClass()== Bootcamp.class)
            {
                if (boot.isFull() == false) {
                    bootcampOpen++;
                }
                else{
                    bootcampFull++;
                }
            }
        }
        int techCentreOpen = 0;
        int techCentreClosed = 0;
        int techCentreFull = 0;
        for(TrainingCenter tech:centerList)
        {
            if(tech.closed==true)
            {
                techCentreClosed++;
            }
            if(tech.getClass()== TechCentre.class)
            {
                if (tech.isFull() == false) {
                    techCentreOpen++;
                }
                else{
                    techCentreFull++;
                }
            }
        }
        int hubOpen = 0;
        int hubClosed = 0;
        int hubFull = 0;
        for(TrainingCenter hub:centerList)
        {
            if(hub.closed==true)
            {
                hubClosed++;
            }
            if(hub.getClass()== TrainingCenter.class)
            {
                if (hub.isFull() == false) {
                    hubOpen++;
                }
                else{
                    hubFull++;
                }
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

        return "Month: "+month+
                "\n---\nNumber of full centers: "+this.getNumberOfFullCentres()+"\nNumber of open centers: "+this.getNumberOfOpenCentres()+"\nNumber of closed centers: "+this.getNumberOfOpenCentres()+
                "\n---\nNumber of open boot camps: " +bootcampOpen+"\nNumber of full boot camps: " +bootcampFull+"\nNumber of closed boot camps: " +bootcampClosed+
                "\n---\nNumbers of tech centres open: " +techCentreOpen+"\nNumbers of tech centres full: " +techCentreFull+"\nNumbers of tech centres closed: "+techCentreClosed+
                "\n---\nNumbers of training hubs open: " +hubOpen+"\nNumber of training hubs full: " +hubFull+"\nNumber of training hubs closed: " +hubClosed+

                "\n---\nNumbers trainees in training: "+this.getNumberOfTraineesTraining()+"\nNumber of trainees waiting: " +this.getNumberOfTraineesWaiting()+
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