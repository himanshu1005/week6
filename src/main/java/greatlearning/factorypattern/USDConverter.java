package greatlearning.factorypattern;

public class USDConverter extends ConvertorApiImpl {

    @Override
    public double convertToINR(double amount) {
        try {
            amount = amount * exchangeRateService.getExchangeRate(Currency.DOLLAR);
        } catch (CurrencyNotSupportException e) {
            e.printStackTrace();
        }
        return amount;
    }
}
