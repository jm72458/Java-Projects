/*
Jessica Montoya
2/12/20
IT 106-204
Assignment 2
In this program, the user will input information for a single employee. This information the user will input on the employee is the employee's name, years of service, and work rating. Once the user
has finished entering the information, the program will take the information and determine the bonus amount an employee will recieve. A message at the end of the program will state whether an employee
is eligible for a bonus and the amount they are recieving as a bonus.
*/
import javax.swing.JOptionPane;

public class EmployeeBonuses{
   public static void main(String[]args){
      boolean bonusEligibility = false;
      double bonusAmount = 0;
      String employeeName = JOptionPane.showInputDialog(null, "Enter employee's name:");
      //Validating the employee's name to make sure the user entered a name for the employee
      if (employeeName.equals("")){
         JOptionPane.showMessageDialog(null,"Invaild employee name. Please enter an employee name. To try again, relaunch the program.");
      }
      else {
         int yearsOfService = Integer.parseInt(JOptionPane.showInputDialog(null, "Number of years employee has worked:"));
         //Validating the variable yearsOfService to make sure it is not a negative number
         if (yearsOfService >= 0){
            String employeeRating = JOptionPane.showInputDialog(null, "Enter employee's rating:\n(Use “Below Average”, “Average”, “Above Average”, or “Outstanding”)");
            //Validating the variable employeeRating to make sure the user enters a rating for an employee
            switch (employeeRating.toLowerCase()){
               case "below average":
               case "average":
               case "above average":
               case "outstanding": 
                  //Determining an employee's eligibility for a bonus
                  if (yearsOfService >= 2){
                     if (employeeRating.equalsIgnoreCase("Below Average")){
                        bonusEligibility = false;
                     }
                     else{
                        bonusEligibility = true;
                     }
                  }
                  else{
                     bonusEligibility = false;
                  }
                  //Calculating the bonus amount for employees that are eligible for a bonus
                  if (bonusEligibility == true){
                     if (yearsOfService >= 20){
                        bonusAmount = (yearsOfService * 100) * 2;
                     }
                     else{
                        bonusAmount = (yearsOfService * 100);
                     }
                     //Display message for employees that are eligible for a bonus
                     JOptionPane.showMessageDialog(null, ("Employee: " + employeeName + "\nYears of Service: " + yearsOfService + "\nEmployee Rating: " + employeeRating + "\nEligible for a bonus: Yes\nBonus Amount: $" + String.format("%.2f", bonusAmount)));
                  }
                  else{
                     //Display message for employees that are not eligible for a bonus
                     JOptionPane.showMessageDialog(null, ("Employee: " + employeeName + "\nYears of Service: " + yearsOfService + "\nEmployee Rating: " + employeeRating + "\nEligible for a bonus: No"));
                  }
               break;
            default: JOptionPane.showMessageDialog(null,"Invaild employee rating. Please rate an employee as “Below Average”, “Average”, “Above Average”, or “Outstanding”. To try again, relaunch the program.");
            }
         }
         else{
            JOptionPane.showMessageDialog(null,"Invaild number. Please enter a value greater than 0. To try again, relaunch the program.");
         }
      }   
   }
}
