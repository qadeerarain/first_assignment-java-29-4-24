7.	//Periodic Reminder: Simulate a basic reminder system. Read a date and time for a reminder along with a message from the user. Schedule a task (using libraries like java.util.Timer or a third-party library) to display the reminder message when the specified date and time arrivesimport java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter date and time for the reminder
        System.out.print("Enter date and time for the reminder (YYYY-MM-DD HH:mm:ss): ");
        String dateTimeStr = scanner.nextLine();

        // Prompt the user to enter the reminder message
        System.out.print("Enter reminder message: ");
        String reminderMessage = scanner.nextLine();

        // Parse the input date and time
        Date dateTime = Utils.parseDateTime(dateTimeStr);

        // Schedule the reminder task
        Timer timer = new Timer();
        timer.schedule(new ReminderTask(reminderMessage), dateTime);

        System.out.println("Reminder scheduled for " + dateTimeStr);

        // Close the scanner
        scanner.close();
    }
}

class ReminderTask extends TimerTask {
    private String message;

    public ReminderTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        // Display the reminder message when the time arrives
        System.out.println("Reminder: " + message);
    }
}

class Utils {
    public static Date parseDateTime(String dateTimeStr) {
        try {
            return new Date(java.sql.Timestamp.valueOf(dateTimeStr).getTime());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid date and time format. Please use format YYYY-MM-DD HH:mm:ss");
            System.exit(1);
            return null;
        }
    }
}