package com.example.weiyi.service.Impl;

import com.example.weiyi.dao.TypeDao;
import com.example.weiyi.entity.Type;
import com.example.weiyi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 87248 on 2020-06-01 17:01
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public List<Type> findAll() {
        return typeDao.findAll();
    }

    @Override
    public Type findOne(Long tid) {
        return typeDao.getOne(tid);
    }
}
