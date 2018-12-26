package com.qin.wcc.framework.service;

import com.qin.wcc.framework.mapper.BaseMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class BaseServiceImpl<T> {

    //spring 泛型注入
    @Autowired
    private BaseMapper<T> mapper;

    /**
     * 通过反射获取子类确定的泛型类 获取Example对象
     */
    public Example getExample() {
        // 1. 获取带泛型的父类类型
        Type type = this.getClass().getGenericSuperclass();

        // 2. 参数化类型
        ParameterizedType pt = (ParameterizedType) type;

        // 3. 获取真实参数数组
        Type[] types = pt.getActualTypeArguments();

        // 4.获取泛型类型
        Class cl = (Class) types[0];

        return new Example(cl);
    }

    public int deleteByPrimaryKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int delete(T t) {
        return mapper.delete(t);
    }

    public int insert(T t) {
        return mapper.insert(t);
    }

    public int insertSelective(T t) {
        return mapper.insertSelective(t);
    }

    public boolean existsWithPrimaryKey(Object key) {
        return mapper.existsWithPrimaryKey(key);
    }

    public List<T> selectAll() {
        return mapper.selectAll();
    }

    public T selectByPrimaryKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public int selectCount(T t) {
        return mapper.selectCount(t);
    }

    public List<T> select(T t) {
        return mapper.select(t);
    }

    public T selectOne(T t) {
        return mapper.selectOne(t);
    }

    public int updateByPrimaryKey(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    public int updateByPrimaryKeySelective(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    public int deleteByExample(Object o) {
        return mapper.deleteByExample(o);
    }

    public List<T> selectByExample(Object o) {
        return mapper.selectByExample(o);
    }

    public int selectCountByExample(Object o) {
        return mapper.selectCountByExample(o);
    }

    public T selectOneByExample(Object o) {
        return mapper.selectOneByExample(o);
    }

    public int updateByExample(T t, Object o) {
        return mapper.updateByExample(t,o);
    }

    public int updateByExampleSelective(T t, Object o) {
        return mapper.updateByExampleSelective(t,o);
    }

    public List<T> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
        return mapper.selectByExampleAndRowBounds(o,rowBounds);
    }

    public List<T> selectByRowBounds(T t, RowBounds rowBounds) {
        return mapper.selectByRowBounds(t,rowBounds);
    }

    public int insertList(List<T> recordList) {
        return mapper.insertList(recordList);
    }

    public List<Map<String, Object>> selectAllToMap() {
        return mapper.selectAllToMap();
    }

    public List<String> selectByExampleToStr(Object example) {
        return mapper.selectByExampleToStr(example);
    }
}
