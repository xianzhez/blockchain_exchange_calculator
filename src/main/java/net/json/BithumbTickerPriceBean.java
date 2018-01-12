package net.json;



public class BithumbTickerPriceBean extends BaseBean{
    /** {
     "status": "0000",
     "data": {
     "BTC": {
     "opening_price": "24243000",
     "closing_price": "22540000",
     "min_price": "21700000",
     "max_price": "24260000",
     "average_price": "22851829.0497",
     "units_traded": "12223.03091226",
     "volume_1day": "12223.03091226",
     "volume_7day": "123684.84606350",
     "buy_price": "22538000",
     "sell_price": "22540000"
     },
     "ETH": {
     "opening_price": "1918600",
     "closing_price": "2110200",
     "min_price": "1730200",
     "max_price": "2167000",
     "average_price": "1936026.7012",
     "units_traded": "332211.47205223687375587",
     "volume_1day": "332211.47205223687375587",
     "volume_7day": "1582644.204123966284969030",
     "buy_price": "2105000",
     "sell_price": "2109900"
     },
     "DASH": {
     "opening_price": "1800200",
     "closing_price": "1724700",
     "min_price": "1610000",
     "max_price": "1845600",
     "average_price": "1741789.4440",
     "units_traded": "22277.64361865",
     "volume_1day": "22277.64361865",
     "volume_7day": "176565.958765840000000000",
     "buy_price": "1717500",
     "sell_price": "1724600"
     },
     "LTC": {
     "opening_price": "416150",
     "closing_price": "392950",
     "min_price": "365050",
     "max_price": "422250",
     "average_price": "395749.5657",
     "units_traded": "206984.1207839",
     "volume_1day": "206984.1207839",
     "volume_7day": "1939455.163771290000000000",
     "buy_price": "390000",
     "sell_price": "392850"
     },
     "ETC": {
     "opening_price": "55360",
     "closing_price": "61300",
     "min_price": "48500",
     "max_price": "62800",
     "average_price": "55648.9457",
     "units_traded": "4424222.7402818196128236",
     "volume_1day": "4424222.7402818196128236",
     "volume_7day": "21699608.194429043332741500",
     "buy_price": "61300",
     "sell_price": "61310"
     },
     "XRP": {
     "opening_price": "3919",
     "closing_price": "3288",
     "min_price": "3200",
     "max_price": "3930",
     "average_price": "3547.4865",
     "units_traded": "483065752.387445",
     "volume_1day": "483065752.387445",
     "volume_7day": "2946420435.873875000000000000",
     "buy_price": "3286",
     "sell_price": "3287"
     },
     "BCH": {
     "opening_price": "3927500",
     "closing_price": "3826500",
     "min_price": "3565500",
     "max_price": "3968500",
     "average_price": "3801218.7430",
     "units_traded": "35805.84416154",
     "volume_1day": "35805.84416154",
     "volume_7day": "439814.205933000000000000",
     "buy_price": "3810000",
     "sell_price": "3810500"
     },
     "XMR": {
     "opening_price": "739900",
     "closing_price": "663100",
     "min_price": "586400",
     "max_price": "758900",
     "average_price": "686465.0719",
     "units_traded": "406903.6737665",
     "volume_1day": "406903.6737665",
     "volume_7day": "1086690.915437350000000000",
     "buy_price": "661400",
     "sell_price": "662800"
     },
     "ZEC": {
     "opening_price": "1137500",
     "closing_price": "1044900",
     "min_price": "981100",
     "max_price": "1143000",
     "average_price": "1059748.0625",
     "units_traded": "53760.24958617",
     "volume_1day": "53760.24958617",
     "volume_7day": "562269.718641020000000000",
     "buy_price": "1043600",
     "sell_price": "1044800"
     },
     "QTUM": {
     "opening_price": "91930",
     "closing_price": "87100",
     "min_price": "80150",
     "max_price": "94100",
     "average_price": "87084.1563",
     "units_traded": "4760680.75223889",
     "volume_1day": "4760680.75223889",
     "volume_7day": "53851215.997656610000000000",
     "buy_price": "87110",
     "sell_price": "87130"
     },
     "BTG": {
     "opening_price": "332900",
     "closing_price": "319100",
     "min_price": "297000",
     "max_price": "337900",
     "average_price": "319905.4807",
     "units_traded": "244395.61556936",
     "volume_1day": "244395.61556936",
     "volume_7day": "1992861.646258690000000000",
     "buy_price": "319100",
     "sell_price": "319200"
     },
     "EOS": {
     "opening_price": "14905",
     "closing_price": "14200",
     "min_price": "13200",
     "max_price": "15063",
     "average_price": "14223.8077",
     "units_traded": "22598164.19172597",
     "volume_1day": "22598164.19172597",
     "volume_7day": "200659426.050959900000000000",
     "buy_price": "14199",
     "sell_price": "14200"
     },
     "date": "1515553433538"
     }
     }*/

    private String status;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * BTC : {"opening_price":"24243000","closing_price":"22540000","min_price":"21700000","max_price":"24260000","average_price":"22851829.0497","units_traded":"12223.03091226","volume_1day":"12223.03091226","volume_7day":"123684.84606350","buy_price":"22538000","sell_price":"22540000"}
         * ETH : {"opening_price":"1918600","closing_price":"2110200","min_price":"1730200","max_price":"2167000","average_price":"1936026.7012","units_traded":"332211.47205223687375587","volume_1day":"332211.47205223687375587","volume_7day":"1582644.204123966284969030","buy_price":"2105000","sell_price":"2109900"}
         * DASH : {"opening_price":"1800200","closing_price":"1724700","min_price":"1610000","max_price":"1845600","average_price":"1741789.4440","units_traded":"22277.64361865","volume_1day":"22277.64361865","volume_7day":"176565.958765840000000000","buy_price":"1717500","sell_price":"1724600"}
         * LTC : {"opening_price":"416150","closing_price":"392950","min_price":"365050","max_price":"422250","average_price":"395749.5657","units_traded":"206984.1207839","volume_1day":"206984.1207839","volume_7day":"1939455.163771290000000000","buy_price":"390000","sell_price":"392850"}
         * ETC : {"opening_price":"55360","closing_price":"61300","min_price":"48500","max_price":"62800","average_price":"55648.9457","units_traded":"4424222.7402818196128236","volume_1day":"4424222.7402818196128236","volume_7day":"21699608.194429043332741500","buy_price":"61300","sell_price":"61310"}
         * XRP : {"opening_price":"3919","closing_price":"3288","min_price":"3200","max_price":"3930","average_price":"3547.4865","units_traded":"483065752.387445","volume_1day":"483065752.387445","volume_7day":"2946420435.873875000000000000","buy_price":"3286","sell_price":"3287"}
         * BCH : {"opening_price":"3927500","closing_price":"3826500","min_price":"3565500","max_price":"3968500","average_price":"3801218.7430","units_traded":"35805.84416154","volume_1day":"35805.84416154","volume_7day":"439814.205933000000000000","buy_price":"3810000","sell_price":"3810500"}
         * XMR : {"opening_price":"739900","closing_price":"663100","min_price":"586400","max_price":"758900","average_price":"686465.0719","units_traded":"406903.6737665","volume_1day":"406903.6737665","volume_7day":"1086690.915437350000000000","buy_price":"661400","sell_price":"662800"}
         * ZEC : {"opening_price":"1137500","closing_price":"1044900","min_price":"981100","max_price":"1143000","average_price":"1059748.0625","units_traded":"53760.24958617","volume_1day":"53760.24958617","volume_7day":"562269.718641020000000000","buy_price":"1043600","sell_price":"1044800"}
         * QTUM : {"opening_price":"91930","closing_price":"87100","min_price":"80150","max_price":"94100","average_price":"87084.1563","units_traded":"4760680.75223889","volume_1day":"4760680.75223889","volume_7day":"53851215.997656610000000000","buy_price":"87110","sell_price":"87130"}
         * BTG : {"opening_price":"332900","closing_price":"319100","min_price":"297000","max_price":"337900","average_price":"319905.4807","units_traded":"244395.61556936","volume_1day":"244395.61556936","volume_7day":"1992861.646258690000000000","buy_price":"319100","sell_price":"319200"}
         * EOS : {"opening_price":"14905","closing_price":"14200","min_price":"13200","max_price":"15063","average_price":"14223.8077","units_traded":"22598164.19172597","volume_1day":"22598164.19172597","volume_7day":"200659426.050959900000000000","buy_price":"14199","sell_price":"14200"}
         * date : 1515553433538
         */

        private BTCBean BTC;
        private ETHBean ETH;
        private DASHBean DASH;
        private LTCBean LTC;
        private ETCBean ETC;
        private XRPBean XRP;
        private BCHBean BCH;
        private XMRBean XMR;
        private ZECBean ZEC;
        private QTUMBean QTUM;
        private BTGBean BTG;
        private EOSBean EOS;
        private String date;

        public BTCBean getBTC() {
            return BTC;
        }

        public void setBTC(BTCBean BTC) {
            this.BTC = BTC;
        }

        public ETHBean getETH() {
            return ETH;
        }

        public void setETH(ETHBean ETH) {
            this.ETH = ETH;
        }

        public DASHBean getDASH() {
            return DASH;
        }

        public void setDASH(DASHBean DASH) {
            this.DASH = DASH;
        }

        public LTCBean getLTC() {
            return LTC;
        }

        public void setLTC(LTCBean LTC) {
            this.LTC = LTC;
        }

        public ETCBean getETC() {
            return ETC;
        }

        public void setETC(ETCBean ETC) {
            this.ETC = ETC;
        }

        public XRPBean getXRP() {
            return XRP;
        }

        public void setXRP(XRPBean XRP) {
            this.XRP = XRP;
        }

        public BCHBean getBCH() {
            return BCH;
        }

        public void setBCH(BCHBean BCH) {
            this.BCH = BCH;
        }

        public XMRBean getXMR() {
            return XMR;
        }

        public void setXMR(XMRBean XMR) {
            this.XMR = XMR;
        }

        public ZECBean getZEC() {
            return ZEC;
        }

        public void setZEC(ZECBean ZEC) {
            this.ZEC = ZEC;
        }

        public QTUMBean getQTUM() {
            return QTUM;
        }

        public void setQTUM(QTUMBean QTUM) {
            this.QTUM = QTUM;
        }

        public BTGBean getBTG() {
            return BTG;
        }

        public void setBTG(BTGBean BTG) {
            this.BTG = BTG;
        }

        public EOSBean getEOS() {
            return EOS;
        }

        public void setEOS(EOSBean EOS) {
            this.EOS = EOS;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public static class BTCBean {
            /**
             * opening_price : 24243000
             * closing_price : 22540000
             * min_price : 21700000
             * max_price : 24260000
             * average_price : 22851829.0497
             * units_traded : 12223.03091226
             * volume_1day : 12223.03091226
             * volume_7day : 123684.84606350
             * buy_price : 22538000
             * sell_price : 22540000
             */

            private String opening_price;
            private String closing_price;
            private String min_price;
            private String max_price;
            private String average_price;
            private String units_traded;
            private String volume_1day;
            private String volume_7day;
            private String buy_price;
            private String sell_price;

            public String getOpening_price() {
                return opening_price;
            }

            public void setOpening_price(String opening_price) {
                this.opening_price = opening_price;
            }

            public String getClosing_price() {
                return closing_price;
            }

            public void setClosing_price(String closing_price) {
                this.closing_price = closing_price;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getAverage_price() {
                return average_price;
            }

            public void setAverage_price(String average_price) {
                this.average_price = average_price;
            }

            public String getUnits_traded() {
                return units_traded;
            }

            public void setUnits_traded(String units_traded) {
                this.units_traded = units_traded;
            }

            public String getVolume_1day() {
                return volume_1day;
            }

            public void setVolume_1day(String volume_1day) {
                this.volume_1day = volume_1day;
            }

            public String getVolume_7day() {
                return volume_7day;
            }

            public void setVolume_7day(String volume_7day) {
                this.volume_7day = volume_7day;
            }

            public String getBuy_price() {
                return buy_price;
            }

            public void setBuy_price(String buy_price) {
                this.buy_price = buy_price;
            }

            public String getSell_price() {
                return sell_price;
            }

            public void setSell_price(String sell_price) {
                this.sell_price = sell_price;
            }
        }

        public static class ETHBean {
            /**
             * opening_price : 1918600
             * closing_price : 2110200
             * min_price : 1730200
             * max_price : 2167000
             * average_price : 1936026.7012
             * units_traded : 332211.47205223687375587
             * volume_1day : 332211.47205223687375587
             * volume_7day : 1582644.204123966284969030
             * buy_price : 2105000
             * sell_price : 2109900
             */

            private String opening_price;
            private String closing_price;
            private String min_price;
            private String max_price;
            private String average_price;
            private String units_traded;
            private String volume_1day;
            private String volume_7day;
            private String buy_price;
            private String sell_price;

            public String getOpening_price() {
                return opening_price;
            }

            public void setOpening_price(String opening_price) {
                this.opening_price = opening_price;
            }

            public String getClosing_price() {
                return closing_price;
            }

            public void setClosing_price(String closing_price) {
                this.closing_price = closing_price;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getAverage_price() {
                return average_price;
            }

            public void setAverage_price(String average_price) {
                this.average_price = average_price;
            }

            public String getUnits_traded() {
                return units_traded;
            }

            public void setUnits_traded(String units_traded) {
                this.units_traded = units_traded;
            }

            public String getVolume_1day() {
                return volume_1day;
            }

            public void setVolume_1day(String volume_1day) {
                this.volume_1day = volume_1day;
            }

            public String getVolume_7day() {
                return volume_7day;
            }

            public void setVolume_7day(String volume_7day) {
                this.volume_7day = volume_7day;
            }

            public String getBuy_price() {
                return buy_price;
            }

            public void setBuy_price(String buy_price) {
                this.buy_price = buy_price;
            }

            public String getSell_price() {
                return sell_price;
            }

            public void setSell_price(String sell_price) {
                this.sell_price = sell_price;
            }
        }

        public static class DASHBean {
            /**
             * opening_price : 1800200
             * closing_price : 1724700
             * min_price : 1610000
             * max_price : 1845600
             * average_price : 1741789.4440
             * units_traded : 22277.64361865
             * volume_1day : 22277.64361865
             * volume_7day : 176565.958765840000000000
             * buy_price : 1717500
             * sell_price : 1724600
             */

            private String opening_price;
            private String closing_price;
            private String min_price;
            private String max_price;
            private String average_price;
            private String units_traded;
            private String volume_1day;
            private String volume_7day;
            private String buy_price;
            private String sell_price;

            public String getOpening_price() {
                return opening_price;
            }

            public void setOpening_price(String opening_price) {
                this.opening_price = opening_price;
            }

            public String getClosing_price() {
                return closing_price;
            }

            public void setClosing_price(String closing_price) {
                this.closing_price = closing_price;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getAverage_price() {
                return average_price;
            }

            public void setAverage_price(String average_price) {
                this.average_price = average_price;
            }

            public String getUnits_traded() {
                return units_traded;
            }

            public void setUnits_traded(String units_traded) {
                this.units_traded = units_traded;
            }

            public String getVolume_1day() {
                return volume_1day;
            }

            public void setVolume_1day(String volume_1day) {
                this.volume_1day = volume_1day;
            }

            public String getVolume_7day() {
                return volume_7day;
            }

            public void setVolume_7day(String volume_7day) {
                this.volume_7day = volume_7day;
            }

            public String getBuy_price() {
                return buy_price;
            }

            public void setBuy_price(String buy_price) {
                this.buy_price = buy_price;
            }

            public String getSell_price() {
                return sell_price;
            }

            public void setSell_price(String sell_price) {
                this.sell_price = sell_price;
            }
        }

        public static class LTCBean {
            /**
             * opening_price : 416150
             * closing_price : 392950
             * min_price : 365050
             * max_price : 422250
             * average_price : 395749.5657
             * units_traded : 206984.1207839
             * volume_1day : 206984.1207839
             * volume_7day : 1939455.163771290000000000
             * buy_price : 390000
             * sell_price : 392850
             */

            private String opening_price;
            private String closing_price;
            private String min_price;
            private String max_price;
            private String average_price;
            private String units_traded;
            private String volume_1day;
            private String volume_7day;
            private String buy_price;
            private String sell_price;

            public String getOpening_price() {
                return opening_price;
            }

            public void setOpening_price(String opening_price) {
                this.opening_price = opening_price;
            }

            public String getClosing_price() {
                return closing_price;
            }

            public void setClosing_price(String closing_price) {
                this.closing_price = closing_price;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getAverage_price() {
                return average_price;
            }

            public void setAverage_price(String average_price) {
                this.average_price = average_price;
            }

            public String getUnits_traded() {
                return units_traded;
            }

            public void setUnits_traded(String units_traded) {
                this.units_traded = units_traded;
            }

            public String getVolume_1day() {
                return volume_1day;
            }

            public void setVolume_1day(String volume_1day) {
                this.volume_1day = volume_1day;
            }

            public String getVolume_7day() {
                return volume_7day;
            }

            public void setVolume_7day(String volume_7day) {
                this.volume_7day = volume_7day;
            }

            public String getBuy_price() {
                return buy_price;
            }

            public void setBuy_price(String buy_price) {
                this.buy_price = buy_price;
            }

            public String getSell_price() {
                return sell_price;
            }

            public void setSell_price(String sell_price) {
                this.sell_price = sell_price;
            }
        }

        public static class ETCBean {
            /**
             * opening_price : 55360
             * closing_price : 61300
             * min_price : 48500
             * max_price : 62800
             * average_price : 55648.9457
             * units_traded : 4424222.7402818196128236
             * volume_1day : 4424222.7402818196128236
             * volume_7day : 21699608.194429043332741500
             * buy_price : 61300
             * sell_price : 61310
             */

            private String opening_price;
            private String closing_price;
            private String min_price;
            private String max_price;
            private String average_price;
            private String units_traded;
            private String volume_1day;
            private String volume_7day;
            private String buy_price;
            private String sell_price;

            public String getOpening_price() {
                return opening_price;
            }

            public void setOpening_price(String opening_price) {
                this.opening_price = opening_price;
            }

            public String getClosing_price() {
                return closing_price;
            }

            public void setClosing_price(String closing_price) {
                this.closing_price = closing_price;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getAverage_price() {
                return average_price;
            }

            public void setAverage_price(String average_price) {
                this.average_price = average_price;
            }

            public String getUnits_traded() {
                return units_traded;
            }

            public void setUnits_traded(String units_traded) {
                this.units_traded = units_traded;
            }

            public String getVolume_1day() {
                return volume_1day;
            }

            public void setVolume_1day(String volume_1day) {
                this.volume_1day = volume_1day;
            }

            public String getVolume_7day() {
                return volume_7day;
            }

            public void setVolume_7day(String volume_7day) {
                this.volume_7day = volume_7day;
            }

            public String getBuy_price() {
                return buy_price;
            }

            public void setBuy_price(String buy_price) {
                this.buy_price = buy_price;
            }

            public String getSell_price() {
                return sell_price;
            }

            public void setSell_price(String sell_price) {
                this.sell_price = sell_price;
            }
        }

        public static class XRPBean {
            /**
             * opening_price : 3919
             * closing_price : 3288
             * min_price : 3200
             * max_price : 3930
             * average_price : 3547.4865
             * units_traded : 483065752.387445
             * volume_1day : 483065752.387445
             * volume_7day : 2946420435.873875000000000000
             * buy_price : 3286
             * sell_price : 3287
             */

            private String opening_price;
            private String closing_price;
            private String min_price;
            private String max_price;
            private String average_price;
            private String units_traded;
            private String volume_1day;
            private String volume_7day;
            private String buy_price;
            private String sell_price;

            public String getOpening_price() {
                return opening_price;
            }

            public void setOpening_price(String opening_price) {
                this.opening_price = opening_price;
            }

            public String getClosing_price() {
                return closing_price;
            }

            public void setClosing_price(String closing_price) {
                this.closing_price = closing_price;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getAverage_price() {
                return average_price;
            }

            public void setAverage_price(String average_price) {
                this.average_price = average_price;
            }

            public String getUnits_traded() {
                return units_traded;
            }

            public void setUnits_traded(String units_traded) {
                this.units_traded = units_traded;
            }

            public String getVolume_1day() {
                return volume_1day;
            }

            public void setVolume_1day(String volume_1day) {
                this.volume_1day = volume_1day;
            }

            public String getVolume_7day() {
                return volume_7day;
            }

            public void setVolume_7day(String volume_7day) {
                this.volume_7day = volume_7day;
            }

            public String getBuy_price() {
                return buy_price;
            }

            public void setBuy_price(String buy_price) {
                this.buy_price = buy_price;
            }

            public String getSell_price() {
                return sell_price;
            }

            public void setSell_price(String sell_price) {
                this.sell_price = sell_price;
            }
        }

        public static class BCHBean {
            /**
             * opening_price : 3927500
             * closing_price : 3826500
             * min_price : 3565500
             * max_price : 3968500
             * average_price : 3801218.7430
             * units_traded : 35805.84416154
             * volume_1day : 35805.84416154
             * volume_7day : 439814.205933000000000000
             * buy_price : 3810000
             * sell_price : 3810500
             */

            private String opening_price;
            private String closing_price;
            private String min_price;
            private String max_price;
            private String average_price;
            private String units_traded;
            private String volume_1day;
            private String volume_7day;
            private String buy_price;
            private String sell_price;

            public String getOpening_price() {
                return opening_price;
            }

            public void setOpening_price(String opening_price) {
                this.opening_price = opening_price;
            }

            public String getClosing_price() {
                return closing_price;
            }

            public void setClosing_price(String closing_price) {
                this.closing_price = closing_price;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getAverage_price() {
                return average_price;
            }

            public void setAverage_price(String average_price) {
                this.average_price = average_price;
            }

            public String getUnits_traded() {
                return units_traded;
            }

            public void setUnits_traded(String units_traded) {
                this.units_traded = units_traded;
            }

            public String getVolume_1day() {
                return volume_1day;
            }

            public void setVolume_1day(String volume_1day) {
                this.volume_1day = volume_1day;
            }

            public String getVolume_7day() {
                return volume_7day;
            }

            public void setVolume_7day(String volume_7day) {
                this.volume_7day = volume_7day;
            }

            public String getBuy_price() {
                return buy_price;
            }

            public void setBuy_price(String buy_price) {
                this.buy_price = buy_price;
            }

            public String getSell_price() {
                return sell_price;
            }

            public void setSell_price(String sell_price) {
                this.sell_price = sell_price;
            }
        }

        public static class XMRBean {
            /**
             * opening_price : 739900
             * closing_price : 663100
             * min_price : 586400
             * max_price : 758900
             * average_price : 686465.0719
             * units_traded : 406903.6737665
             * volume_1day : 406903.6737665
             * volume_7day : 1086690.915437350000000000
             * buy_price : 661400
             * sell_price : 662800
             */

            private String opening_price;
            private String closing_price;
            private String min_price;
            private String max_price;
            private String average_price;
            private String units_traded;
            private String volume_1day;
            private String volume_7day;
            private String buy_price;
            private String sell_price;

            public String getOpening_price() {
                return opening_price;
            }

            public void setOpening_price(String opening_price) {
                this.opening_price = opening_price;
            }

            public String getClosing_price() {
                return closing_price;
            }

            public void setClosing_price(String closing_price) {
                this.closing_price = closing_price;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getAverage_price() {
                return average_price;
            }

            public void setAverage_price(String average_price) {
                this.average_price = average_price;
            }

            public String getUnits_traded() {
                return units_traded;
            }

            public void setUnits_traded(String units_traded) {
                this.units_traded = units_traded;
            }

            public String getVolume_1day() {
                return volume_1day;
            }

            public void setVolume_1day(String volume_1day) {
                this.volume_1day = volume_1day;
            }

            public String getVolume_7day() {
                return volume_7day;
            }

            public void setVolume_7day(String volume_7day) {
                this.volume_7day = volume_7day;
            }

            public String getBuy_price() {
                return buy_price;
            }

            public void setBuy_price(String buy_price) {
                this.buy_price = buy_price;
            }

            public String getSell_price() {
                return sell_price;
            }

            public void setSell_price(String sell_price) {
                this.sell_price = sell_price;
            }
        }

        public static class ZECBean {
            /**
             * opening_price : 1137500
             * closing_price : 1044900
             * min_price : 981100
             * max_price : 1143000
             * average_price : 1059748.0625
             * units_traded : 53760.24958617
             * volume_1day : 53760.24958617
             * volume_7day : 562269.718641020000000000
             * buy_price : 1043600
             * sell_price : 1044800
             */

            private String opening_price;
            private String closing_price;
            private String min_price;
            private String max_price;
            private String average_price;
            private String units_traded;
            private String volume_1day;
            private String volume_7day;
            private String buy_price;
            private String sell_price;

            public String getOpening_price() {
                return opening_price;
            }

            public void setOpening_price(String opening_price) {
                this.opening_price = opening_price;
            }

            public String getClosing_price() {
                return closing_price;
            }

            public void setClosing_price(String closing_price) {
                this.closing_price = closing_price;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getAverage_price() {
                return average_price;
            }

            public void setAverage_price(String average_price) {
                this.average_price = average_price;
            }

            public String getUnits_traded() {
                return units_traded;
            }

            public void setUnits_traded(String units_traded) {
                this.units_traded = units_traded;
            }

            public String getVolume_1day() {
                return volume_1day;
            }

            public void setVolume_1day(String volume_1day) {
                this.volume_1day = volume_1day;
            }

            public String getVolume_7day() {
                return volume_7day;
            }

            public void setVolume_7day(String volume_7day) {
                this.volume_7day = volume_7day;
            }

            public String getBuy_price() {
                return buy_price;
            }

            public void setBuy_price(String buy_price) {
                this.buy_price = buy_price;
            }

            public String getSell_price() {
                return sell_price;
            }

            public void setSell_price(String sell_price) {
                this.sell_price = sell_price;
            }
        }

        public static class QTUMBean {
            /**
             * opening_price : 91930
             * closing_price : 87100
             * min_price : 80150
             * max_price : 94100
             * average_price : 87084.1563
             * units_traded : 4760680.75223889
             * volume_1day : 4760680.75223889
             * volume_7day : 53851215.997656610000000000
             * buy_price : 87110
             * sell_price : 87130
             */

            private String opening_price;
            private String closing_price;
            private String min_price;
            private String max_price;
            private String average_price;
            private String units_traded;
            private String volume_1day;
            private String volume_7day;
            private String buy_price;
            private String sell_price;

            public String getOpening_price() {
                return opening_price;
            }

            public void setOpening_price(String opening_price) {
                this.opening_price = opening_price;
            }

            public String getClosing_price() {
                return closing_price;
            }

            public void setClosing_price(String closing_price) {
                this.closing_price = closing_price;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getAverage_price() {
                return average_price;
            }

            public void setAverage_price(String average_price) {
                this.average_price = average_price;
            }

            public String getUnits_traded() {
                return units_traded;
            }

            public void setUnits_traded(String units_traded) {
                this.units_traded = units_traded;
            }

            public String getVolume_1day() {
                return volume_1day;
            }

            public void setVolume_1day(String volume_1day) {
                this.volume_1day = volume_1day;
            }

            public String getVolume_7day() {
                return volume_7day;
            }

            public void setVolume_7day(String volume_7day) {
                this.volume_7day = volume_7day;
            }

            public String getBuy_price() {
                return buy_price;
            }

            public void setBuy_price(String buy_price) {
                this.buy_price = buy_price;
            }

            public String getSell_price() {
                return sell_price;
            }

            public void setSell_price(String sell_price) {
                this.sell_price = sell_price;
            }
        }

        public static class BTGBean {
            /**
             * opening_price : 332900
             * closing_price : 319100
             * min_price : 297000
             * max_price : 337900
             * average_price : 319905.4807
             * units_traded : 244395.61556936
             * volume_1day : 244395.61556936
             * volume_7day : 1992861.646258690000000000
             * buy_price : 319100
             * sell_price : 319200
             */

            private String opening_price;
            private String closing_price;
            private String min_price;
            private String max_price;
            private String average_price;
            private String units_traded;
            private String volume_1day;
            private String volume_7day;
            private String buy_price;
            private String sell_price;

            public String getOpening_price() {
                return opening_price;
            }

            public void setOpening_price(String opening_price) {
                this.opening_price = opening_price;
            }

            public String getClosing_price() {
                return closing_price;
            }

            public void setClosing_price(String closing_price) {
                this.closing_price = closing_price;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getAverage_price() {
                return average_price;
            }

            public void setAverage_price(String average_price) {
                this.average_price = average_price;
            }

            public String getUnits_traded() {
                return units_traded;
            }

            public void setUnits_traded(String units_traded) {
                this.units_traded = units_traded;
            }

            public String getVolume_1day() {
                return volume_1day;
            }

            public void setVolume_1day(String volume_1day) {
                this.volume_1day = volume_1day;
            }

            public String getVolume_7day() {
                return volume_7day;
            }

            public void setVolume_7day(String volume_7day) {
                this.volume_7day = volume_7day;
            }

            public String getBuy_price() {
                return buy_price;
            }

            public void setBuy_price(String buy_price) {
                this.buy_price = buy_price;
            }

            public String getSell_price() {
                return sell_price;
            }

            public void setSell_price(String sell_price) {
                this.sell_price = sell_price;
            }
        }

        public static class EOSBean {
            /**
             * opening_price : 14905
             * closing_price : 14200
             * min_price : 13200
             * max_price : 15063
             * average_price : 14223.8077
             * units_traded : 22598164.19172597
             * volume_1day : 22598164.19172597
             * volume_7day : 200659426.050959900000000000
             * buy_price : 14199
             * sell_price : 14200
             */

            private String opening_price;
            private String closing_price;
            private String min_price;
            private String max_price;
            private String average_price;
            private String units_traded;
            private String volume_1day;
            private String volume_7day;
            private String buy_price;
            private String sell_price;

            public String getOpening_price() {
                return opening_price;
            }

            public void setOpening_price(String opening_price) {
                this.opening_price = opening_price;
            }

            public String getClosing_price() {
                return closing_price;
            }

            public void setClosing_price(String closing_price) {
                this.closing_price = closing_price;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getAverage_price() {
                return average_price;
            }

            public void setAverage_price(String average_price) {
                this.average_price = average_price;
            }

            public String getUnits_traded() {
                return units_traded;
            }

            public void setUnits_traded(String units_traded) {
                this.units_traded = units_traded;
            }

            public String getVolume_1day() {
                return volume_1day;
            }

            public void setVolume_1day(String volume_1day) {
                this.volume_1day = volume_1day;
            }

            public String getVolume_7day() {
                return volume_7day;
            }

            public void setVolume_7day(String volume_7day) {
                this.volume_7day = volume_7day;
            }

            public String getBuy_price() {
                return buy_price;
            }

            public void setBuy_price(String buy_price) {
                this.buy_price = buy_price;
            }

            public String getSell_price() {
                return sell_price;
            }

            public void setSell_price(String sell_price) {
                this.sell_price = sell_price;
            }
        }
    }
}
