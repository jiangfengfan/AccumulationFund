package com.aaa.service;
import com.aaa.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * className:NewsServiceImpl
 * discription:
 * author:zz
 * createTime:2018-11-22 11:05
 */
@Service

public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;
    @Override
    public List<Map> getList() {
        return newsDao.getList();
    }


}
