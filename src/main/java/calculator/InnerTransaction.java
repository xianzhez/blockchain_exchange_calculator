package calculator;

public class InnerTransaction extends Transaction{
    private double inputAmount;
    private ExchangeCoin coinA;
    private ExchangeCoin coinB;
    private double outputAmount;
    private double profitRatio;

    public InnerTransaction(double inputAmount, ExchangeCoin coinA, ExchangeCoin coinB) {
        this.inputAmount = inputAmount;
        this.coinA = coinA;
        this.coinB = coinB;
        performCalculation();
    }

    private void performCalculation(){
        CoinTable coinTable = CoinTable.getSingleInstance();
        Exchange exchange = coinTable.getExchangeByName(coinA.getExchangeName());

        profitRatio = 1 - exchange.getTransactionFeeRatio();

        double netInput = inputAmount * profitRatio;
        outputAmount = netInput * coinA.getPrice() / coinB.getPrice();
    }

    public double getInputAmount() {
        return inputAmount;
    }

    public ExchangeCoin getCoinA() {
        return coinA;
    }

    public ExchangeCoin getCoinB() {
        return coinB;
    }

    public double getOutputAmount() {
        return outputAmount;
    }

    public double getProfitRatio() {
        return profitRatio;
    }
}
