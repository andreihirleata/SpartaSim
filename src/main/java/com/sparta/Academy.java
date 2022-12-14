package com.sparta;

import com.sparta.models.TrainingCentres.Bootcamp;
import com.sparta.models.TrainingCentres.TechCentre;
import com.sparta.models.TrainingCentres.TrainingCenter;
import com.sparta.models.TrainingCentres.TrainingHub;
import com.sparta.models.TrainingCentres.factory.ClientFactory;
import com.sparta.models.TrainingCentres.factory.TrainingCentreFactory;
import com.sparta.models.util.Courses;
import com.sparta.models.util.Randomizer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Academy {
    public static Deque<Trainee> benchList = new ArrayDeque<>();
    public static List<TrainingCenter> centerList = new ArrayList<>();
    public List<Client> clientList = new ArrayList<>();
    private int unsatisfiedClients = 0;

    int month = 0;
    int totalMonth = 0;

    public int getUnsatisfiedClients() {
        return unsatisfiedClients;
    }

    public void setUnsatisfiedClients(int unsatisfiedClients) {
        this.unsatisfiedClients = unsatisfiedClients;
    }

    public void addCenter(TrainingCenter center) {
        centerList.add(center);
    }

    public int getNumberOfOpenCentres() {
        int num = 0;
        for (TrainingCenter t : centerList) {
            if (!t.isFull() && !t.getClosed()) {
                num++;
            }
        }
        return num;
    }


    public int getNumberOfFullCentres() {
        int num = 0;
        for (TrainingCenter t : centerList) {
            if (t.isFull() && !t.getClosed()) {
                num++;
            }
        }
        return num;
    }

    public int getNumberOfClosedCentres() {
        int num = 0;
        for (TrainingCenter t : centerList) {
            if (t.getClosed()) {
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

    public void clientSatisified(Client cl) {
        if(cl.getClientTraineeList().size() < cl.getNumRequired()) {
            Academy.benchList.addAll(cl.getClientTraineeList());
            this.clientList.remove(cl);
            this.setUnsatisfiedClients(this.getUnsatisfiedClients() + 1);
        } else {
            cl.getClientTraineeList().clear();
        }
    }

    public void simulate(int months,int choice) {
        for (int i = 1; i <= months; i++) {
            if (i % 2 == 0) {
                TrainingCentreFactory.generateTrainingCentre();
            }
            if (i >= 12) {
                if (Randomizer.getRandom(0, 4) == 1 || clientList.size() == 0)
                    clientList.add(ClientFactory.generateClient());
                clientList.forEach(cl -> {
                    assert Academy.benchList.peek() != null;
                    for (int j = 0; j <= Randomizer.getRandom(1, cl.getNumRequired()); j++) {
                        assert Academy.benchList.peek() != null;
                        if (Academy.benchList.stream().anyMatch(tr -> tr.getCourse().equals(cl.getCourseReq()))) {
                            cl.assignToClient(Academy.benchList.stream().filter(tr -> tr.getCourse().equals(cl.getCourseReq())).findFirst().get());
                        }
                    }

                });
                for (int j = 0; j < this.clientList.size(); j++) {
                    Client cl = this.clientList.get(j);
                    if (cl.getMonthsRunning() == 12) {
                        cl.setMonthsRunning(0);
                        clientSatisified(cl);
                    }
                }
                this.clientList.forEach(cl -> cl.setMonthsRunning(cl.getMonthsRunning() + 1));
            }


            Trainee.generateTrainees();
            TrainingCenter.openDoors();
            Academy.centerList.stream().forEach(tc -> {
                        tc.train(tc.getTraineeList());
                        tc.assingToBench();
                    }
            );
            TrainingCenter.closeCenters();
            month++;
            if (choice == 2) {
                System.out.println(this);
            }
        }
        if (choice == 1) {
            System.out.println(this);
        }
    }

    @Override
    public String toString() {
        int JavaTraining = 0, JavaWaiting = 0, CsharpTraining = 0, CsharpWaiting = 0, DataTraining = 0, DataWaiting = 0, DevOpsTraining = 0, DevOpsWaiting = 0, BusinessTraining = 0, BusinessWaiting = 0;

        for (TrainingCenter tc : centerList) {
            for (Trainee t : tc.getTraineeList()) {
                if(t==null)
                {
                    continue;
                }
                if (t.getCourse().equals(Courses.JAVA.getCourseName())) {
                    JavaTraining++;
                } else if (t.getCourse().equals(Courses.C_SHARP.getCourseName())) {
                    CsharpTraining++;
                } else if (t.getCourse().equals(Courses.DATA.getCourseName())) {
                    DataTraining++;
                } else if (t.getCourse().equals(Courses.BUSINESS.getCourseName())) {
                    BusinessTraining++;
                } else if (t.getCourse().equals(Courses.DEVOPS.getCourseName())) {
                    DevOpsTraining++;
                }
            }
        }

        for (Trainee t : Trainee.getWaitingList()) {
            if (t.getCourse().equals(Courses.JAVA.getCourseName())) {
                JavaWaiting++;
            } else if (t.getCourse().equals(Courses.C_SHARP.getCourseName())) {
                CsharpWaiting++;
            } else if (t.getCourse().equals(Courses.DATA.getCourseName())) {
                DataWaiting++;
            } else if (t.getCourse().equals(Courses.BUSINESS.getCourseName())) {
                BusinessWaiting++;
            } else if (t.getCourse().equals(Courses.DEVOPS.getCourseName())) {
                DevOpsWaiting++;
            }
        }

        return "Month: " + month +

                "\n---\nNumber of centers: " + centerList.size() +
                "\nNumber of open centers: " + centerList.stream().filter(e -> !e.getClosed()).count() +
                "\nNumber of full centers: " + centerList.stream().filter(TrainingCenter::isFull).count() +
                "\nNumber of closed centers: " + centerList.stream().filter(TrainingCenter::getClosed).count() +

                "\n---\nNumber of open boot camps: " + centerList.stream().filter(e -> e instanceof Bootcamp).filter(e -> !e.getClosed()).count() +
                "\nNumber of full boot camps: " + centerList.stream().filter(e -> e instanceof Bootcamp).filter(TrainingCenter::isFull).count() +
                "\nNumber of closed boot camps: " + centerList.stream().filter(e -> e instanceof Bootcamp).filter(e -> e.isClosed()).count() +

                "\n---\nNumber of open tech centres: " + centerList.stream().filter(e -> e instanceof TechCentre).filter(e -> !e.isClosed()).count() +
                "\nNumber of full tech centres: " + centerList.stream().filter(e -> e instanceof TechCentre).filter(e -> e.isFull()).count() +
                "\nNumber of closed tech centres: " + centerList.stream().filter(e -> e instanceof TechCentre).filter(e -> e.isClosed()).count() +

                "\n---\nNumber of open training hubs: " + centerList.stream().filter(e -> e instanceof TrainingHub).filter(e -> !e.isClosed()).count() +
                "\nNumber of full training hubs: " + centerList.stream().filter(e -> e instanceof TrainingHub).filter(e -> e.isFull()).count() +
                "\nNumber of closed training hubs: " + centerList.stream().filter(e -> e instanceof TrainingHub).filter(e -> e.isClosed()).count() +

                "\n---\nNumber of happy clients: " + this.clientList.size() +
                "\nNumber of unhappy clients : " + this.unsatisfiedClients +

                "\n---\nNumber of Java trainees in training: " + JavaTraining + "\nNumber of Java trainees waiting: " + JavaWaiting +
                "\n---\nNumber of C# trainees in training: " + CsharpTraining + "\nNumber of C# trainees waiting: " + CsharpWaiting +
                "\n---\nNumber of Data trainees in training: " + DataTraining + "\nNumber of Data trainees waiting: " + DataWaiting +
                "\n---\nNumber of DevOps trainees in training: " + DevOpsTraining + "\nNumber of DevOps trainees waiting: " + DevOpsWaiting +
                "\n---\nNumber of Business trainees in training: " + BusinessTraining + "\nNumber of Business trainees waiting: " + BusinessWaiting +
                "\n---\nNumber of trainees on the bench: " + Academy.benchList.size() +
                 "\n---\nNumber of trainees in training: " + getNumberOfTraineesTraining() + "\nNumber of trainees waiting: " + getNumberOfTraineesWaiting() + "\n";
    }

    public String summaryOfSimulator() {

        return "Total Month: " + totalMonth + "\nNumber of open centres:\n\tTraining centers: "
                + getNumberOfOpenCentres();
    }
}