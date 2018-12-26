package com.qin.wcc.framework.mapper;

import com.qin.wcc.framework.mapper.impl.BaseExampleProvider;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

@RegisterMapper
public interface SelectByExampleMapperToStr<T> {

    /**
     * 根据Example条件进行查询 返回String的集合类型
     *
     * @param example
     * @return
     */
    @SelectProvider(type = BaseExampleProvider.class, method = "dynamicSQL")
    List<String> selectByExampleToStr(Object example);
}
