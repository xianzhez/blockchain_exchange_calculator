package calculator;

public class ExchangeCoin extends CoinBase{
    protected String exchangeName;
    protected double withdrawFee;
    protected boolean withdrawEnabled;

    public ExchangeCoin(String name, double price, String exchangeName, double withdrawFee) {
        super(name, price);
        this.exchangeName = exchangeName;
        this.withdrawFee = withdrawFee;
        if (withdrawFee <= 0){
            withdrawEnabled = false;
        } else {
            withdrawEnabled = true;
        }
    }

    public double getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(double withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public boolean isWithdrawEnabled() {
        return withdrawEnabled;
    }
}
