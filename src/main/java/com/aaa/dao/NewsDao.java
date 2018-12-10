package com.aaa.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * className:NewsDao
 * discription:
 * author:zz
 * createTime:2018-11-22 10:51
 */

public interface NewsDao {
    /**
     * 获取新闻列表
     * @return
     */
    @Select(value = "select * from tb_news")
    List<Map> getList();


}
