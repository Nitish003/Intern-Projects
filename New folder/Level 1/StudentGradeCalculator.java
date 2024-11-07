import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of grades to be entered: ");
        int numGrades = scanner.nextInt();
        double[] grades = new double[numGrades];
        double total = 0;

        System.out.println("Enter the grades:");
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            total += grades[i];
        }

        double average = total / numGrades;
        System.out.println("Average grade: " + average);
        scanner.close();
    }
}