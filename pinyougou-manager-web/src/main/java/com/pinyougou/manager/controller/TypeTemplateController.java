package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by 阿威 on 2018/9/6.
 */
@RestController
@RequestMapping("typeTemplate")
public class TypeTemplateController {

    @Reference
    private TypeTemplateService typeTemplateService;



    @RequestMapping("/findAll")
    public List<TbTypeTemplate> findAll() {
        return typeTemplateService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        PageResult pageResult = typeTemplateService.findPage(page, rows);

        return pageResult;
    }

    /**
     * 模板用 品牌列表
     * @return
     */
    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return typeTemplateService.selectOptionList();
    }   /**
     * 模板用 品牌列表
     * @return
     */
    @RequestMapping("/selectOptionSpecificationList")
    public List<Map> selectOptionSpecificationList(){
        return typeTemplateService.selectOptionSpecificationList();
    }

    /**
     * 查询+分页
     * @param typeTemplate
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbTypeTemplate typeTemplate, int page, int rows  ){
        return typeTemplateService.findPage(typeTemplate, page, rows);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody TbTypeTemplate TbTypeTemplate){
        try {
            typeTemplateService.add(TbTypeTemplate);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            typeTemplateService.delete(ids);
            return new Result(true,"");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"");
        }
    }

    @RequestMapping("/findOne")
    public TbTypeTemplate findOne(Long id){

        return typeTemplateService.findOne(id);
    }


    @RequestMapping("/update")
    public Result update(@RequestBody TbTypeTemplate TbTypeTemplate){
        try {
            typeTemplateService.update(TbTypeTemplate);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

}
