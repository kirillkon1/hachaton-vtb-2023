package ru.vtb.vtbbackend.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OpenHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    @Column(name="open_at")
    private String openAt;

    @Column(name="closed_at")
    private String closedAt;

    @Column(name="day_of_the_week")
    private String dayOfWeek;

}
