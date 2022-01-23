package week6.problem3;

public abstract class ConvertorApiImpl {
    protected ExchangeRateService exchangeRateService = new ExchangeRateServiceImpl();

    public abstract double convertToINR(double amount);
}
