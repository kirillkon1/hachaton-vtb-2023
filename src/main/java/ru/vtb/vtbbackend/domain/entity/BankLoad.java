package ru.vtb.vtbbackend.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class BankLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    private Double load;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    @JsonIgnore
    private Bank bank;

    public BankLoad() {
    }

    public BankLoad(Double load, LocalDateTime dateTime, Bank bank) {
        this.load = load;
        this.dateTime = dateTime;
        this.bank = bank;
    }
}
