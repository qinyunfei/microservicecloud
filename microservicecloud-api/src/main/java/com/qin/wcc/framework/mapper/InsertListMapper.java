package com.qin.wcc.framework.mapper;

import com.qin.wcc.framework.mapper.impl.BaseExampleProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

@RegisterMapper
public interface InsertListMapper<T> {
    /**
     * 批量插入，支持数据库自增字段，支持回写
     *
     * @param recordList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = BaseExampleProvider.class, method = "dynamicSQL")
    int insertList(List<T> recordList);
}
