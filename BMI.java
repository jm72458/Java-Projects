import javax.swing.JOptionPane;

public class BMI {
   public static void main(String[] args){
   double height, weight, bmi, totalBMI = 0, averageBMI;
   int numOfStudents = 0, underweight = 0, ideal = 0, overweight = 0, obese = 0;
   final double MIN_IDEAL = 18.5;
   final int MIN_OVERWEIGHT = 25, MAX_OVERWEIGHT = 30;
   
   do {
      //Getting the student's height and validating it or be told by the user that all the infomration has been inputed
      height = Double.parseDouble(JOptionPane.showInputDialog("Enter the student's height (meters):\n(Enter -1 to stop entering new data)"));
      if (height != -1 && height > 0){
         //Getting the student's weight and validating it
         do {
            weight = Double.parseDouble(JOptionPane.showInputDialog("Enter the student's weight (kilograms):"));
            if (weight <= 0){
               JOptionPane.showMessageDialog(null, "Please enter a valid number for the weight");
            }
         }
         while (weight <= 0);
         numOfStudents += 1;
         //Calculating bmi and keeping track of the different bmi categories
         bmi = (weight)/(height*height);
         totalBMI += bmi;
         if (bmi < MIN_IDEAL){
            underweight += 1;
         }
         else if (bmi >= MIN_IDEAL && bmi < MIN_OVERWEIGHT){
            ideal += 1;
         }
         else if (bmi >= MIN_OVERWEIGHT && bmi < MAX_OVERWEIGHT){
            overweight += 1;
         }
         else {
            obese += 1;
         }
      }
      else if (height != -1 && height <= 0){
         JOptionPane.showMessageDialog(null, "Please enter a valid number for the height");
      }
   }
   while (height != -1);
   
   averageBMI = totalBMI/numOfStudents;
   
   //Displaying the output
   JOptionPane.showMessageDialog(null, "Number of underweight students: " + underweight + "\nNumber of ideal students: " + ideal + "\nNumber of overweight students: " + overweight + "\nNumber of obese students: " + obese + "\nThe BMI average: " + String.format("%.3f", averageBMI));
  
   } 
}
