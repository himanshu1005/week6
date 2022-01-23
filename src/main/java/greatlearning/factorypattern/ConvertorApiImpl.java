package greatlearning.factorypattern;

public abstract class ConvertorApiImpl {
    protected ExchangeRateService exchangeRateService = new ExchangeRateServiceImpl();

    public abstract double convertToINR(double amount);
}
