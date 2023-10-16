package com.springboot.app.service;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.springboot.app.bean.BestDealListRequestBean;
import com.springboot.app.bean.BestDealListResponseBean;
import com.springboot.app.bean.BottleBean;
import com.springboot.app.entity.Bottle;
import com.springboot.app.repository.BottleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class BottleService {
	
	@Autowired
	private BottleRepository bottleRepository;

	public BestDealListResponseBean getBestDeal(BestDealListRequestBean bestDealListRequestBean) {
		List<Bottle> bootleList = bottleRepository.findBottleWithPriceBetweenMaxAndMinPrice(bestDealListRequestBean.getMaxPrice(),
				bestDealListRequestBean.getMinPrice());
		List<BottleBean> bootleBeanList = Bottle.toBeanList(bootleList);
		Collections.sort(bootleBeanList);
        return new BestDealListResponseBean(bootleBeanList);
	}

}
