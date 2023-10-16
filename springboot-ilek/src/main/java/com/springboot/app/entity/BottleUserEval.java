package com.springboot.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "L_BOTTLE_USER_EVAL")
@IdClass(BottleUserEvalId.class)
public class BottleUserEval {

    @Id
    @ManyToOne
    @JoinColumn(name = "FK_BOTTLE_ID", referencedColumnName = "ID")
    private Bottle bottle;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "FK_USER_ID", referencedColumnName = "ID")
    private User user;

    @Column(name = "NOTE")
    private Integer note;
    
    @Column(name = "COMMENT")
    private String comment;

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}
    
    

}
