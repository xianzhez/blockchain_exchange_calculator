package net.http.retrofit.binance;

import net.json.BinanceTickerPriceBean;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface BinanceService {
    @GET("api/v3/ticker/price")
    Call<List<BinanceTickerPriceBean>> getMarket();
}
