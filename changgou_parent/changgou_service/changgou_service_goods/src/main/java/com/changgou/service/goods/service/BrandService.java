package com.changgou.service.goods.service;

import com.changgou.goods.pojo.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有品牌
     * @return
     */
    public List<Brand> findAll();

    /**
     * 根据id查询品牌
     * @return
     */
    public Brand findById(Integer id);

    /**
     * 新增品牌
     * @param brand
     * @return
     */
    public int add(Brand brand);

    /**
     * 根据id更新品牌
     * @param id
     * @param brand
     * @return
     */
    public int updateById(Integer id, Brand brand);

    /**
     * 根据id删除品牌
     * @param id
     * @return
     */
    public int deleteById(Integer id);
}
