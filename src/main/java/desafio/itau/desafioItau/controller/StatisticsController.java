package desafio.itau.desafioItau.controller;

import desafio.itau.desafioItau.dto.StatisticsResponse;
import desafio.itau.desafioItau.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatisticas")
public class StatisticsController {

    private final TransactionService transactionService;

    public StatisticsController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics(@RequestParam(defaultValue = "PT60S") Duration period){
        DoubleSummaryStatistics stats = transactionService.getStatistics(period);
        return  ResponseEntity.ok(new StatisticsResponse(stats));
    }
}
