package desafio.itau.desafioItau.model;

import java.time.OffsetDateTime;

public class Transaction {

    private double value;
    private OffsetDateTime dateTime;

    public Transaction(final double value, final OffsetDateTime dateTime) {
        this.value = value;
        this.dateTime = dateTime;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public double getValue() {
        return value;
    }
}
