package com.springboot.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.springboot.app.bean.BottleBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "O_BOTTLE")
public class Bottle {

    @Id
    @SequenceGenerator(
    		allocationSize = 1,
    		name = "O_BOTTLE_ID_GENERATOR",
    		sequenceName = "id_o_bottle_seq")
    @GeneratedValue(
    		strategy = GenerationType.SEQUENCE,
    		generator = "O_BOTTLE_ID_GENERATOR")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "FK_BOTTLE_TYPE_ID", referencedColumnName = "ID")
    private BottleType bottleType;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bottle")
    private List<BottleSiteSeller> bottleSiteSeller;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bottle")
    private List<BottleUserEval> bottleUserEval;
    
    public Bottle(Integer id, String name, String description, BottleType bottleType,
			List<BottleSiteSeller> bottleSiteSeller, List<BottleUserEval> bottleUserEval) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.bottleType = bottleType;
		this.bottleSiteSeller = bottleSiteSeller;
		this.bottleUserEval = bottleUserEval;
	}

	public Bottle() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BottleType getBottleType() {
		return bottleType;
	}

	public void setBottleType(BottleType bottleType) {
		this.bottleType = bottleType;
	}

	public List<BottleSiteSeller> getBottleSiteSeller() {
		return bottleSiteSeller;
	}

	public void setBottleSiteSeller(List<BottleSiteSeller> bottleSiteSeller) {
		this.bottleSiteSeller = bottleSiteSeller;
	}

	public List<BottleUserEval> getBottleUserEval() {
		return bottleUserEval;
	}

	public void setBottleUserEval(List<BottleUserEval> bottleUserEval) {
		this.bottleUserEval = bottleUserEval;
	}

	public BottleBean toBean() {
    	BottleBean bottleBean = new BottleBean();
    	bottleBean.setId(this.getId());
    	bottleBean.setName(this.getName());
    	bottleBean.setDescription(this.getDescription());
    	if (this.getBottleUserEval().size() > 0) {
	    	List<BottleUserEval> bottleUserEvalList = this.getBottleUserEval();
	    	Integer evalSum = 0;
	    	Integer evalNumber = 0;
	    	for (BottleUserEval bottleUserEval : bottleUserEvalList) {
	    		evalSum += bottleUserEval.getNote();
	    		evalNumber++;
	    	}
	    	bottleBean.setMainEval((float)evalSum/evalNumber);
    	}
    	return bottleBean;
    }
	
	public static List<BottleBean> toBeanList(List<Bottle> bottleList) {
		List<BottleBean> bottleBeanList = new ArrayList<BottleBean>();
    	for (Bottle bottle : bottleList) {
    		bottleBeanList.add(bottle.toBean());
    	}
    	return bottleBeanList;
    }

}
