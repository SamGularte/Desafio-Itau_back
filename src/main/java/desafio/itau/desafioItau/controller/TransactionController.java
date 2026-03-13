package desafio.itau.desafioItau.controller;

import desafio.itau.desafioItau.dto.TransactionRequest;
import desafio.itau.desafioItau.model.Transaction;
import desafio.itau.desafioItau.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request){
        transactionService.addTransaction(new Transaction(request.getValue(), request.getDateTime()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransactions(){
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }

}
