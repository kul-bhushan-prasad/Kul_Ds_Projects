package com.test.mojo.testproject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ATM {

        Integer denomList[] = new Integer[]{20,10,5,1};
        private static HashMap fundMap = new HashMap<Integer,Integer>();

        /** Deposits denominations and respective counts
         * @param count
         * @param denominations
         */
        public synchronized void deposit(int count,int denominations) {
                //System.out.println("");
                //System.out.printf("Deposit : %ss: %s",denominations,count);
                if(count<0){
                        System.out.println("Incorrect deposit amount");
                }
                if(count==0){
                        System.out.println("Deposit amount cannot be zero");
                }
                if(fundMap.containsKey(denominations)){
                        int denom = (int) fundMap.get(denominations);
                        fundMap.remove(denominations);
                        fundMap.put(denominations,denom+count);
                }else{
                        fundMap.put(denominations,count);
                }
        }


        /** Withdraws the amt
         * @param amt
         * @return
         */
        public synchronized Map withdraw(int amt) {
                HashMap returnedMap = new HashMap<Integer,Integer>();
                if(amt <=0 || amt > getTotalAmount()){
                      System.out.println("Incorrect or insufficient funds");
                      return returnedMap;
                }
                Iterator iter = fundMap.keySet().iterator();
                        int i =0;
                        while(amt > 0 ){
                                int denomination =  denomList[i];
                                int noOfNotes = amt< denomination ? 0 : amt/denomination;
                                returnedMap.put(denomination, noOfNotes);
                                amt = amt - (denomination * noOfNotes);
                                System.out.println("Dispensed: "+denomination+"'s="+noOfNotes);
                                reduceBalance(denomination, noOfNotes);
                                i++;
                        }
                return returnedMap;
        }

        /** Reduce the Balance
         * @param denomination
         * @param noToReduce
         */
        private synchronized void reduceBalance(int denomination, int noToReduce){
                int amt = (int) fundMap.get(denomination);
                fundMap.remove(denomination);
                fundMap.put(denomination, amt-noToReduce);
        }

        /**
         * @return Total Amount
         */
        public synchronized int getTotalAmount() {
                int amount = 0;
                Iterator iterator = fundMap.keySet().iterator();
                while(iterator.hasNext()){
                        int denom = (int) iterator.next();
                        int count = (int) fundMap.get(denom);
                        amount+=denom*count;
                }
                return amount;
         }

        /** Print Total Amount
         * @return Total Amount
         */
        public synchronized int printAmount() {
                int amount = 0;
                Iterator iterator = fundMap.keySet().iterator();
                while(iterator.hasNext()){
                        int denom = (int) iterator.next();
                        int count = (int) fundMap.get(denom);
                        System.out.println("Balance: "+denom+"s="+count);
                        amount+=(denom*count);
                }
                System.out.println("Total="+amount);
                return amount;
        }

}
