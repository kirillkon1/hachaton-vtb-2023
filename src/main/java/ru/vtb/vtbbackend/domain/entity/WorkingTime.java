package ru.vtb.vtbbackend.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="open_at")
    private LocalDateTime openAt;

    @Column(name="closed_at")
    private LocalDateTime closedAt;

    @Column(name="day_of_the_week")
    private String dayOfWeek;

}
