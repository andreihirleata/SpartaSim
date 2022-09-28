package com.sparta;

import com.sparta.models.TrainingCentres.Bootcamp;
import com.sparta.models.TrainingCentres.TechCentre;
import com.sparta.models.TrainingCentres.TrainingCenter;
import com.sparta.models.TrainingCentres.TrainingHub;
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
        for (TrainingCenter t : centerList) {
            if (t.isFull() == false) {
                num++;
            }
        }
        return num;
    }

    public int getNumberOfFullCentres() {
        int num = 0;
        for (TrainingCenter t : centerList) {
            if (t.isFull() == true) {
                num++;
            }
        }
        return num;
    }

    public int getNumberOfTraineesTraining() {
        int num = 0;
        for (TrainingCenter t : centerList) {
            num += t.getTraineeList().size();
        }
        return num;
    }

    public int getNumberOfTraineesWaiting() {
        return Trainee.getWaitingList().size();
    }

    public void simulate(int months) {
        for (int i = 1; i <= months; i++) {
            if (i % 2 == 0) {
                TrainingCentreFactory.generateTrainingCentre();

            }
            Trainee.generateTrainees();
            TrainingCenter.openDoors();
            if (i > 3) {
                TrainingCenter.closeCenters();
            }
            month++;
            System.out.println(this);
        }
    }

    @Override
    public String toString() {
        int bootcampOpen = 0;
        int bootcampClosed = 0;
        int bootcampFull = 0;
        for (TrainingCenter boot : centerList) {
            if (boot.closed == true) {
                bootcampClosed = bootcampClosed + 1;
            } else if (boot.getClass() == Bootcamp.class) {
                if (boot.isFull() == false) {
                    bootcampOpen = bootcampOpen + 1;
                } else {
                    bootcampFull = bootcampFull + 1;
                }
            }
        }
        int techCentreOpen = 0;
        int techCentreClosed = 0;
        int techCentreFull = 0;
        for (TrainingCenter tech : centerList) {
            if (tech.closed == true) {
                techCentreClosed = techCentreClosed + 1;
            }
            if (tech.getClass() == TechCentre.class) {
                if (tech.isFull() == false) {
                    techCentreOpen = techCentreOpen + 1;
                } else {
                    techCentreFull = techCentreFull + 1;
                }
            }
        }
        int hubOpen = 0;
        int hubClosed = 0;
        int hubFull = 0;
        for (TrainingCenter hub : centerList) {
            if (hub.closed == true) {
                hubClosed = hubClosed + 1;
            }
            if (hub.getClass() == TrainingHub.class) {
                if (hub.isFull() == false) {
                    hubOpen = hubOpen + 1;
                } else {
                    hubFull = hubFull + 1;
                }
            }
        }

        return "Month: " + month + "\nNumber of open boot camps: "
                + bootcampOpen + "\nNumber of full boot camps: "
                + bootcampFull + "\nNumber of closed boot camps: "
                + bootcampClosed + "\nNumbers of tech centres open: "
                + techCentreOpen + "\nNumbers of tech centres full: "
                + techCentreFull + "\nNumbers of tech centres closed: "
                + techCentreClosed + "\nNumbers of training hubs open: "
                + hubOpen + "\nNumber of training hubs full: "
                + hubFull + "\nNumber of training hubs closed: "
                + hubClosed + "\nNumbers trainees in training: "
                + this.getNumberOfTraineesTraining() + "\nNumber of trainees on the waiting list: "
                + this.getNumberOfTraineesWaiting() + "\n";
    }
}