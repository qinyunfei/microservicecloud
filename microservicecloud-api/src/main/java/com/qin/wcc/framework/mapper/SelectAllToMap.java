package com.qin.wcc.framework.mapper;

import java.util.List;
import java.util.Map;

import com.qin.wcc.framework.mapper.impl.BaseExampleProvider;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

@RegisterMapper
public interface SelectAllToMap<T>  {
	
    /**
     * 根据Example条件进行查询 返回String的集合类型
     *
     * @return
     */
    @SelectProvider(type = BaseExampleProvider.class, method = "dynamicSQL")
    List<Map<String,Object>> selectAllToMap();

}
