import javax.swing.JOptionPane;
import java.util.Arrays;

public class HotelRooms {
   public static void main(String[] args){
      final int totalRooms = 39, differentTypes = 4;
      int[] rooms = new int[differentTypes];
      String roomType, report = "";
      int roomCount = 0;
      double total = 0, averageRevenue;
      
      //Prompting for the number of rooms that are going to be reserved
      do {
         roomType = JOptionPane.showInputDialog("Enter the room type:\n(Type END to finish)");
         
         if (roomCount < totalRooms){
            switch (roomType.toLowerCase()) {
               case "single": rooms[0] += 1; roomCount += 1; break;
               case "single deluxe": rooms[1] += 1; roomCount += 1; break;
               case "double": rooms[2] += 1; roomCount += 1; break;
               case "double deluxe": rooms[3] += 1; roomCount += 1; break;
               case "end": break;
               default: JOptionPane.showMessageDialog(null, "Invalid room type");
            }
         }
         else {
            JOptionPane.showMessageDialog(null, "All " + totalRooms + " rooms have already been reserved. Cannot reserve another room.");
         }
      }
      while (!roomType.equals("end"));
      
      //Calculating the total price to reserve all the rooms
      total += (rooms[0] * 79.95);
      total += (rooms[1] * 99.95);
      total += (rooms[2] * 149.95);
      total += (rooms[3] * 179.95);
      
      //Calculating average
      averageRevenue = total/roomCount;
      
      //Creating the report
      report += "Single Room: $79.95\nSingle Deluxe Room: $99.95\nDouble Room: $149.95\nDouble Deluxe: $179.95\n";
      report += "\nNumber of Single rooms needed: " + rooms[0];
      report += "\nNumber of Single Deluxe rooms needed: " + rooms[1];
      report += "\nNumber of Double rooms needed: " + rooms[2];
      report += "\nNumber of Double Deluxe rooms needed: " + rooms[3];
      report += "\n\nTotal Revenue: $" + String.format("%.2f", total);
      report += "\n\nAverage revenue from rooms: $" + String.format("%.2f", averageRevenue);
      
      //Displaying the results
      JOptionPane.showMessageDialog(null, report);
   }
}
