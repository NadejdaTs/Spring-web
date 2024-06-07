package FastForex;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Java conversions.json ");
        String input = scanner.nextLine();

        while(!input.toUpperCase().equals("END")){
            LocalDate test = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println(test);

            boolean isValidAmount = false;
            while(!isValidAmount){
                String amountInString = scanner.nextLine();

                String[] lengthAfterDecimalPoint = amountInString.split("\\.");
                if(lengthAfterDecimalPoint[1].length() <= 2){
                    isValidAmount = true;
                }
                if(!isValidAmount) {
                    System.out.println("Please enter a valid amount");
                }
            }

            boolean isValidBaseCurrency = false;
            while(!isValidBaseCurrency){
                String baseCurrency = scanner.nextLine();
                isValidBaseCurrency = checkValidityOfCurrency(baseCurrency);
            }

            boolean isValidTargetCurrency = false;
            while(!isValidTargetCurrency){
                String targetCurrency = scanner.nextLine();
                isValidTargetCurrency = checkValidityOfCurrency(targetCurrency);
            }
            System.out.println("result");

            input = scanner.nextLine();
        }
    }

    private static boolean checkValidityOfCurrency(String currency) {
        Set<Currency> currencySet = Currency.getAvailableCurrencies();

        if(!currencySet.contains(currency.toUpperCase())){
            System.out.println("Please enter a valid currency code");
        }
        return true;
    }
}
