9.	//Holiday Calendar: Create a program that reads a year from the user and displays a list of major holidays (e.g., New Year's Day, Christmas) for that year using the LocalDate API and predefined holiday data structures.
<String, LocalDate> holidays = new HashMap<>();

        // Add major holidays to the map
        holidays.put("New Year's Day", LocalDate.of(year, 1, 1));
        holidays.put("Valentine's Day", LocalDate.of(year, 2, 14));
        holidays.put("St. Patrick's Day", LocalDate.of(year, 3, 17));
        holidays.put("Easter Sunday", calculateEasterSunday(year));
        holidays.put("Independence Day", LocalDate.of(year, 7, 4));
        holidays.put("Halloween", LocalDate.of(year, 10, 31));
        holidays.put("Thanksgiving Day", calculateThanksgivingDay(year));
        holidays.put("Christmas Day", LocalDate.of(year, 12, 25));

        // Display the list of holidays
        System.out.println("Major holidays for " + year + ":");
        for (Map.Entry<String, LocalDate> entry : holidays.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Method to calculate Easter Sunday using the Meeus Julian algorithm
    public static LocalDate calculateEasterSunday(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l - 7 * m + 114) / 31;
        int day = ((h + l - 7 * m + 114) % 31) + 1;
        return LocalDate.of(year, month, day);
    }

    // Method to calculate Thanksgiving Day (fourth Thursday of November)
    public static LocalDate calculateThanksgivingDay(int year) {
        LocalDate thanksgiving = LocalDate.of(year, 11, 1);
        int dayOfWeek = thanksgiving.getDayOfWeek().getValue(); // 1: Monday, ..., 7: Sunday
        int daysToAdd = (dayOfWeek <= 4) ? (4 - dayOfWeek) : (11 - dayOfWeek + 4);
        return thanksgiving.plusDays(daysToAdd + (3 * 7)); // Add 3 weeks for the fourth Thursday
    }
}