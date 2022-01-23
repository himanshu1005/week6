package week6.problem3;

@FunctionalInterface
public interface ExchangeRateService {
    double getExchangeRate(Currency currency) throws CurrencyNotSupportException;
}
