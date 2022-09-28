
package com.sparta;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputMonths = new Scanner(System.in);
        System.out.println("Enter the number of months");
        int numberofMonths = inputMonths.nextInt();

        Academy academy = new Academy();

        academy.simulate(numberofMonths);
        //Scanner employeesInput = new Scanner(System.in);
        //System.out.println("Enter the number of trainees");
        //int trainees = employeesInput.nextInt();


        //Trainee.getTraineeList().stream().forEach((t) -> {
           // System.out.println(t.getId());
       // });
    }
}