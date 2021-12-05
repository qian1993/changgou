package com.changgou.service.goods.service.impl;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.goods.dao.BrandMapper;
import com.changgou.service.goods.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        log.info("-----------------BrandServiceImpl.findAll()----------------Start-------------");
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        log.info("-----------------BrandServiceImpl.findById(id)----------------Start-------------");
        log.info("" + id);
        return brandMapper.selectByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int add(Brand brand) {
        log.info("-----------------BrandServiceImpl.add(Brand)----------------Start-------------");
        log.info(brand.toString());
        return brandMapper.insert(brand);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateById(Integer id, Brand brand) {
        log.info("-----------------BrandServiceImpl.updateById(id, Brand)----------------Start-------------");
        brand.setId(id);
        return brandMapper.updateByPrimaryKey(brand);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteById(Integer id) {
        log.info("-----------------BrandServiceImpl.deleteById(id)----------------Start-------------");
        return brandMapper.deleteByPrimaryKey(id);
    }
}
