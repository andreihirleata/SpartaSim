
package com.sparta;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputMonths = new Scanner(System.in);
        System.out.println("Enter the number of months");
        int numberofMonths = inputMonths.nextInt();
        Scanner inputSummary = new Scanner(System.in);
        System.out.println("Would you prefer to see a monthly breakdown or summary of the simulator?\nFor the summary of the simulator, type [1]\nFor monthly breakdown, type [2]");
        int summaryOption = inputSummary.nextInt();
        Academy academy = new Academy();
        if (summaryOption == 1) {
            academy.simulate(numberofMonths);
        } else if (summaryOption == 2) {
            System.out.println(academy.summaryOfSimulator());
        }
    }
}