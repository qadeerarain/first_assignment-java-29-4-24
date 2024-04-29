6.	//Time Zone Conversion: Write a program that reads a date and time (e.g., LocalDateTime) along with the source time zone (e.g., "UTC") from the user. Convert the date and time to a specific target time zone (e.g., "America/Los_Angeles") using the ZonedDateTime class
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter date and time
        System.out.print("Enter date and time (YYYY-MM-DD HH:mm:ss): ");
        String dateTimeStr = scanner.nextLine();

        // Prompt the user to enter source time zone
        System.out.print("Enter source time zone (e.g., UTC): ");
        String sourceTimeZone = scanner.nextLine();

        // Prompt the user to enter target time zone
        System.out.print("Enter target time zone (e.g., America/Los_Angeles): ");
        String targetTimeZone = scanner.nextLine();

        // Parse the input date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);

        // Convert to ZonedDateTime with the source time zone
        ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of(sourceTimeZone));

        // Convert to target time zone
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimeZone));

        // Format the result
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        String output = targetZonedDateTime.format(outputFormatter);

        System.out.println("Converted date and time in " + targetTimeZone + ": " + output);

        scanner.close();
    }
}