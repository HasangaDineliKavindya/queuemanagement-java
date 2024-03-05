package com.example.dineli;

import java.util.Arrays;
import java.util.Scanner;

public class Qu_Manegment {
    private static String WaitingList;

    public static void main (String[] args) {

        System.out.println("\n");
        System.out.println("---Foodies Fave Queue Management System.---");
        System.out.println("\n");

        FoodQ myObj = new FoodQ();
        myObj.Queues();

        while (true) {
            System.out.println("Waiting list"+ Arrays.toString(FoodQ.WaitingList));
            System.out.println("Cashier"+Arrays.deepToString(FoodQ.Cashier));

            System.out.println("\n");

            System.out.println("  ");
            System.out.println("                          MENU                              ");
            System.out.println("  ");
            System.out.println("  100 or VFQ: View all Queues.                              ");
            System.out.println("  101 or VEQ: View all Empty Queues.                        ");
            System.out.println("  102 or ACQ: Add customer to a Queue.                      ");
            System.out.println("  103 or RCQ: Remove a customer from a Queue.               ");
            System.out.println("  104 or PCQ: Remove a served customer.                     ");
            System.out.println("  105 or VCS: View Customers Sorted in alphabetical order.  ");
            System.out.println("  106 or SPD: Store Program Data into file.                 ");
            System.out.println("  107 or LPD: Load Program Data from file.                  ");
            System.out.println("  108 or STK: View Remaining burgers Stock.                 ");
            System.out.println("  109 or AFS: Add burgers to Stock.                         ");
            System.out.println("  110 or IFQ: View Income of Each Queue.                    ");
            System.out.println("  112 or GUI: GUI                    ");
            System.out.println("  999 or EXT: Exit the Program.                             ");
            System.out.println("  ");




            System.out.println("\n");

            myObj.PrintWarningMessage();

            Scanner input = new Scanner(System.in);

            System.out.print("Enter what you want to do: ");
            java.lang.String task = input.next().toLowerCase();

            //Enhanced swich case to call all methods
            switch (task) {
                case "100", "VFQ" -> myObj.ViewAllQueues();
                case "101", "VEQ" -> myObj.ViewEmptyQueues();
                case "102", "ACQ" -> myObj.AddCustomer();
                case "103", "RCQ" -> myObj. RemoveCustomer();
                case "104", "PCQ" -> myObj.RemoveServedCustomer();
                case "105", "VCS" -> myObj.ViewCustomers();
                case "106", "SPD" -> myObj.AddDataToFile();
                case "107", "LPD" -> myObj.ReadFileData();
                case "108", "STK" -> myObj.ViewBurgerCount();
                case "109", "AFS" -> myObj.AddBurgers();
                case "110", "IFQ" -> myObj.CalculateTheIncome();
                case "112", "GUI" -> myObj.GUI();
                case "999", "EXT" -> System.exit(0);
                default -> System.out.println("Wrong Input");
            }
        }
    }
}




