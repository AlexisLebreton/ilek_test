package com.springboot.app.bean;

import java.io.Serializable;
import java.util.List;

import com.springboot.app.entity.Bottle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BestDealListResponseBean implements Serializable {
	
	public BestDealListResponseBean(List<BottleBean> bottleList) {
		super();
		this.bottleList = bottleList;
	}

	private static final long serialVersionUID = 1L;
	
	private List<BottleBean> bottleList;
	
}
