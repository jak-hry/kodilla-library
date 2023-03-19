package com.crud.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @OneToOne
    private Copy copy;
    @OneToOne
    private Book book;
    private LocalDate loanDate;
    private LocalDate returnDate;
}
