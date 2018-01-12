package net.http.retrofit;

import java.util.List;

public abstract class MarketProfile {
    protected String exchangeName;
    protected long timeStamp;
    protected List<CoinProfile> coinProfileList;

    public MarketProfile(String name, long timeStamp) {
        this.exchangeName = name;
        this.timeStamp = timeStamp;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public List<CoinProfile> getCoinProfileList() {
        return coinProfileList;
    }

    public void setCoinProfileList(List<CoinProfile> coinProfileList) {
        this.coinProfileList = coinProfileList;
    }
}
