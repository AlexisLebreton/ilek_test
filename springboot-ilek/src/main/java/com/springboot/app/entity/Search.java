package com.springboot.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "O_SEARCH")
public class Search {

    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "O_SEARCH_ID_GENERATOR",
            sequenceName = "id_o_search_seq")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "O_SEARCH_ID_GENERATOR")
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "FK_USER_ID", referencedColumnName = "ID")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "FK_BOTTLE_ID", referencedColumnName = "ID")
    private Bottle bottle;
    
    @Column(name = "MAX_PRICE")
    private Float maxPrice;
    
    @ManyToOne
    @JoinColumn(name = "FK_BOTTLE_TYPE_ID", referencedColumnName = "ID")
    private BottleType bottleType;
    
    @ManyToOne
    @JoinColumn(name = "FK_SITE_ID", referencedColumnName = "ID")
    private Site site;
    
    @Column(name = "IS_ALERT")
    private Boolean isAlert;

}
