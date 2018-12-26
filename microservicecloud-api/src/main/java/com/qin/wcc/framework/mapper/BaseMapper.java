package com.qin.wcc.framework.mapper;

import tk.mybatis.mapper.common.Mapper;

public interface BaseMapper <T> extends Mapper<T>,InsertListMapper<T>,SelectAllToMap<T>,SelectByExampleMapperToStr<T>{
}
