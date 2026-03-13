package desafio.itau.desafioItau.services;

import desafio.itau.desafioItau.model.Transaction;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    @Test
    void getStatistics() {
        TransactionService service = new TransactionService();

        int numberOfTransactions = 1_000;

        for (int i = 0; i < numberOfTransactions; i++) {
            service.addTransaction(
                    new Transaction(10.0, OffsetDateTime.now().minusSeconds(i % 120))
            );
        }

        long start = System.nanoTime();

        var stats = service.getStatistics(Duration.ofSeconds(60));

        assertNotNull(stats);

        long end = System.nanoTime();

        long executionTimeMs = (end - start) / 1_000_000;

        System.out.println("Execution time for " + numberOfTransactions +
                " transactions: " + executionTimeMs + " ms");
    }
}