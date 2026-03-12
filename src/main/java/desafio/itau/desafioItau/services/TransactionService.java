package desafio.itau.desafioItau.services;

import desafio.itau.desafioItau.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransactionService {

    private Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public void clearTransactions(){
        transactions.clear();
    }

    public DoubleSummaryStatistics getStatistcs(){
        OffsetDateTime now = OffsetDateTime.now();
        return transactions.stream().filter(t -> t.getDateTime().isAfter(now.minusSeconds(60))).mapToDouble(Transaction::getValue).summaryStatistics();
    }
}
