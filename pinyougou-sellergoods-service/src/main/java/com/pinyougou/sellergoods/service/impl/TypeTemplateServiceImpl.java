package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbTypeTemplateMapper;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.pojo.TbTypeTemplateExample;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by 阿威 on 2018/9/6.
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService{

    @Autowired
    protected TbTypeTemplateMapper typeTemplateMapper;

    @Autowired
    private TbBrandMapper brandMapper;
    @Autowired
    private TbSpecificationMapper specificationMapper;

    @Override
    public List<TbTypeTemplate> findAll() {
        return typeTemplateMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        Page<TbTypeTemplate> p = (Page<TbTypeTemplate>) typeTemplateMapper.selectByExample(null);
        return new PageResult(p.getTotal(), p.getResult());
    }
    /**
     *模板 用 列表数据
     */
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }
    /**
     *模板 用 列表数据
     */
    public List<Map> selectOptionSpecificationList() {
        return specificationMapper.selectOptionSpecificationList();
    }

    @Override
    public void add(TbTypeTemplate tbTypeTemplate) {
        typeTemplateMapper.insert(tbTypeTemplate);
    }

    @Override
    public PageResult findPage(TbTypeTemplate typeTemplate, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbTypeTemplateExample example=new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = example.createCriteria();
        if(typeTemplate!=null){
            if(typeTemplate.getName()!=null && typeTemplate.getName().length()>0){
                criteria.andNameLike("%"+typeTemplate.getName()+"%");
            }
        }
        Page<TbTypeTemplate> page= (Page<TbTypeTemplate>)typeTemplateMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            typeTemplateMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public TbTypeTemplate findOne(Long id) {
        return typeTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbTypeTemplate tbTypeTemplate) {
        typeTemplateMapper.updateByPrimaryKey(tbTypeTemplate);
    }


}
