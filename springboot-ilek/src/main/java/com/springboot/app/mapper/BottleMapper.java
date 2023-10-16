package com.springboot.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.springboot.app.bean.BottleBean;
import com.springboot.app.entity.Bottle;

@Mapper(componentModel = "spring")
public interface BottleMapper {
	
	Bottle toEntity(BottleBean bottleBean);
	
	BottleBean toBean(Bottle bottle);
	
	List<BottleBean> toBeanList(List<Bottle> bottleList);

}
