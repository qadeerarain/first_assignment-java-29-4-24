1.	//Date Difference: Write a program that takes two dates as input from the user (e.g., using Scanner) and calculates the difference between them in days.
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the first date
        System.out.println("Enter the first date (YYYY-MM-DD):");
        String dateString1 = scanner.nextLine();

        // Prompt user to enter the second date
        System.out.println("Enter the second date (YYYY-MM-DD):");
        String dateString2 = scanner.nextLine();

        // Define date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Parse the inputted dates into Date objects
            Date date1 = dateFormat.parse(dateString1);
            Date date2 = dateFormat.parse(dateString2);

            // Calculate the difference between the two dates in milliseconds
            long differenceInMillis = Math.abs(date2.getTime() - date1.getTime());

            // Convert milliseconds to days
            long differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24);

            // Output the result
            System.out.println("Difference between the two dates: " + differenceInDays + " days.");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter dates in YYYY-MM-DD format.");
        }

        scanner.close();
    }
}