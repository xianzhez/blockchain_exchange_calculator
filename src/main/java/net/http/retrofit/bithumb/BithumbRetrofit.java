package net.http.retrofit.bithumb;

import com.google.gson.Gson;
import net.http.retrofit.ExchangeRetrofit;
import net.json.BithumbTickerPriceBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BithumbRetrofit extends ExchangeRetrofit {
    Retrofit mRetrofit;
    BithumbService mService;
    public BithumbRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.bithumb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = mRetrofit.create(BithumbService.class);

    }

    private void performQueryMarket(){
        Call<BithumbTickerPriceBean> result = mService.getMarket();
        try {
            result.enqueue(new Callback<BithumbTickerPriceBean>() {
                @Override
                public void onResponse(Call<BithumbTickerPriceBean> call, Response<BithumbTickerPriceBean> response) {
                    Gson gson = new Gson();
                    String str = gson.toJson(response.body());
//                    System.out.println("Bithumb Response: " + str);
                    BithumbMarketProfile profile = BithumbMarketProfile.generateProfile(response.body());
                    if (callback != null){
                        callback.onResultReturnedSuccess(profile);
                    }
                }

                @Override
                public void onFailure(Call<BithumbTickerPriceBean> call, Throwable t) {
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
