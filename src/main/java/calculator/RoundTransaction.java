package calculator;

public class RoundTransaction extends Transaction implements Comparable<RoundTransaction>{
    private double inputAmount;
    private ExchangeCoin coinAInExchangeX;
    private ExchangeCoin coinAInExchangeY;
    private ExchangeCoin coinBInExchangeY;
    private ExchangeCoin coinBInExchangeX;
    private double outputAmount;

    private SingleTransaction transactionLeave;
    private SingleTransaction transactionReturn;

    private double profitRatio;
    private boolean isEnabled;

    public RoundTransaction(double inputAmount,
                            ExchangeCoin coinAInExchangeX, ExchangeCoin coinAInExchangeY,
                            ExchangeCoin coinBInExchangeY, ExchangeCoin coinBInExchangeX) {

        this.inputAmount = inputAmount;
        this.coinAInExchangeX = coinAInExchangeX;
        this.coinAInExchangeY = coinAInExchangeY;
        this.coinBInExchangeY = coinBInExchangeY;
        this.coinBInExchangeX = coinBInExchangeX;
        performCalculateProfit();
    }

    private void performCalculateProfit(){
        transactionLeave = new SingleTransaction(inputAmount, coinAInExchangeX, coinAInExchangeY);
        double amountAInY = transactionLeave.getOutputAmount();
        InnerTransaction innerTransactionInY = new InnerTransaction(amountAInY, coinAInExchangeY, coinBInExchangeY);
        double amountBInY = innerTransactionInY.getOutputAmount();
        transactionReturn =  new SingleTransaction(amountBInY, coinBInExchangeY, coinBInExchangeX);
        outputAmount = transactionReturn.getOutputAmount();

        profitRatio = (outputAmount * coinBInExchangeX.getPrice()) / (inputAmount * coinAInExchangeX.getPrice());
        if (profitRatio < 0){
            System.out.println("");
        }

        isEnabled = coinAInExchangeX.isWithdrawEnabled() && coinBInExchangeY.isWithdrawEnabled();
    }

    public double getInputAmount() {
        return inputAmount;
    }

    public ExchangeCoin getCoinAInExchangeX() {
        return coinAInExchangeX;
    }

    public ExchangeCoin getCoinAInExchangeY() {
        return coinAInExchangeY;
    }

    public ExchangeCoin getCoinBInExchangeY() {
        return coinBInExchangeY;
    }

    public ExchangeCoin getCoinBInExchangeX() {
        return coinBInExchangeX;
    }

    public double getOutputAmount() {
        return outputAmount;
    }

    public SingleTransaction getTransactionLeave() {
        return transactionLeave;
    }

    public SingleTransaction getTransactionReturn() {
        return transactionReturn;
    }

    public double getProfitRatio() {
        return profitRatio;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public int compareTo(RoundTransaction o) {
        if (profitRatio > o.getProfitRatio()){
            return 1;
        } else if (profitRatio == o.getProfitRatio()){
            return 0;
        } else {
            return -1;
        }
    }
}
