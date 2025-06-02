package com.mysqlLayers.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "SuperBachhe2")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollno;

    private String name;

    private int mark;
}
