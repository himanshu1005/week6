package week6.problem3;

public class ExchangeRateServiceImpl implements ExchangeRateService {
    @Override
    public double getExchangeRate(Currency currency) throws CurrencyNotSupportException {
        if (Currency.GBP == currency) {
            return 100.88;
        } else if (Currency.DOLLAR == currency) {
            return 74.42;
        } else {
            throw new CurrencyNotSupportException("Please contact developer for extension of services");
        }
    }
}
