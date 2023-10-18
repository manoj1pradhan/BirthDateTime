import java.util.Scanner;

class BirthDateInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int birthYear = getRangedInt(scanner, "Enter the birth year (1950-2015): ", 1950, 2015);
        int birthMonth = getRangedInt(scanner, "Enter the birth month (1-12): ", 1, 12);
        int birthDay = getDayForMonth(scanner, birthMonth);
        int birthHours = getRangedInt(scanner, "Enter the birth hour (1-24): ", 1, 24);
        int birthMinutes = getRangedInt(scanner, "Enter the birth minutes (1-59): ", 1, 59);

        System.out.println("Birth Date: " + birthYear + "-" + birthMonth + "-" + birthDay + " " + birthHours + ":" + birthMinutes);

        scanner.close();
    }

    public static int getRangedInt(Scanner scanner, String prompt, int min, int max) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= min && value <= max) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a value between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }

        return value;
    }

    public static int getDayForMonth(Scanner scanner, int month) {
        int maxDay;
        switch (month) {
            case 2:
                maxDay = 29;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxDay = 30;
                break;
            default:
                maxDay = 31;
                break;
        }

        return getRangedInt(scanner, "Enter the birth day (1-" + maxDay + "): ", 1, maxDay);
    }
}
