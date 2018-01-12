package calculator;

import java.util.Comparator;

public class TransactionComparator {
    public static class RoundProfitComparator implements Comparator<RoundTransaction>{

        @Override
        public int compare(RoundTransaction o1, RoundTransaction o2) {
            if (o1 == null || o2 == null){
                return 0;
            }

            if (o1.getProfitRatio() > o2.getProfitRatio()){
                return 1;
            } else if (o1.getProfitRatio() == o2.getProfitRatio()){
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static class SingleLeaveProfitComparator implements Comparator<RoundTransaction>{

        @Override
        public int compare(RoundTransaction o1, RoundTransaction o2) {
            if (o1 == null || o2 == null){
                return 0;
            }

            if (o1.getTransactionLeave().getProfitRatio() > o2.getTransactionLeave().getProfitRatio()){
                return 1;
            } else if (o1.getTransactionLeave().getProfitRatio() == o2.getTransactionLeave().getProfitRatio()){
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static class SingleReturnProfitComparator implements Comparator<RoundTransaction> {
        @Override
        public int compare(RoundTransaction o1, RoundTransaction o2) {
            if (o1 == null || o2 == null){
                return 0;
            }

            if (o1.getTransactionReturn().getProfitRatio() > o2.getTransactionReturn().getProfitRatio()){
                return 1;
            } else if (o1.getTransactionReturn().getProfitRatio() == o2.getTransactionReturn().getProfitRatio()){
                return 0;
            } else {
                return -1;
            }
        }
    }
}
