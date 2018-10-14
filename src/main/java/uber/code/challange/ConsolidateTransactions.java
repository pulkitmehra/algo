package uber.code.challange;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

public class ConsolidateTransactions {

    @Test
    public void testReduceTransactions(){

        List<Transaction> transactions = Arrays.asList(new Transaction("a", "b", 10),
                new Transaction("b", "a", 5),
                new Transaction("a", "c", 15));

        System.out.println(reduceTransaction(transactions));
    }


    public List<Transaction> reduceTransaction(List<Transaction> transactions) {

        Map<String, List<Transaction>> map = new HashMap<>();

        //O(n)
        for (Transaction transaction : transactions) {
            String key = sortParties(transaction);
            map.computeIfAbsent(key, (v) -> new ArrayList<>()).add(transaction);
        }

        Set<Map.Entry<String, List<Transaction>>> entries = map.entrySet();

        List<Transaction> result = new ArrayList<>();

        //looping the map
        //O(n)
        for (Map.Entry<String, List<Transaction>> entry : entries) {

            Map<String, Double> table = new HashMap<>();

            //lopping the transactions
            //O(k)
            List<Transaction> transactinsPerKey = entry.getValue();

            for (Transaction transaction : transactinsPerKey) {
                table.put(transaction.reciever, table.getOrDefault(transaction.reciever, 0d) + transaction.amount);
            }
            //A->5
            //B->10
            result.add(processTransaction(table, entry.getKey()));

        }
        return result;
    }

    private Transaction processTransaction(Map<String, Double> table, String key) {
        Double value = table.values().stream().reduce((a, b) -> a - b).get();
        if (value < 0) {
            return new Transaction(String.valueOf(key.charAt(0)), String.valueOf(key.charAt(1)), Math.abs(value));
        } else if (value == 0) {
            return null;
        } else {
            return new Transaction(String.valueOf(key.charAt(1)), String.valueOf(key.charAt(0)), Math.abs(value));
        }
    }

    private String sortParties(Transaction transaction) {
        List<String> unorderedList = transaction.toList();
        Collections.sort(unorderedList);
        StringBuilder sb = new StringBuilder();
        for (String s : unorderedList) {
            sb.append(s);
        }
        return sb.toString();
    }


    static class Transaction {
        String sender;
        double amount;
        String reciever;

        public Transaction(String sender, String reciever, double amount) {
            this.sender = sender;
            this.reciever = reciever;
            this.amount = amount;
        }


        public List<String> toList() {
            List<String> list = new ArrayList<>();
            list.add(sender);
            list.add(reciever);
            return list;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getReciever() {
            return reciever;
        }

        public void setReciever(String reciever) {
            this.reciever = reciever;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "sender='" + sender + '\'' +
                    ", amount=" + amount +
                    ", reciever='" + reciever + '\'' +
                    '}';
        }
    }


    static class TransactionKey {
        String sender;
        String reciever;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TransactionKey that = (TransactionKey) o;
            return Objects.equals(sender, that.sender) &&
                    Objects.equals(reciever, that.reciever);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sender, reciever);
        }
    }

}
