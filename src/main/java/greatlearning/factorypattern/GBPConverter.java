package greatlearning.factorypattern;

public class GBPConverter extends ConvertorApiImpl {

    @Override
    public double convertToINR(double amount) {
        try {
            amount = amount * exchangeRateService.getExchangeRate(Currency.GBP);
        } catch (CurrencyNotSupportException e) {
            e.printStackTrace();
        }
        return amount;
    }
}
