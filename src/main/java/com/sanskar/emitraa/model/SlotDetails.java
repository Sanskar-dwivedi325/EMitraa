package com.sanskar.emitraa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        uniqueConstraints = {@UniqueConstraint(columnNames = {"date", "time"})}
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SlotDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cropType;
    private String date;
    private String time;
    private String name;
    private String adhaar;
    private String mobile;
}
