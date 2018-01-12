package calculator;

import java.util.ArrayList;
import java.util.Collections;

public class CalHelper {
    public static ArrayList<RoundTransaction> getInterExchangeTransactionList(
            double inputCNY, Exchange exchangeX, Exchange exchangeY){

        ArrayList<ExchangeCoin> exchangeYCoinList = exchangeY.getCoinList();
        ArrayList<RoundTransaction> transactionList = new ArrayList<>();

        for (int i = 0; i < exchangeYCoinList.size(); i++){
            ExchangeCoin coinAInExchangeY = exchangeYCoinList.get(i);
            ExchangeCoin coinAInExchangeX = exchangeX.getExchangeCoin(coinAInExchangeY.getName());
            if (coinAInExchangeX == null){
                continue;
            }
            double inputAmount = inputCNY / coinAInExchangeX.getPrice();
            for (int j = 0; j < exchangeYCoinList.size(); j++){
                if (i == j){
                    continue;
                }

                ExchangeCoin coinBInExchangeY = exchangeYCoinList.get(j);
                ExchangeCoin coinBInExchangeX = exchangeX.getExchangeCoin(coinBInExchangeY.getName());
                if (coinBInExchangeX == null){
                    continue;
                }
                transactionList.add(new RoundTransaction(
                        inputAmount,
                        coinAInExchangeX,
                        coinAInExchangeY,
                        coinBInExchangeY,
                        coinBInExchangeX)
                );
            }
        }

        return transactionList;
    }

    public static ArrayList<RoundTransaction> sortRoundTransaction(ArrayList<RoundTransaction> inputList){
        ArrayList<RoundTransaction> output = new ArrayList<>(inputList);
        output.sort(new TransactionComparator.RoundProfitComparator());
        return output;
    }

    public static ArrayList<RoundTransaction> sortRoundTransactionBySingleLeave(ArrayList<RoundTransaction> inputList){
        ArrayList<RoundTransaction> output = new ArrayList<>(inputList);
        output.sort(new TransactionComparator.SingleLeaveProfitComparator());
        return output;
    }

    public static ArrayList<RoundTransaction> sortRoundTransactionBySingleReturn(ArrayList<RoundTransaction> inputList){
        ArrayList<RoundTransaction> output = new ArrayList<>(inputList);
        output.sort(new TransactionComparator.SingleReturnProfitComparator());
        return output;
    }

    public static RoundTransaction getBestTransactionFromSortedList(ArrayList<RoundTransaction> inputList){
        if (inputList == null || inputList.size() == 0){
            return null;
        }

        for (int i = inputList.size() - 1 ; i >= 0; i--){
            RoundTransaction t = inputList.get(i);
            if (t.isEnabled()){
                return t;
            }
        }


        return null;
    }


}
