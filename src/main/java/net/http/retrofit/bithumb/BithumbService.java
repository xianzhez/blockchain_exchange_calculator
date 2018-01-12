package net.http.retrofit.bithumb;

import net.json.BinanceTickerPriceBean;
import net.json.BithumbTickerPriceBean;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface BithumbService {
    @GET("public/ticker/ALL")
    Call<BithumbTickerPriceBean> getMarket();
}
