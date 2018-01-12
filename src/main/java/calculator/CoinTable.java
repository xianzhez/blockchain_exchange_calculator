package calculator;

import net.http.RetrofitUtils;
import net.http.retrofit.CoinProfile;
import net.http.retrofit.ExchangeRetrofit;
import net.http.retrofit.MarketProfile;
import xianzhe.utils.common.XUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoinTable {
    public static final String EXCHANGE_NAME_BINANCE = "binance";
    public static final String EXCHANGE_NAME_BITHUMB = "bithumb";

    String BTC = "BTC";
    String XRP = "XRP";
    String ETH = "ETH";
    String BCH = "BCH";
    String LTC = "LTC";
    String DASH = "DASH";
    String EOS = "EOS";
    String XMR = "XMR";
    String QTUM = "QTUM";
    String BTG = "BTG";
    String ETC = "ETC";
    String ZEC = "ZEC";

    //Binance Bithumb
    double[] btcPrice = new double[]{93133, 136766.92};
    double[] xrpPrice = new double[]{14.4062, 21.308};
    double[] ethPrice = new double[]{7594.54, 11096.60};
    double[] bchPrice = new double[]{15198.77, 22717.37};
    double[] ltcPrice = new double[]{1556.68, 2330.49};
    double[] dashPrice = new double[]{6842.02, 10227.84};
    double[] eosPrice = new double[]{58.5255, 83.4787};
    double[] xmrPrice = new double[]{2707.87, 4127.66};
    double[] qtumPrice = new double[]{334.70, 504.21};
    double[] btgPrice = new double[]{1490.21, 1881.19};
    double[] etcPrice = new double[]{205.96, 308.66};
    double[] zecPrice = new double[]{4248.72, 6167.14};

    double[][] coinPriceTable = new double[][]{
            btcPrice,
            xrpPrice,
            ethPrice,
            bchPrice,
            ltcPrice,
            dashPrice,
            eosPrice,
            xmrPrice,
            qtumPrice,
            btgPrice,
            etcPrice,
            zecPrice,
    };

    String[] coinNameArray = new String[]{
            BTC,
            XRP,
            ETH,
            BCH,
            LTC,
            DASH,
            EOS,
            XMR,
            QTUM,
            BTG,
            ETC,
            ZEC
    };

    double[] binanceWithdrawFeeTable = new double[]{
                0.001, //BTC
                0.25, //XRP
                0.01, //ETH
                0.001, //BCH (CEX)
                0.01, //LTC
                0.002, //DASH
                0.01, //EOS
                0.04, //XMR
                0.01, //QTUM
                0.001, //BTG
                0.01, //ETC
                0.005 //ZEC
    };

    double[] bithumbWithdrawFeeTable = new double[]{//TODO
            0.003, //BTC
            1, //XRP
            0.01, //ETH
            0.005, //BCH
            0.01, //LTC
            0.01, //DASH
            0, //EOS (NULL)
            0.05, //XMR
            0.05, //QTUM
            0, //BTG (NULL)
            0.01, //ETC
            0.001 //ZEC
    };

    ArrayList<Exchange> exchangeList;
    HashMap<String, Exchange> exchangeMap;
    HashMap<String, Double> binanceWithdrawFeeMap;
    HashMap<String, Double> bithumbWithdrawFeeMap;

    private static CoinTable sInstance;

    public static CoinTable getSingleInstance(){
        if (sInstance == null){
            sInstance =  new CoinTable();
        }
        return sInstance;
    }

    private CoinTable() {
        init();
    }

    private void init(){
        initExchangeList();
        initExchangeMap();
        initWithdrawFeeMap();
    }

    private void initExchangeList(){
        exchangeList = new ArrayList<>();
        ArrayList<ExchangeCoin> binanceCoins = new ArrayList<>();
        ArrayList<ExchangeCoin> bithumbCoins = new ArrayList<>();

        Exchange binance = new Exchange(EXCHANGE_NAME_BINANCE, 0.001);
        Exchange bithumb = new Exchange(EXCHANGE_NAME_BITHUMB, 0.0015);

        binance.setWithdrawFeeMap(getWithdrawFeeMap(coinNameArray, binanceWithdrawFeeTable));
        bithumb.setWithdrawFeeMap(getWithdrawFeeMap(coinNameArray, bithumbWithdrawFeeTable));

        for (int i = 0; i < coinPriceTable.length; i++){
            binanceCoins.add(new ExchangeCoin(
                    coinNameArray[i],
                    coinPriceTable[i][0],
                    EXCHANGE_NAME_BINANCE,
                    binance.getWithdrawFeeByCoinName(coinNameArray[i])
            ));

            bithumbCoins.add(new ExchangeCoin(
                    coinNameArray[i],
                    coinPriceTable[i][1],
                    EXCHANGE_NAME_BITHUMB,
                    bithumb.getWithdrawFeeByCoinName(coinNameArray[i])
            ));
        }

        binance.initCoinMap(binanceCoins);
        bithumb.initCoinMap(bithumbCoins);

        exchangeList.add(binance);
        exchangeList.add(bithumb);

    }

    private HashMap<String, Double> getWithdrawFeeMap(String[] nameArray, double[] feeArray){
        HashMap<String, Double> map = new HashMap<>();
        for (int i = 0; i < nameArray.length; i++){
            map.put(nameArray[i], feeArray[i]);
        }

        return map;
    }

    private void initExchangeMap(){
        exchangeMap = new HashMap<>();

        if (exchangeList == null){
            exchangeList = getExchangeList();
        }

        for (Exchange e : exchangeList){
            exchangeMap.put(e.getName(), e);
        }
    }

    private void initWithdrawFeeMap(){
        binanceWithdrawFeeMap = new HashMap<>();
        for (int i = 0; i < binanceWithdrawFeeTable.length; i++){
            binanceWithdrawFeeMap.put(coinNameArray[i].toLowerCase(), binanceWithdrawFeeTable[i]);
        }

        bithumbWithdrawFeeMap = new HashMap<>();
        for (int i = 0; i < bithumbWithdrawFeeTable.length; i++){
            bithumbWithdrawFeeMap.put(coinNameArray[i].toLowerCase(), bithumbWithdrawFeeTable[i]);
        }
    }


    public ArrayList<Exchange> getExchangeList(){
        return exchangeList;
    }



    public HashMap<String, Exchange> getExchangeMap(){
        return exchangeMap;
    }

    public Exchange getExchangeByName(String name){
        if (exchangeMap == null){
            return null;
        }

        return exchangeMap.get(name.toLowerCase());
    }

    public void startSyncExchangeData(final TransactionCalculator calculator, final double inputCNY){
        final RetrofitUtils utils = new RetrofitUtils();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    utils.queryAll(new ExchangeRetrofit.QueryResultCallback(){

                        @Override
                        public void onResultReturnedSuccess(MarketProfile marketProfile) {
                            if (marketProfile == null){
                                return;
                            }

                            updateExchangeMap(marketProfile);

                        }

                        @Override
                        public void onResultReturnedFail() {

                        }
                    });

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "QueryThread").start();



    }

    public void updateExchangeMap(MarketProfile marketProfile){
        Exchange exchange = getExchangeFromMarketProfile(marketProfile);
        if (exchange == null){
            return;
        }

        if (exchangeMap == null){
            exchangeMap = new HashMap<>();
        }

        exchangeMap.put(exchange.getName().toLowerCase(), exchange);
    }

    private Exchange getExchangeFromMarketProfile(MarketProfile marketProfile) {
        if (marketProfile == null || !isValidExchange(marketProfile.getExchangeName())){
            return null;
        }

        String exchangeName = marketProfile.getExchangeName();
        Exchange exchange = new Exchange(exchangeName, getExchangeTransactionFeeRatio(exchangeName));
        List<CoinProfile> coinProfileList = marketProfile.getCoinProfileList();
        if (coinProfileList == null){
            return null;
        }

        HashMap<String, Double> feeMap = getWithdrawFeeMap(exchangeName);

        ArrayList<ExchangeCoin> exchangeCoinList = new ArrayList<>();
        for (CoinProfile p : coinProfileList){
            Double withdrawFee = feeMap.get(p.getCoinName().toLowerCase());
            String name = p.getCoinName();
//            System.out.println(name);
            if (withdrawFee == null){
                continue;
            }
            ExchangeCoin ec = new ExchangeCoin(p.getCoinName(), p.getPrice(), exchangeName, withdrawFee);
            exchangeCoinList.add(ec);
        }

        exchange.initCoinMap(exchangeCoinList);
        return exchange;
    }

    private boolean isValidExchange(String exchangeName){
        if (XUtils.isTextEmpty(exchangeName)){
            return false;
        }

        if (exchangeName.equalsIgnoreCase(EXCHANGE_NAME_BINANCE)
                || exchangeName.equalsIgnoreCase(EXCHANGE_NAME_BITHUMB)){
            return true;
        }

        return false;
    }

    private double getExchangeTransactionFeeRatio(String exchangeName){
        if (XUtils.isTextEmpty(exchangeName)){
            return -1;
        }

        if (exchangeName.equalsIgnoreCase(EXCHANGE_NAME_BINANCE)){
            return 0.001;
        } else if (exchangeName.equalsIgnoreCase(EXCHANGE_NAME_BITHUMB)){
            return 0.0015;
        }

        return -1;
    }

    private HashMap<String, Double> getWithdrawFeeMap(String exchangeName){
        if (exchangeName == null){
            return null;
        }

        if (exchangeName.equalsIgnoreCase(EXCHANGE_NAME_BINANCE)){
            return binanceWithdrawFeeMap;
        } else if (exchangeName.equalsIgnoreCase(EXCHANGE_NAME_BITHUMB)){
            return bithumbWithdrawFeeMap;
        }

        return null;

    }

}
