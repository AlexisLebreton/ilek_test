package com.springboot.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "O_BOTTLE_TYPE")
public class BottleType {

    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "O_BOTTLE_TYPE_ID_GENERATOR",
            sequenceName = "id_o_bottle_type_seq")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "O_BOTTLE_TYPE_ID_GENERATOR")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;
    
    @Column(name = "DESCRIPTION")
    private String description;

}
