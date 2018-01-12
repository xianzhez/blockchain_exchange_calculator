package calculator;

public class SingleTransaction extends Transaction {
    private double inputAmount;
    private double outputAmount;
    private double profitRatio;
    private ExchangeCoin coinInExchangeA;
    private ExchangeCoin coinInExchangeB;

    public SingleTransaction(double inputAmount, ExchangeCoin coinInExchangeA, ExchangeCoin coinInExchangeB) {
        this.inputAmount = inputAmount;
        this.coinInExchangeA = coinInExchangeA;
        this.coinInExchangeB = coinInExchangeB;
        performCalculateProfit();
    }

    private void performCalculateProfit(){
        outputAmount = inputAmount - coinInExchangeA.withdrawFee;
        profitRatio = (outputAmount * coinInExchangeB.getPrice()) / (inputAmount * coinInExchangeA.getPrice());
    }

    public double getInputAmount() {
        return inputAmount;
    }

    public double getOutputAmount() {
        return outputAmount;
    }

    public double getProfitRatio() {
        return profitRatio;
    }

    public ExchangeCoin getCoinInExchangeA() {
        return coinInExchangeA;
    }

    public ExchangeCoin getCoinInExchangeB() {
        return coinInExchangeB;
    }
}
