package ru.senla.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bank {

    private String numCard;
    private Integer pinCard;
    private Double balance;
    private LocalDateTime transactionTime;
    private Boolean blocking;
}
