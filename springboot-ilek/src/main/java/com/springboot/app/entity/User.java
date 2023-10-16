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
@Table(name = "O_USER")
public class User {

    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "O_USER_ID_GENERATOR",
            sequenceName = "id_o_user_seq")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "O_USER_ID_GENERATOR")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FIRSTNAME")
    private String firstname;
    
    @Column(name = "LASTNAME")
    private String lastname;
    
    @Column(name = "LOGIN_MAIL")
    private String login_mail;

    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "IS_ADMIN")
    private Boolean isAdmin;
    
    @Column(name = "IS_EXPERT")
    private Boolean isExpert;

}
