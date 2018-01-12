package net.http;

import net.http.retrofit.ExchangeRetrofit;
import net.http.retrofit.MarketProfile;
import net.http.retrofit.binance.BinanceRetrofit;
import net.http.retrofit.bithumb.BithumbRetrofit;

public class RetrofitUtils {
    private ExchangeRetrofit.QueryResultCallback callback;

    public void queryAll(ExchangeRetrofit.QueryResultCallback callback){
        this.callback = callback;
        BithumbRetrofit bithumbRetrofit = new BithumbRetrofit();
        BinanceRetrofit binanceRetrofit = new BinanceRetrofit();
        bithumbRetrofit.queryMarketAll(callback);
        binanceRetrofit.queryMarketAll(callback);
    }
}
