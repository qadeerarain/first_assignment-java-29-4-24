2.	//Time Conversion: Write a program that reads a time in 24-hour format (e.g., "14:23") from the user and converts it to 12-hour format (e.g., "2:23 PM").
import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the time in 24-hour format
        System.out.println("Enter the time in 24-hour format (HH:mm):");
        String time24 = scanner.nextLine();

        // Split the input into hours and minutes
        String[] timeParts = time24.split(":");

        // Convert hours and minutes to integers
        int hours24 = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);

        // Convert hours to 12-hour format and determine AM or PM
        String period;
        if (hours24 >= 12) {
            period = "PM";
            if (hours24 > 12) {
                hours24 -= 12;
            }
        } else {
            period = "AM";
            if (hours24 == 0) {
                hours24 = 12;
            }
        }

        // Concatenate the converted time
        String time12 = String.format("%d:%02d %s", hours24, minutes, period);

        // Output the result
        System.out.println("Time in 12-hour format: " + time12);

        scanner.close();
    }
}