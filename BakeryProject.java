/*
Name: Jessica Montoya
Date: 4/26/20
Course/Section: IT 106-204
Assignment: Programming Assignment 8

Description:

In this program, the user will input information on their budget amount and different bid amounts. The user will enter 10
different budget amounts. Once the user has finished entering the information, the program will take the information and
determine which bids will be used to create an average bid, create an average bid, and determine which bids are affordable
with the given budget. A message at the end of the program will display all of this information.
*/

import javax.swing.JOptionPane;
import java.util.Arrays;

public class BakeryProject {
   
   //This method calls all the different methods and holds all the important data to later send it for the report
   public static void main(String[] args) {
      final int differentBids = 10;
      
      double budget = retrieveBudget();
      double[] bids = gatherBids(differentBids);
      double[] averagedBids = bidsInAverage(bids);
      double average = findAverage(averagedBids);
      double[] inBudget = findInBudget(budget, averagedBids);
      
      printReport(budget, bids, averagedBids, average, inBudget);
   }
   
   /*
   Gets the budget from the user and reprompts the user if the user enters an invalid value for the budget amounts.
   
   @return the budget amount
   */
   public static double retrieveBudget(){
      double budgetAmount = 0;
      int success;
      
      do{
         success = 1;
         try{
            budgetAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter your budget:"));
            }
         catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error Wrong Format");
            success = 0;
         }
         if (budgetAmount < 0){
            JOptionPane.showMessageDialog(null, "Invalid budget amount. You will have to enter the budget amount again.");
            success = 0;
         }
      }   
      while(success==0);
      
      return budgetAmount;
   }
   
   /*
   Gets all the bids from the user and reprompts the user if the user enters an invalid value for the bid amount.
   
   @param numOfBids the number of different bids that is going to be entered by the user
   @return an array of all the bids provided by the user
   */
   public static double[] gatherBids(int numOfBids){
      int success;
      double bidAmount = 0;
      double[] gatheredBids = new double[numOfBids];
      
      for (int i = 0; i < gatheredBids.length; i++){
         do{
            success = 1;
            try{
               bidAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter the bid amount:"));
            }
            catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null, "Error Wrong Format");
               success = 0;
            }
            if (bidAmount < 0){
               JOptionPane.showMessageDialog(null, "Invalid bid amount. You will have to enter the bid amount again.");
               success = 0;
            }
         }   
         while(success==0);
         gatheredBids[i] = bidAmount;
      }
      return gatheredBids;
   }
   
   /*
   Finds the bids that are going to be used in average (Getting rid of the highest and lowest bid)
   
   @param bidList the array that contains all the bids (including the highest and lowest bid)
   @return an array of bids that excludes the highest and lowest bid
   */
   public static double[] bidsInAverage(double[] bidList){
      double highestBid = 0, lowestBid = bidList[0];
      double[] includedBids = new double[(bidList.length - 2)];
      int count = 0;
      
      for (int i = 0; i < bidList.length; i++){
         if (bidList[i] > highestBid) {
            highestBid = bidList[i];
            
         }
         if (bidList[i] < lowestBid) {
            lowestBid = bidList[i];
         }
      }
      
      for (int i = 0; i < bidList.length; i++){
         if (bidList[i] != highestBid && bidList[i] != lowestBid){
            includedBids[count] = bidList[i];
            count += 1;
         }
      }
      
      return includedBids;
   }
   
   /*
   Gets the bid average (excluding the highest and lowest bid)
   
   @param averageBidList the array that lists all bids expect for the highest and lowest bids
   @return the average bid (excluded highest and lowest bid from the calculations)
   */
   public static double findAverage(double[] averageBidList){
      double total = 0, average;
      
      for (int i = 0; i < averageBidList.length; i++){
         total += averageBidList[i];
      }
      
      average = total/(averageBidList.length - 2);
      
      return average;
   }
   
   /*
   Finds all the bids the are affordable with the given budget
   
   @param givenBudget is the budget for the bakery given by the user
   @param averageBidList the array that lists all bids expect for the highest and lowest bids
   @return an array of bids that can be purchased with the budget amount
   */
   public static double[] findInBudget(double givenBudget, double[] averageBidList){
      int count = 0;
      
      //Gets the number of bids that are in budget
      for (int i = 0; i < averageBidList.length; i++){
         if (averageBidList[i] <= givenBudget){
            count += 1;
         }
      }
      
      double[] affordableBids = new double[count];
      count = 0;
      
      //Adds the affordable bids into a new array
      for (int i = 0; i < averageBidList.length; i++){
         if (averageBidList[i] <= givenBudget){
            affordableBids[count] = averageBidList[i];
            count += 1;
         }
      }
      
      return affordableBids;
   }
   
   /*
   Displays a message for the final report
   
   @param bakeryBudget is the budget for the bakery given by the user
   @param allBids the array that contains all the bids (including the highest and lowest bid)
   @param averagedBids the array that lists all bids expect for the highest and lowest bids
   @param average the average bids (that excluded the highest and lowest bids from the calculations)
   @param affordableBids the array that lists all the bids that can be purchased with the budget amount
   */
   public static void printReport(double bakeryBudget, double[] allBids, double[] averagedBids, double average, double[] affordableBids){
      String report = "All Bids:\n\n";
      
      //Listing all the bids into the report
      for (int i = 0; i < allBids.length; i++){
         report += ("Bid #" + (i+1) + ": $" + String.format("%.2f", allBids[i]) + "\n");
      }
      
      report+= "\nBids factored into the average:\n\n";
      
      //Listing all the bids that are going to be in the average into the report
      for (int i = 0; i < averagedBids.length; i++){
         report += ("Bid #" + (i+1) + ": $" + String.format("%.2f", averagedBids[i]) + "\n");
      }
      
      //Listing the average into the report
      report += ("\nAverage Bid: $" + String.format("%.2f",average) + "\n");
      
      report += ("Affordable Bids:\n\n");
      
      //Listing the affordable bids into the report
      for (int i = 0; i < affordableBids.length; i++){
         report += ("Bid #" + (i+1) + ": $" + String.format("%.2f", affordableBids[i]) + "\n");
      }
      
      JOptionPane.showMessageDialog(null, report);
   }   
}