//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.sparta;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Academy academy = new Academy();
        TrainingCenter center1 = new TrainingCenter();
        TrainingCenter center2 = new TrainingCenter();
        TrainingCenter center3 = new TrainingCenter();
        academy.addCenter(center1);

        //Scanner employeesInput = new Scanner(System.in);
        //System.out.println("Enter the number of trainees");
        //int trainees = employeesInput.nextInt();
        //Scanner inputMonths = new Scanner(System.in);
        //System.out.println("Enter the number of months");
        //int numberofMonths = inputMonths.nextInt();
        Trainee.generateTrainees();
        Trainee.generateTrainees();
        Trainee.openDoors();
        Trainee.openDoors();
        Trainee.openDoors();
        Trainee.openDoors();
        Trainee.getTraineeList().stream().forEach((t) -> {
            System.out.println(t.getId());
        });
        System.out.println(academy);
    }
}
