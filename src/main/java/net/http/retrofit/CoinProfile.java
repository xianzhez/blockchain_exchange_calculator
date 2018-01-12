package net.http.retrofit;

public class CoinProfile {
    String coinName;
    double price;
    long timeStamp;

    public CoinProfile(String coinName, double price, long timeStamp) {
        this.coinName = coinName;
        this.price = price;
        this.timeStamp = timeStamp;
    }

    public String getCoinName() {
        return coinName;
    }

    public double getPrice() {
        return price;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
