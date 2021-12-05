package com.changgou.service.goods.service.impl;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.goods.dao.BrandMapper;
import com.changgou.service.goods.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Brand> searchByParams(Map map) {
        log.info("-----------------BrandServiceImpl.searchByParams(Map)----------------Start-------------");
        List<Brand> list = null;
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (map != null) {
            // 根据品牌名称查询
            if (map.get("name") != null && !"".equals(map.get("name"))) {
                criteria.andLike("name", "%" + map.get("name") + "%");
            }
            // 根据品牌首字母查询
            if (map.get("letter") != null && !"".equals(map.get("letter"))) {
                criteria.andEqualTo("letter", map.get("letter"));
            }
        }
        list = brandMapper.selectByExample(example);
        return list;
    }

    @Override
    public Page<Brand> findPage(Integer pageNumber, Integer pageSize) {
        log.info("-----------------BrandServiceImpl.findPage(pageNumber, pageSize)----------------Start-------------");
        PageHelper.startPage(pageNumber, pageSize);
        Page<Brand> page = (Page<Brand>) brandMapper.selectAll();
        return page;
    }

    @Override
    public Page<Brand> findPage(Map map, Integer pageNumber, Integer pageSize) {
        log.info("-----------------BrandServiceImpl.findPage(Map, pageNumber, pageSize)----------------Start-------------");
        PageHelper.startPage(pageNumber, pageSize);
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (map != null) {
            // 根据品牌名称查询
            if (map.get("name") != null && !"".equals(map.get("name"))) {
                criteria.andLike("name", "%" + map.get("name") + "%");
            }
            // 根据品牌首字母查询
            if (map.get("letter") != null && !"".equals(map.get("letter"))) {
                criteria.andEqualTo("letter", map.get("letter"));
            }
        }
        Page<Brand> page = (Page<Brand>) brandMapper.selectByExample(example);
        return page;
    }
}
