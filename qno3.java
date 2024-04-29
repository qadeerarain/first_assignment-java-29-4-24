3.	//Birthday Calculator: Write a program that prompts the user for their birth date and calculates their current age in years
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.Scanner;

public class BirthdayCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter their birth date
        System.out.println("Enter your birth date (YYYY-MM-DD):");
        String birthDateString = scanner.nextLine();

        // Parse the birth date string into a LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(birthDateString, formatter);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the difference between the current date and the birth date
        Period period = Period.between(birthDate, currentDate);

        // Extract the years from the period
        int ageInYears = period.getYears();

        // Output the user's current age
        System.out.println("Your current age is: " + ageInYears + " years.");

        scanner.close();
    }
}