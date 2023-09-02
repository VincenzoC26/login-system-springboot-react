package com.example.login.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(
        name = "customer",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "customer_email_unique", columnNames = "email"
                )
        }
)
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "firstname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstname;

    @Column(
            name = "lastname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastname;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Transient
    private Integer age;

    @Column(
            name = "dob",
            updatable = true
    )
    private LocalDate dob;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}