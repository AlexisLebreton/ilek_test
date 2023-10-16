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
@Table(name = "L_BOTTLE_SITE_SELLER")
public class BottleSiteSeller {

    @Id
    @SequenceGenerator(
    		allocationSize = 1,
    		name = "L_BOTTLE_SITE_SELLER_ID_GENERATOR",
    		sequenceName = "id_l_bottle_site_seller_seq")
    @GeneratedValue(
    		strategy = GenerationType.SEQUENCE,
    		generator = "L_BOTTLE_SITE_SELLER_ID_GENERATOR")
    @Column(name = "ID")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "FK_BOTTLE_ID", referencedColumnName = "ID")
    private Bottle bottle;
    
    @ManyToOne
    @JoinColumn(name = "FK_SITE_ID", referencedColumnName = "ID")
    private Site site;
    
    @Column(name = "IS_RUPTURE")
    private Boolean isRupture;

}
