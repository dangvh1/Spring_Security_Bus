package com.example.Spring_Security_Bus.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "busline")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Busline implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "Oracle_SEQ", allocationSize = 1, initialValue = 1)
    int id;
    @Column(name = "busline_name", nullable = false)
    String buslineName;

    @Column(name = "distance", nullable = false)
    float distance;

    @Column(name = "stop_number", nullable = false)
    float stopNumber;

}
