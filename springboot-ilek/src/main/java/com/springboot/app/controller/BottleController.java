package com.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.bean.BestDealListRequestBean;
import com.springboot.app.bean.BestDealListResponseBean;
import com.springboot.app.service.BottleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/bottle")
@RequiredArgsConstructor
public class BottleController {

	@Autowired
    private BottleService bottleService;

    @GetMapping("/bestDealList")
    public ResponseEntity<BestDealListResponseBean> getBestDealList(@RequestBody BestDealListRequestBean bestDealListRequestBean) {
        //log.info("/{mpId} > GET");
    	return ResponseEntity.ok(bottleService.getBestDeal(bestDealListRequestBean));
    }

}
