package com.springboot.app.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BottleBean implements Serializable, Comparable<BottleBean> {

	private static final long serialVersionUID = 1L;
	
    private Integer id;
    private String name;
    private String description;
    private Float mainEval;
	
    public BottleBean() {
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

	public Float getMainEval() {
		return mainEval;
	}

	public void setMainEval(Float mainEval) {
		this.mainEval = mainEval;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int compareTo(BottleBean comparesto) {
		Float compareage
        = ((BottleBean)comparesto).getMainEval();

		return (int)(compareage-this.getMainEval()*100);
	}

}
