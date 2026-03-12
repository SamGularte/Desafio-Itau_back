package desafio.itau.desafioItau.services;

import desafio.itau.desafioItau.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class.getName());

    private Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void addTransaction(Transaction transaction){
        logger.info("Adding transaction to queue!");

        transactions.add(transaction);

        logger.info("Transaction added to queue");
    }

    public void clearTransactions(){

        int size = transactions.size();
        logger.info("Clearing {} transactions from queue!", size);

        transactions.clear();

        logger.info("Queue Cleared");
    }

    public DoubleSummaryStatistics getStatistics(){
        logger.info("Calculating statistics!");

        OffsetDateTime now = OffsetDateTime.now();
        DoubleSummaryStatistics stats = transactions.stream().filter(t -> t.getDateTime().isAfter(now.minusSeconds(60))).mapToDouble(Transaction::getValue).summaryStatistics();

        logger.info("Statistics calculated!");
        return stats;
    }
}
