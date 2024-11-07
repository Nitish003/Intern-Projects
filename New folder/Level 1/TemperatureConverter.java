import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().charAt(0);
        double convertedTemperature;
        if (unit == 'C') {
            convertedTemperature = (temperature * 9/5) + 32;
            System.out.println(temperature + " degrees Celsius is equal to " + convertedTemperature + " degrees Fahrenheit.");
        } else if (unit == 'F') {
            convertedTemperature = (temperature - 32) * 5/9;
            System.out.println(temperature + " degrees Fahrenheit is equal to " + convertedTemperature + " degrees Celsius.");
        } else {
            System.out.println("Invalid unit of measurement.");
        }
        scanner.close();
    }
}