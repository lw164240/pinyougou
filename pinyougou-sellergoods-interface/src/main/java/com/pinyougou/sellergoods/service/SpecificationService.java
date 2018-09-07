package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojogroup.Specification;
import entity.PageResult;

import java.util.List;

/**
 * Created by 阿威 on 2018/9/5.
 */
public interface SpecificationService {
    List<TbSpecification> findAll();


    PageResult findPage(int page, int rows);

    /**
     * 批量删除
     * @param ids
     */
    void delete(Long [] ids);

    /**
     * 分页
     * @param pageNum 当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    PageResult findPage(TbSpecification specification, int pageNum,int pageSize);

    /**
     * 增加
     */
     void add(Specification specification);

    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
     Specification findOne(Long id);

    /**
     * 修改
     */
     void update(Specification specification);

}
