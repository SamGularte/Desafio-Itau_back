package desafio.itau.desafioItau.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.OffsetDateTime;

public class TransactionRequest {

    @NotNull
    @Positive(message = "Transaction value must be greater than 0")
    private double value;

    @NotNull
    @PastOrPresent(message = "Transaction date-time cannot be in the future")
    private OffsetDateTime dateTime;

    public double getValue(){
        return value;
    }

    public OffsetDateTime getDateTime(){
        return dateTime;
    }


}
