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
@Table(name = "O_SITE")
public class Site {

    @Id
    @SequenceGenerator(
    		allocationSize = 1,
    		name = "O_SITE_ID_GENERATOR",
    		sequenceName = "id_o_site_seq")
    @GeneratedValue(
    		strategy = GenerationType.SEQUENCE,
    		generator = "O_SITE_ID_GENERATOR")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;
    
    @Column(name = "ADDRESS")
    private String address;

}
