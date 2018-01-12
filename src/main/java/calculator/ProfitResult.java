package calculator;

public class ProfitResult {
    private double result;
    private Exchange coinA;
    private Exchange coinB;
    private double profitA;
    private double profitB;

    public ProfitResult(double result, Exchange coinA, Exchange coinB) {
        this.result = result;
        this.coinA = coinA;
        this.coinB = coinB;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Exchange getCoinA() {
        return coinA;
    }

    public void setCoinA(Exchange coinA) {
        this.coinA = coinA;
    }

    public Exchange getCoinB() {
        return coinB;
    }

    public void setCoinB(Exchange coinB) {
        this.coinB = coinB;
    }

    public double getProfitA() {
        return profitA;
    }

    public void setProfitA(double profitA) {
        this.profitA = profitA;
    }

    public double getProfitB() {
        return profitB;
    }

    public void setProfitB(double profitB) {
        this.profitB = profitB;
    }
}
