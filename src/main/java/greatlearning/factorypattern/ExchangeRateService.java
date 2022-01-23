package greatlearning.factorypattern;

@FunctionalInterface
public interface ExchangeRateService {
    double getExchangeRate(Currency currency) throws CurrencyNotSupportException;
}
