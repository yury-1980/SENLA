package ru.senla.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bank {

    private String cardNumber;
    private Integer cardPin;
    private BigDecimal balance;
    private LocalDateTime transactionTime;
    private Boolean blocking;
}
