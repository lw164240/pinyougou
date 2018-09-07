package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;


public interface BrandService {


	List<TbBrand> findAll();
	

	PageResult findPage(int page, int rows);
	/**
	 * 增加
	 */
	 void add(TbBrand brand);

	/**
	 * 批量删除
	 * @param ids
	 */
	void delete(Long [] ids);

	/**
	 * 修改
	 */
	void update(TbBrand brand);
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	TbBrand findOne(Long id);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	 PageResult findPage(TbBrand brand, int pageNum,int pageSize);

}
