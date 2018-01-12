package calculator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class TransactionCalculator {
    private CoinTable coinTable;

    public void performCal(double inputCNY){
        coinTable = CoinTable.getSingleInstance();
        Exchange binance = coinTable.getExchangeByName(CoinTable.EXCHANGE_NAME_BINANCE);
        Exchange bithumb = coinTable.getExchangeByName(CoinTable.EXCHANGE_NAME_BITHUMB);

        if (binance == null || bithumb == null){
            return;
        }

        ArrayList<RoundTransaction> transactionList = CalHelper.getInterExchangeTransactionList(
                inputCNY,
                binance,
                bithumb);


        ArrayList<RoundTransaction> sortedTransactionList = CalHelper.sortRoundTransaction(transactionList);
        ArrayList<RoundTransaction> sortedLeaveTransactionList = CalHelper.sortRoundTransaction(transactionList);
        ArrayList<RoundTransaction> sortedReturnTransactionList = CalHelper.sortRoundTransaction(transactionList);
        RoundTransaction bestTransaction = CalHelper.getBestTransactionFromSortedList(sortedTransactionList);
        RoundTransaction bestReturnTransaction = CalHelper.getBestTransactionFromSortedList(sortedReturnTransactionList);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("=======================================Start=================================================");

        System.out.println("INPUT CNY: "+inputCNY);
        System.out.println("----------------------------------");
        for (RoundTransaction t : sortedTransactionList){
            boolean isEnabled = t.isEnabled();
            double outputCNY = t.getOutputAmount() * t.getCoinBInExchangeX().getPrice();
            String printStr = isEnabled ? "" : "*** ";
            String markA = t.getCoinAInExchangeX().isWithdrawEnabled() ? "" : "*";
            String markB = t.getCoinBInExchangeY().isWithdrawEnabled() ? "" : "*";
            printStr += t.getCoinAInExchangeX().getName() + markA
                    + " " + t.getCoinBInExchangeX().getName() + markB
                    + " " + t.getProfitRatio()
                    + " -- ProfitA: " + t.getTransactionLeave().getProfitRatio()
                    + " -- ProfitB: " + t.getTransactionReturn().getProfitRatio()
                    + " -- OUT CNY: "+outputCNY;
            System.out.println(printStr);
        }

        System.out.println("----------------------------------");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println("Time : "+simpleDateFormat.format(new Date()));

        double outputCNY = bestTransaction.getOutputAmount() * bestTransaction.getCoinBInExchangeX().getPrice();
        String printStr = "BEST TRANSACTION: " + bestTransaction.getCoinAInExchangeX().getName()
                + " " + bestTransaction.getCoinBInExchangeX().getName()
                + " " + bestTransaction.getProfitRatio()
                + " -- ProfitA: " + bestTransaction.getTransactionLeave().getProfitRatio()
                + " -- ProfitB: " + bestTransaction.getTransactionReturn().getProfitRatio()
                + " -- OUT CNY: "+outputCNY;
        System.out.println(printStr);

        System.out.println("BEST RETURN     : " + bestReturnTransaction.getCoinAInExchangeX().getName()
                + " " + bestReturnTransaction.getCoinBInExchangeX().getName()
                + " " + bestReturnTransaction.getProfitRatio()
                + " -- ProfitA: " + bestReturnTransaction.getTransactionLeave().getProfitRatio()
                + " -- ProfitB: " + bestReturnTransaction.getTransactionReturn().getProfitRatio()
                + " -- OUT CNY: "+outputCNY);


        double rounds = bestTransaction.getProfitRatio();
        double inputAmount = inputCNY / bestTransaction.getCoinAInExchangeX().getPrice();

        RoundTransaction r = new RoundTransaction(
                inputAmount,
                bestTransaction.getCoinAInExchangeX(),
                bestTransaction.getCoinAInExchangeY(),
                bestTransaction.getCoinBInExchangeY(),
                bestTransaction.getCoinBInExchangeX()
        );
        double result = rounds;
        for (int i = 0; i < 50; i++){
//            result = result * rounds;
//            if (i == 4 | i == 9 || i == 19 || i == 29 || i == 39 || i == 49){
//                System.out.println((i+1) + " Rounds Profit: "+result);
//            }

            r = new RoundTransaction(
                    new InnerTransaction(r.getOutputAmount(),
                            r.getCoinBInExchangeX(),
                            r.getCoinAInExchangeX())
                            .getOutputAmount(),
                    r.getCoinAInExchangeX(),
                    r.getCoinAInExchangeY(),
                    r.getCoinBInExchangeY(),
                    r.getCoinBInExchangeX()
            );


            if (i == 0 || i == 3 | i == 8 || i == 18 || i == 28 || i == 38 || i == 48){
                double roundOutputCNY = r.getOutputAmount() * r.getCoinBInExchangeX().getPrice();
                double finalRatio = roundOutputCNY / inputCNY;
                System.out.println((i+2) + " Rounds Profit: " + finalRatio);
            }
        }

        System.out.println("=======================================End=================================================");

    }

    public RoundTransaction getBestTransaction(ArrayList<RoundTransaction> roundTransactions){
        if (roundTransactions == null || roundTransactions.size() == 0){
            return null;
        }
        Collections.sort(roundTransactions);
        for (int i = roundTransactions.size() - 1 ; i >= 0; i--){
            RoundTransaction t = roundTransactions.get(i);
            if (t.isEnabled()){
                return t;
            }
        }

        return null;

    }



    public static void main(String[] args) {
        TransactionCalculator calculator = new TransactionCalculator();
        CoinTable.getSingleInstance().startSyncExchangeData(calculator, 10000);
        while(true){
            try {
                Thread.sleep(20 * 1000);
                calculator.performCal(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


