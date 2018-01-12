package net.http.retrofit.bithumb;

import net.http.retrofit.CoinProfile;
import net.http.retrofit.MarketProfile;
import net.json.BithumbTickerPriceBean;
import xianzhe.utils.coin.CoinConstant;
import xianzhe.utils.common.XUtils;

import java.util.ArrayList;
import java.util.List;

public class BithumbMarketProfile extends MarketProfile{
    public BithumbMarketProfile(String name, long timeStamp) {
        super(name, timeStamp);
    }

    public static BithumbMarketProfile generateProfile(BithumbTickerPriceBean bean){
        if (bean == null){
            return null;
        }

        long t = System.currentTimeMillis();
        BithumbMarketProfile profile = new BithumbMarketProfile(CoinConstant.EXCHANGE_NAME_BITHUMB, t);

        //COIN_NAME_BTC
        CoinProfile btcProfile = getCoinProfile(
                CoinConstant.COIN_NAME_BTC, bean.getData().getBTC().getBuy_price(), t, bean);
        //COIN_NAME_XRP
        CoinProfile xrpProfile = getCoinProfile(
                CoinConstant.COIN_NAME_XRP, bean.getData().getXRP().getBuy_price(), t, bean);
        //COIN_NAME_ETH
        CoinProfile ethProfile = getCoinProfile(
                CoinConstant.COIN_NAME_ETH, bean.getData().getETH().getBuy_price(), t, bean);
        //COIN_NAME_BCH
        CoinProfile bchProfile = getCoinProfile(
                CoinConstant.COIN_NAME_BCH, bean.getData().getBCH().getBuy_price(), t, bean);
        //COIN_NAME_LTC
        CoinProfile ltcProfile = getCoinProfile(
                CoinConstant.COIN_NAME_LTC, bean.getData().getLTC().getBuy_price(), t, bean);
        //COIN_NAME_DASH
        CoinProfile dashProfile = getCoinProfile(
                CoinConstant.COIN_NAME_DASH, bean.getData().getDASH().getBuy_price(), t, bean);
        //COIN_NAME_EOS
        CoinProfile eosProfile = getCoinProfile(
                CoinConstant.COIN_NAME_EOS, bean.getData().getEOS().getBuy_price(), t, bean);
        //COIN_NAME_XMR
        CoinProfile xmrProfile = getCoinProfile(
                CoinConstant.COIN_NAME_XMR, bean.getData().getXMR().getBuy_price(), t, bean);
        //COIN_NAME_QTUM
        CoinProfile qtumProfile = getCoinProfile(
                CoinConstant.COIN_NAME_QTUM, bean.getData().getQTUM().getBuy_price(), t, bean);
        //COIN_NAME_BTG
        CoinProfile btgProfile = getCoinProfile(
                CoinConstant.COIN_NAME_BTG, bean.getData().getBTG().getBuy_price(), t, bean);
        //COIN_NAME_ETC
        CoinProfile etcProfile = getCoinProfile(
                CoinConstant.COIN_NAME_ETC, bean.getData().getETC().getBuy_price(), t, bean);
        //COIN_NAME_ZEC
        CoinProfile zecProfile = getCoinProfile(
                CoinConstant.COIN_NAME_ZEC, bean.getData().getZEC().getBuy_price(), t, bean);

        List<CoinProfile> coinProfileList = new ArrayList<>();

        coinProfileList.add(btcProfile);
        coinProfileList.add(xrpProfile);
        coinProfileList.add(ethProfile);
        coinProfileList.add(bchProfile);
        coinProfileList.add(ltcProfile);
        coinProfileList.add(dashProfile);
        coinProfileList.add(eosProfile);
        coinProfileList.add(xmrProfile);
        coinProfileList.add(qtumProfile);
        coinProfileList.add(btgProfile);
        coinProfileList.add(etcProfile);
        coinProfileList.add(zecProfile);

        profile.coinProfileList = coinProfileList;
        return profile;
    }

    public static CoinProfile getCoinProfile(String name, String priceKRW, long time, BithumbTickerPriceBean bean){
        if (name == null || priceKRW == null){
            return null;
        }

        double krw = XUtils.stringToDouble(priceKRW);
        double baseCoinKRW = XUtils.stringToDouble(bean.getData().getETH().getBuy_price());
        double cny = krw / CoinConstant.EXCHANGE_RATIO_CNY_KRW;
        double priceInBaseCoin = getPriceInBaseCoin(krw, baseCoinKRW);
        return new CoinProfile(name, priceInBaseCoin, time);
    }

    public static double getPriceInBaseCoin(double priceKRW, double baseCoinPriceKRW){
        return priceKRW / baseCoinPriceKRW;
    }
}
