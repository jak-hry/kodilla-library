package com.crud.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Copy {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    private Book book;
    private BookStatus bookStatus;
}
