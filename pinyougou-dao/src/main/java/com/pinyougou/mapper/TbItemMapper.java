package com.pinyougou.mapper;


import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbItemMapper {
    int countByExample(TbItemExample example);

    int deleteByExample(TbItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemExample example);

    TbItem selectByPrimaryKey(Long id);

    default int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemExample example) {
        return 0;
    }

    int updateByExample(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);
}