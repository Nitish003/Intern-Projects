import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");
        System.out.println("------------------");

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the base currency (e.g. USD, INR, EUR): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (e.g. USD, INR, EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        double convertedAmount = convertCurrency(amount, exchangeRate);

        System.out.printf("%.2f %s is equal to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
        scanner.close();
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.exchangerate-api.com/v4/latest/" + baseCurrency))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();
        String exchangeRateString = responseBody.split("\"" + targetCurrency + "\":")[1].split(",")[0];
        return Double.parseDouble(exchangeRateString);
    }

    private static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}