package net.http.retrofit;

public abstract class ExchangeRetrofit {
    public interface QueryResultCallback{
        void onResultReturnedSuccess(MarketProfile marketProfile);
        void onResultReturnedFail();
    }

    protected QueryResultCallback callback;


    public abstract void queryMarketAll(QueryResultCallback callback);
}
