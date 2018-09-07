package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbTypeTemplate;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * Created by 阿威 on 2018/9/6.
 */
public interface TypeTemplateService {

    List<TbTypeTemplate> findAll();


    PageResult findPage(int page, int rows);

    List<Map> selectOptionList();


    /**
     * 分页
     * @param pageNum 当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    PageResult findPage(TbTypeTemplate typeTemplate, int pageNum,int pageSize);

    List<Map> selectOptionSpecificationList();

    void add(TbTypeTemplate tbTypeTemplate);

    void delete(Long[] ids);

    TbTypeTemplate findOne(Long id);

    void update(TbTypeTemplate tbTypeTemplate);
}
