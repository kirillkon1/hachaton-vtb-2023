package ru.vtb.vtbbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@RequiredArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"phone_number", "email", "password"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "name")
    @NotEmpty
    private String name;
    @Column(name = "surname")
    @NotEmpty
    private String surname;
    @Column(name = "phone_number")
    @NotEmpty
    private String phoneNumber;
    @Column(name = "email")
    @NotEmpty
    private String email;
    @Column(name = "password")
    @NotEmpty
    private String password;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
