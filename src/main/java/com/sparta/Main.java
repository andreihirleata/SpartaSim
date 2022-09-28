//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.sparta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner inputMonths = new Scanner(System.in);
        System.out.println("Enter the number of months");
        int numberofMonths = inputMonths.nextInt();

        Academy academy = new Academy();
        //Scanner employeesInput = new Scanner(System.in);
        //System.out.println("Enter the number of trainees");
        //int trainees = employeesInput.nextInt();
        for(int i=0;i<=numberofMonths;i++)
        {
            if(i%2==0)
            {
                academy.addCenter(new TrainingCenter());
            }
//            Trainee.generateTrainees();
//            Trainee.openDoors();
        }

//        Trainee.getTraineeList().stream().forEach((t) -> {
//            System.out.println(t.getId());
//        });
        System.out.println(academy);
    }
}