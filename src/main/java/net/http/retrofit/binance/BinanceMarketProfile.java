package net.http.retrofit.binance;

import net.http.retrofit.CoinProfile;
import net.http.retrofit.MarketProfile;
import net.json.BinanceTickerPriceBean;
import xianzhe.utils.coin.CoinConstant;
import xianzhe.utils.common.XUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinanceMarketProfile extends MarketProfile{
    public static final String BASE_COIN_BTC = "BTC";
    public static final String BASE_COIN_ETH = "ETH";

    private static HashMap<String, CoinProfile> baseCoinProfilesInETH = new HashMap<>();

    public BinanceMarketProfile(String name, long timeStamp) {
        super(name, timeStamp);
    }

    public static BinanceMarketProfile generateProfile(List<BinanceTickerPriceBean> beanList){
        if (beanList == null){
            return null;
        }

        long t = System.currentTimeMillis();
        BinanceMarketProfile marketProfile = new BinanceMarketProfile(CoinConstant.EXCHANGE_NAME_BINANCE, t);

        List<CoinProfile> cpList = new ArrayList<>();
        double btcPriceInETH = 0;
        for (BinanceTickerPriceBean b : beanList){
            String baseCoin = getBaseCoinFromSymbol(b.getSymbol());
            if (baseCoin == null){
                continue;
            }

            if (baseCoin.equalsIgnoreCase("BTC")){
                String coinName = getCoinNameFromSymbol(b.getSymbol());
                double price = XUtils.stringToDouble(b.getPrice());
                if (b.getSymbol().equalsIgnoreCase("ETHBTC")){
                    price = 1 / price;
                    btcPriceInETH = price;
                    coinName = "BTC";
                    CoinProfile cp = getCoinProfile(coinName, price, marketProfile.getTimeStamp());
                    cpList.add(cp);
                }

            } else {
                String coinName = getCoinNameFromSymbol(b.getSymbol());
                double price = XUtils.stringToDouble(b.getPrice());

                CoinProfile cp = getCoinProfile(coinName, price, marketProfile.getTimeStamp());
                cpList.add(cp);
            }


        }

        for (BinanceTickerPriceBean b : beanList){

            String baseCoin = getBaseCoinFromSymbol(b.getSymbol());
            if (baseCoin == null){
                continue;
            }

            if (b.getSymbol().equalsIgnoreCase("BTGBTC")){
                double price = XUtils.stringToDouble(b.getPrice());
                price *= btcPriceInETH;

                String coinName = "BTG";
                CoinProfile cp = getCoinProfile(coinName, price, marketProfile.getTimeStamp());
                cpList.add(cp);

            }
        }

        CoinProfile cp = getCoinProfile("ETH", 1, marketProfile.getTimeStamp());
        cpList.add(cp);

        marketProfile.setCoinProfileList(cpList);

        return marketProfile;
    }

    private static CoinProfile getCoinProfile(String coinName, double price, long time){
        return new CoinProfile(coinName, price, time);
    }

    private static boolean isInBaseCoin(String symbol, String baseCoin){
        if (XUtils.isTextEmpty(symbol) || XUtils.isTextEmpty(baseCoin)){
            return false;
        }

        return symbol.toLowerCase().endsWith(baseCoin.toLowerCase());
    }

    private static String getCoinNameFromSymbol(String symbol){
        if (XUtils.isTextEmpty(symbol)){
            return null;
        }

        String[] baseCoinTable = CoinConstant.BASE_COIN_NAME_TABLE;
        String name = null;
        for (int i = 0; i < baseCoinTable.length; i++){
            if (symbol.endsWith(baseCoinTable[i])){
                name = symbol.substring(0, symbol.indexOf(baseCoinTable[i]));
                return name;
            }
        }

        return null;
    }

    private static String getBaseCoinFromSymbol(String symbol){
        if (XUtils.isTextEmpty(symbol)){
            return null;
        }

        String[] baseCoinTable = CoinConstant.BASE_COIN_NAME_TABLE;
        for (int i = 0; i < baseCoinTable.length; i++){
            if (symbol.endsWith(baseCoinTable[i])){
                return baseCoinTable[i];
            }
        }

        return null;
    }

//    private static double getPriceInEth(double priceInBaseCoin, String coinName, String baseCoinName){
//
//    }
}
