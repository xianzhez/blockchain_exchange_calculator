package calculator;

import java.util.ArrayList;
import java.util.HashMap;

public class Exchange {
    private String name;
    private double transactionFeeRatio;

    private HashMap<String, ExchangeCoin> coinMap;
    private ArrayList<ExchangeCoin> coinList;
    private HashMap<String, Double> withdrawFeeMap;

    public Exchange(String name, double transactionFeeRatio) {
        this.name = name;
        this.transactionFeeRatio = transactionFeeRatio;
    }

    public ExchangeCoin getExchangeCoin(String coinName){
        if (coinMap == null){
            return null;
        }

        return coinMap.get(coinName);
    }

    public void initCoinMap(ArrayList<ExchangeCoin> coinList){
        if (coinList == null){
            return;
        }

        if (coinMap == null){
            coinMap = new HashMap<>();
        }else{
            coinMap.clear();
        }

        this.coinList = coinList;

        for (ExchangeCoin c : coinList){
            coinMap.put(c.name, c);
        }
    }

    public HashMap<String, Double> getWithdrawFeeMap() {
        return withdrawFeeMap;
    }

    public ArrayList<ExchangeCoin> getCoinList(){
        return coinList;
    }

    public void setWithdrawFeeMap(HashMap<String, Double> withdrawFeeMap) {
        this.withdrawFeeMap = withdrawFeeMap;
    }

    public double getWithdrawFeeByCoinName(String coinName){
        if (withdrawFeeMap == null){
            return -1;
        }

        Double fee = withdrawFeeMap.get(coinName);

        return fee == null ? -1 : fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTransactionFeeRatio() {
        return transactionFeeRatio;
    }

    public void setTransactionFeeRatio(double transactionFeeRatio) {
        this.transactionFeeRatio = transactionFeeRatio;
    }
}
