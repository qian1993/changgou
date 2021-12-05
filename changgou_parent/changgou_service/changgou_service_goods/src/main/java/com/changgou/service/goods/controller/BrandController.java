package com.changgou.service.goods.controller;

import com.changgou.common.pojo.Result;
import com.changgou.common.pojo.StatusCode;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.goods.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/brand")
@RestController
@Slf4j
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 查询所有品牌
     * @return
     */
    @GetMapping("/findAll")
    public Result findAll() {
        log.info("-----------------BrandController.findAll()-----start--------------");
        List<Brand> brandList = brandService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", brandList);
    }

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        log.info("-----------------BrandController.findById(id)-----start--------------");
        Brand brand = brandService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", brand);
    }

    /**
     * 新增品牌
     * @param brand
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Brand brand) {
        log.info("-----------------BrandController.add(Brand)-----start--------------");
        int i = brandService.add(brand);
        if (i > 0) {
            return new Result(true, StatusCode.OK, "新增成功");
        }
        return new Result(false, StatusCode.ERROR, "新增失败");
    }

    /**
     * 更新品牌
     * @param id
     * @param brand
     * @return
     */
    @PutMapping("/update/{id}")
    public Result update(@PathVariable("id") Integer id, @RequestBody Brand brand) {
        log.info("-----------------BrandController.update(id, Brand)-----start--------------");
        int i = brandService.updateById(id, brand);
        if (i > 0) {
            return new Result(true, StatusCode.OK, "更新成功");
        }
        return new Result(false, StatusCode.ERROR, "更新失败");
    }

    /**
     * 根据id删除品牌
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        log.info("-----------------BrandController.delete(id, Brand)-----start--------------");
        int i = brandService.deleteById(id);
        if (i > 0) {
            return new Result(true, StatusCode.OK, "删除成功");
        }
        return new Result(false, StatusCode.ERROR, "删除失败");
    }

}
