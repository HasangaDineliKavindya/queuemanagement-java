package com.example.dineli;

import javafx.application.Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FoodQ {
    static Customer[][] Cashier = new Customer[3][];
    static int BurgerStock = 50;
    static int SoldBurgers = 0;

    static int Queue1BurgerCount = 0;
    static int Queue2BurgerCount = 0;
    static int Queue3BurgerCount = 0;
    public static Customer[] WaitingList = new Customer[10];
    static int waitingListSize = 0;
    public Customer[] WaitingQueue;


    public void Queues() {
        Cashier[0] = new Customer[2];
        Cashier[1] = new Customer[3];
        Cashier[2] = new Customer[5];

    }

    //method to view all queues
    public static void ViewAllQueues() {
        System.out.println("****************");
        System.out.println("*   Cashiers   *");
        System.out.println("****************");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < Cashier.length; j++) {
                if (i < Cashier[j].length) {
                    if (Cashier[j][i] == null) {
                        System.out.print(" x    ");
                    } else {
                        System.out.print(" o    ");
                    }
                } else {
                    System.out.print("      ");
                }
            }
            System.out.println();
        }
    }


    public void ViewEmptyQueues() {

        boolean ContainsNullLine1 = false;
        boolean ContainsNullLine2 = false;
        boolean ContainsNullLine3 = false;

        System.out.println("****************");
        System.out.println("*   Cashiers   *");
        System.out.println("****************");

        for (Customer element : Cashier[0]) {
            if (element == null) {
                ContainsNullLine1 = true;
                break;
            }
        }

        for (Customer element : Cashier[1]) {
            if (element == null) {
                ContainsNullLine2 = true;
                break;
            }
        }

        for (Customer element : Cashier[2]) {
            if (element == null) {
                ContainsNullLine3 = true;
                break;
            }
        }
        if(ContainsNullLine1 && ContainsNullLine2 && ContainsNullLine3) {
            System.out.printf("%2s %5s %6s %n", Cashier[0][0] != null ? "o" : "x", Cashier[1][0] != null ? "o" : "x", Cashier[2][0] != null ? "o" : "x");
            System.out.printf("%2s %5s %6s %n", Cashier[0][1] != null ? "o" : "x", Cashier[1][1] != null ? "o" : "x", Cashier[2][1] != null ? "o" : "x");
            System.out.printf("%8s %6s %n", Cashier[1][2] != null ? "o" : "x", Cashier[2][2] != null ? "o" : "x");
            System.out.printf("%15s %n", Cashier[2][3] != null ? "o" : "x");
        } else if (ContainsNullLine1 && ContainsNullLine2) {
            System.out.printf("%2s %5s %n", Cashier[0][0] != null ? "o" : "x", Cashier[1][0] != null ? "o" : "x");
            System.out.printf("%2s %5s %n", Cashier[0][1] != null ? "o" : "x", Cashier[1][1] != null ? "o" : "x");
            System.out.printf("%8s %n", Cashier[1][2] != null ? "o" : "x");
        } else if (ContainsNullLine1 && ContainsNullLine3){
            System.out.printf("%2s %12s %n", Cashier[0][0] != null ? "o" : "x", Cashier[2][0] != null ? "o" : "x");
            System.out.printf("%2s %12s %n", Cashier[0][1] != null ? "o" : "x", Cashier[2][1] != null ? "o" : "x");
            System.out.printf("%15s %n", Cashier[2][2] != null ? "o" : "x");
            System.out.printf("%15s %n", Cashier[2][3] != null ? "o" : "x");
            System.out.printf("%15s %n", Cashier[2][4] != null ? "o" : "x");
        } else if (ContainsNullLine2 && ContainsNullLine3) {
            System.out.printf("%8s %6s %n",Cashier[1][0] != null ? "o" : "x",Cashier[2][0]!= null ? "o" : "x");
            System.out.printf("%8s %6s %n",Cashier[1][1]!= null ? "o" : "x",Cashier[2][1]!= null ? "o" : "x");
            System.out.printf("%8s %6s %n",Cashier[1][2]!= null ? "o" : "x",Cashier[2][2]!= null ? "o" : "x");
            System.out.printf("%15s %n",Cashier[2][3]!= null ? "o" : "x");
            System.out.printf("%15s %n",Cashier[2][4]!= null ? "o" : "x");
        } else if (ContainsNullLine1) {
            System.out.printf("%2s %n",Cashier[0][0]!= null ? "o" : "x");
            System.out.printf("%2s %n",Cashier[0][1]!= null ? "o" : "x");
        } else if (ContainsNullLine2) {
            System.out.printf("%8s %n",Cashier[1][0]!= null ? "o" : "x");
            System.out.printf("%8s %n",Cashier[1][1]!= null ? "o" : "x");
            System.out.printf("%8s %n",Cashier[1][2]!= null ? "o" : "x");
        }else {
            System.out.printf("%15s %n",Cashier[2][0]!= null ? "o" : "x");
            System.out.printf("%15s %n",Cashier[2][1]!= null ? "o" : "x");
            System.out.printf("%15s %n",Cashier[2][2]!= null ? "o" : "x");
            System.out.printf("%15s %n",Cashier[2][3]!= null ? "o" : "x");
            System.out.printf("%15s %n",Cashier[2][4]!= null ? "o" : "x");
        }

    }


    public static int CheckQueueLength(int Queue) {
        int Counter = 0;

        if (Queue == 1) {
            for (int i = 0; i < 2; i++) {
                if (Cashier[0][i] != null) {
                    Counter += 1;
                }
            }
        }

        if (Queue == 2) {
            for (int i = 0; i < 3; i++) {
                if (Cashier[1][i] != null) {
                    Counter += 1;
                }
            }
        }

        if (Queue == 3) {
            for (int i = 0; i < 5; i++) {
                if (Cashier[2][i] != null) {
                    Counter += 1;
                }
            }
        }

        return Counter;
    }

    public static int FindTheSmallestQueue() {
        int SmallestQueue = 0;
        int Queue1Length = CheckQueueLength(1);
        int Queue2Length = CheckQueueLength(2);
        int Queue3Length = CheckQueueLength(3);

        if (Queue1Length != 2 || Queue2Length != 3 || Queue3Length != 5) {
            if (Queue1Length <= Queue2Length && Queue1Length <= Queue3Length && Queue1Length != 2) {
                SmallestQueue = 1;
            } else if (Queue2Length <= Queue1Length && Queue2Length <= Queue3Length && Queue2Length != 3) {
                SmallestQueue = 2;
            } else {
                SmallestQueue = 3;
            }
        } else {
            System.out.println("Queues are Full please wait");
            return -1;
        }

        return SmallestQueue;
    }


    public static void AddCustomer() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Customer's First name : ");
        String FirstName = input.next();

        System.out.print("Enter Customer's Last name : ");
        String LastName = input.next();

        int BurgersRequired = 0;
        boolean ValidInput = false;

        while (!ValidInput) {
            System.out.print("Enter how many Burgers required: ");
            if (input.hasNextInt()) {
                BurgersRequired = input.nextInt();
                ValidInput = true;
            } else {
                System.out.println("Wrong input. Please enter a valid integer.");
                input.next(); // Clear the invalid input from the scanner
            }
        }

        Customer Person = new Customer(FirstName, LastName, BurgersRequired);

        int SmallestQueue = FindTheSmallestQueue();

        if(SmallestQueue == -1){
            //Check if there is a customer in the waiting list
            if (waitingListSize < WaitingList.length) {
                WaitingList[waitingListSize] = Person;
                waitingListSize++;
            } else {
                System.out.println("Waiting list is full. Customer cannot be added.");
            }

        }else if (SmallestQueue == 1) {
            Queue1BurgerCount += BurgersRequired;
            for (int i = 0; i < Cashier[0].length; i++) {
                if (Cashier[0][i] == null) {
                    Cashier[0][i] = Person;
                    break;
                }
            }
        } else if (SmallestQueue == 2) {
            Queue2BurgerCount += BurgersRequired;
            for (int i = 0; i < Cashier[1].length; i++) {
                if (Cashier[1][i] == null) {
                    Cashier[1][i] = Person;
                    break;
                }
            }
        } else if (SmallestQueue == 3) {
            Queue3BurgerCount += BurgersRequired;
            for (int i = 0; i < Cashier[2].length; i++) {
                if(Cashier[2][Cashier[2].length - 1] != null){
                    if (waitingListSize < WaitingList.length) {
                        WaitingList[waitingListSize++] = Person;
                        System.out.println("Customer added to the waiting list.");
                    } else {
                        System.out.println("Waiting list is full. Cannot add customer.");
                    }
                } else if (Cashier[2][i] == null) {
                    Cashier[2][i] = Person;
                    break;
                }
            }
            System.out.println("Cashier:");
            System.out.println(Arrays.toString(Cashier));
            System.out.println("Waiting list:");
            System.out.println(Arrays.toString(WaitingList));


        }

        ViewAllQueues();
    }


    public void RemoveCustomer() {
        // method to remove a customer in a specific location

        try {

            Scanner input2 = new Scanner(System.in);
            int WhichQueue;
            int WhichOne;
            // looping until get correct input
            do {

                System.out.print("Enter the Queue to remove the customer (1,2 or 3):");
                WhichQueue = input2.nextInt();

                if (WhichQueue > 3 || WhichQueue < 1) {
                    System.out.println("Invalid Input");
                }

            } while (WhichQueue > 3 || WhichQueue < 1);


            if (WhichQueue == 1) {

                // looping until get correct input
                do {

                    System.out.print("Which one (1,2,....):");
                    WhichOne = input2.nextInt();

                    if (WhichOne < 1 || WhichOne > Cashier[0].length) {
                        System.out.println("Invalid Input");
                    }

                } while (WhichOne < 1 || WhichOne > Cashier[0].length);

                if (Cashier[0][WhichOne - 1] != null) {
                    for (int i = WhichOne - 1; i < 1; i++) {
                        Cashier[0][i] = Cashier[0][i + 1];

                    }
                    Cashier[0][1] = null;
                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                    System.out.println("\n");
                }


            } else if (WhichQueue == 2) {
                // looping until get correct input
                do {

                    System.out.print("Which one (1,2,....):");
                    WhichOne = input2.nextInt();

                    if (WhichOne < 1 || WhichOne > Cashier[1].length) {
                        System.out.println("Invalid Input");
                    }

                } while (WhichOne < 1 || WhichOne > Cashier[1].length);

                if (Cashier[1][WhichOne - 1] != null) {
                    for (int i = WhichOne - 1; i < 2; i++) {
                        Cashier[1][i] = Cashier[1][i + 1];

                    }
                    Cashier[1][2] = null;
                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                    System.out.println("\n");
                }


            } else {

                // looping until get correct input
                do {

                    System.out.print("Which one (1,2,....):");
                    WhichOne = input2.nextInt();

                    if (WhichOne < 1 || WhichOne > Cashier[2].length) {
                        System.out.println("Invalid Input");
                    }

                } while (WhichOne < 1 || WhichOne > Cashier[2].length);

                if (Cashier[2][WhichOne - 1] != null) {
                    for (int i = WhichOne - 1; i < 4; i++) {
                        Cashier[2][i] = Cashier[2][i + 1];

                    }
                    Cashier[2][4] = null;
                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                    System.out.println("\n");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
        }

        ViewAllQueues();

    }

    public void RemoveServedCustomer() {
//Method for remove served customer
        try {
            int WhichQueue;
            int RequiredBurgerCount;

            Scanner input3 = new Scanner(System.in);

            do {

                System.out.print("Enter the Queue to remove the customer (1,2 or 3):");
                WhichQueue = input3.nextInt();

                if (WhichQueue > 3 || WhichQueue < 1) {
                    System.out.println("Invalid Input");
                }

            } while (WhichQueue > 3 || WhichQueue < 1);

            int CustomerCount;

            if (WhichQueue == 1) {
                RequiredBurgerCount = Cashier[0][0].getBurgersRequired();
                SoldBurgers += RequiredBurgerCount;
                BurgerStock = BurgerStock - RequiredBurgerCount;
                CustomerCount = CheckQueueLength(1);

                if (CustomerCount != 0) {
                    for (int i = 0; i < 1; i++) {
                        Cashier[0][i] = Cashier[0][i + 1];
                    }
                    Cashier[0][1] = null;
                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                }

            } else if (WhichQueue == 2) {
                RequiredBurgerCount = Cashier[1][0].getBurgersRequired();
                BurgerStock = BurgerStock - RequiredBurgerCount;
                CustomerCount = CheckQueueLength(2);

                if (CustomerCount != 0) {
                    for (int i = 0; i < 2; i++) {
                        Cashier[1][i] = Cashier[1][i + 1];
                    }
                    Cashier[1][2] = null;
                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                }
            } else {
                RequiredBurgerCount = Cashier[2][0].getBurgersRequired();
                BurgerStock = BurgerStock - RequiredBurgerCount;
                CustomerCount = CheckQueueLength(3);

                if (CustomerCount != 0) {
                    for (int i = 0; i < 4; i++) {
                        Cashier[2][i] = Cashier[2][i + 1];
                    }
                    Cashier[2][4] = null;
                } else {
                    System.out.println("No customer to remove"); //If there are no customers in the queue
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
        }
        ViewAllQueues();

        int SmallestQueue = FindTheSmallestQueue();

        int BurgersRequired = 0;
        Customer Person = null;
        if (SmallestQueue == 1) {
            Queue1BurgerCount += BurgersRequired;
            for (int i = 0; i < Cashier[0].length; i++) {
                if (Cashier[0][i] == null) {
                    Cashier[0][i] = Person;
                    break;
                }
            }
        } else if (SmallestQueue == 2) {
            Queue2BurgerCount += BurgersRequired;
            for (int i = 0; i < Cashier[1].length; i++) {
                if (Cashier[1][i] == null) {
                    Cashier[1][i] = Person;
                    break;
                }
            }
        } else if (SmallestQueue == 3) {
            Queue3BurgerCount += BurgersRequired;
            for (int i = 0; i < Cashier[2].length; i++) {
                if (Cashier[2][i] == null) {
                    Cashier[2][i] = Person;
                    break;
                } else {
                    // All food queues are full, add customer to the waiting list
                    if (waitingListSize < WaitingList.length) {
                        WaitingList[waitingListSize++] = Person;
                        System.out.println("Customer added to the waiting list.");
                    } else {
                        System.out.println("Waiting list is full. Cannot add customer.");
                    }
                }
                // Remove the customer from the waiting list
                for (i = 0; i < waitingListSize - 1; i++) {
                    WaitingList[i] = WaitingList[i + 1];
                }
                WaitingList[waitingListSize - 1] = null;
                waitingListSize--;

            }
            System.out.println("Cashier:");
            System.out.println(Arrays.toString(Cashier));
            System.out.println("Waiting list:");
            System.out.println(Arrays.toString(WaitingList));

            ViewAllQueues();
        }

    }


    public void ViewCustomers() {
        //Method to view customers in alpebatical order

        String[][] CustomerLine = new String[3][]; // 2D array for store customer names


        // set size for 2D array element which stored customer names
        CustomerLine[0] = new String[2];
        CustomerLine[1] = new String[3];
        CustomerLine[2] = new String[5];

        //Get data from Cashier and store it in CustomerLine Array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < Cashier[i].length; j++) {
                if (Cashier[i][j] != null) {
                    CustomerLine[i][j] = Cashier[i][j].getFirstName() + " " + Cashier[i][j].getLastName();
                }
            }
        }


        try {

            // Flatten the 2D array into a 1D array
            String[] flattenedArray = Arrays.stream(CustomerLine)
                    .flatMap(Arrays::stream)
                    .toArray(String[]::new);

            // Bubble sort algorithm to Sort customers in alphabetical order
            int n = flattenedArray.length;
            boolean swapped;

            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (flattenedArray[j] != null && flattenedArray[j + 1] != null && flattenedArray[j].compareTo(flattenedArray[j + 1]) > 0) {
                        // Swap array[j] and array[j+1]
                        String temp = flattenedArray[j];
                        flattenedArray[j] = flattenedArray[j + 1];
                        flattenedArray[j + 1] = temp;
                        swapped = true;
                    }
                }

                // If no two elements were swapped in the inner loop, the array is already sorted
                if (!swapped) {
                    break;
                }
            }

            for (String item : flattenedArray) {
                if (item != null) {
                    System.out.println(item);
                }
            }

        } catch (NullPointerException e) {
            System.out.println("No customers to show");
        }
    }


    public void AddDataToFile() {


        String[][] CustomerLine = new String[3][]; // 2D array for store customer names


        // set size for 2D array element which stored customer names
        CustomerLine[0] = new String[2];
        CustomerLine[1] = new String[3];
        CustomerLine[2] = new String[5];

        //Get data from Cashier and store it in CustomerLine Array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < Cashier[i].length; j++) {
                if (Cashier[i][j] != null) {
                    CustomerLine[i][j] = Cashier[i][j].getFirstName() + " " + Cashier[i][j].getLastName() + " " + Cashier[i][j].getBurgersRequired() + " Burgers Required ";
                }
            }
        }

        try {
            File customerDetails = new File("QueueManagementDetails.txt");
            FileWriter Details = new FileWriter(customerDetails);

            Details.write("---------------------Queue Management Details---------------------");
            Details.write("\n");

            for (int i = 0; i < CustomerLine.length; i++) {
                for (int j = 0; j < CustomerLine[i].length; j++) {
                    if (CustomerLine[i][j] != null) {
                        Details.write(CustomerLine[i][j]);
                        Details.write(" Position :" + "Queue " + (i + 1) + " Number " + (j + 1));
                        Details.write("\n");
                    }

                }
            }

            Details.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Data stored successfully");
    }

    public void ReadFileData() {
        //Method to read data from QueueManagementDetails.txt


        try {

            File customerDetails = new File("QueueManagementDetails.txt");

            Scanner ReadDetails = new Scanner(customerDetails);

            while (ReadDetails.hasNextLine()) {
                String data = ReadDetails.nextLine();
                System.out.println(data);
            }
            ReadDetails.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void ViewBurgerCount() {
        //Method to view burger count
        System.out.println(BurgerStock + " burgers are remaining");
    }

    public void AddBurgers() {
        // checking burger count reach minimum level
        if (BurgerStock == 10) {
            BurgerStock += 40;
            System.out.println("Burgers Added");
        } else {
            System.out.println("The number of Burgers has not reachrd the minimum level");
        }
    }

    public void CalculateTheIncome() {
        int Queue1Income = Queue1BurgerCount * 650;
        int Queue2Income = Queue2BurgerCount * 650;
        int Queue3Income = Queue3BurgerCount * 650;

        System.out.println(" ");
        System.out.println(" Income ");
        System.out.println("");
        System.out.println(" Queue 1 : " + Queue1Income);
        System.out.println(" Queue 2 : " + Queue2Income);
        System.out.println(" Queue 2 : " + Queue3Income);
        System.out.println(" ");
    }
    static void PrintWarningMessage () {
        //Print warning massege when burger count reach 10
        if (BurgerStock == 10) {
            System.out.println("******-WARNING-*****");
            System.out.println("* Low burger stock *");
            System.out.println("********************");
        }
    }
    public void GUI(){
        Application.launch(HelloApplication.class);
    }
}

