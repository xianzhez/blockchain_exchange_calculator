package net.http.retrofit.binance;

import com.google.gson.Gson;
import net.http.retrofit.ExchangeRetrofit;
import net.http.retrofit.bithumb.BithumbMarketProfile;
import net.json.BinanceTickerPriceBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class BinanceRetrofit extends ExchangeRetrofit {

    Retrofit mRetrofit;
    BinanceService mService;
    public BinanceRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.binance.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = mRetrofit.create(BinanceService.class);

    }

    private void performQueryMarket(){
        Call<List<BinanceTickerPriceBean>> result = mService.getMarket();
        try {
            result.enqueue(new Callback<List<BinanceTickerPriceBean>>() {
                @Override
                public void onResponse(Call<List<BinanceTickerPriceBean>> call, Response<List<BinanceTickerPriceBean>> response) {
                    Gson gson = new Gson();
                    String str = gson.toJson(response.body());
//                    System.out.println("Binance Response: " + str);
                    BinanceMarketProfile marketProfile = BinanceMarketProfile.generateProfile(response.body());
                    if (callback != null){
                        callback.onResultReturnedSuccess(marketProfile);
                    }
                }

                @Override
                public void onFailure(Call<List<BinanceTickerPriceBean>> call, Throwable t) {
                    if (callback != null){
                        callback.onResultReturnedFail();
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void queryMarketAll(QueryResultCallback callback) {
        this.callback = callback;
        performQueryMarket();
    }
}
