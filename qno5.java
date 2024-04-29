5.	//import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EventDurationCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define date-time formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Prompt user to enter the start time of the event
        System.out.println("Enter the start time of the event (yyyy-MM-dd HH:mm):");
        String startTimeString = scanner.nextLine();
        LocalDateTime startTime = LocalDateTime.parse(startTimeString, formatter);

        // Prompt user to enter the end time of the event
        System.out.println("Enter the end time of the event (yyyy-MM-dd HH:mm):");
        String endTimeString = scanner.nextLine();
        LocalDateTime endTime = LocalDateTime.parse(endTimeString, formatter);

        // Calculate the duration between the end time and the start time
        Duration duration = Duration.between(startTime, endTime);

        // Convert duration to hours and minutes
        long hours = duration.toHours();
        long minutes = duration.minusHours(hours).toMinutes();

        // Output the duration of the event in hours and minutes
        System.out.println("Duration of the event: " + hours + " hours and " + minutes + " minutes.");

        scanner.close();
    }
}Duration between Events: Imagine a scenario where you have events scheduled with start and end dates/times. Write a program that takes two LocalDateTime objects representing event start and end times and calculates the duration of the event in hours and minutes.