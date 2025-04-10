import java.util.Scanner;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return celsiusToKelvin(fahrenheitToCelsius(fahrenheit));
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return celsiusToFahrenheit(kelvinToCelsius(kelvin));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Temperature Converter");
        System.out.println("Available units: Celsius (C), Fahrenheit (F), Kelvin (K)");
        
        while (true) {
            try {
                System.out.print("Enter the temperature value: ");
                double temp = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                
                System.out.print("Enter the original unit (C/F/K): ");
                String unit = scanner.nextLine().toUpperCase();
                
                if (!unit.equals("C") && !unit.equals("F") && !unit.equals("K")) {
                    System.out.println("Invalid unit. Please enter C, F, or K.");
                    continue;
                }
                
                System.out.println();
                if (unit.equals("C")) {
                    System.out.printf("%.2f°C is equal to:\n", temp);
                    System.out.printf("%.2f°F\n", celsiusToFahrenheit(temp));
                    System.out.printf("%.2f K\n", celsiusToKelvin(temp));
                } else if (unit.equals("F")) {
                    System.out.printf("%.2f°F is equal to:\n", temp);
                    System.out.printf("%.2f°C\n", fahrenheitToCelsius(temp));
                    System.out.printf("%.2f K\n", fahrenheitToKelvin(temp));
                } else if (unit.equals("K")) {
                    System.out.printf("%.2f K is equal to:\n", temp);
                    System.out.printf("%.2f°C\n", kelvinToCelsius(temp));
                    System.out.printf("%.2f°F\n", kelvinToFahrenheit(temp));
                }
                
                System.out.print("\nConvert another temperature? (y/n): ");
                String another = scanner.nextLine().toLowerCase();
                if (!another.equals("y")) {
                    System.out.println("Goodbye!");
                    break;
                }
                
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a numeric temperature value.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        
        scanner.close();
    }
}