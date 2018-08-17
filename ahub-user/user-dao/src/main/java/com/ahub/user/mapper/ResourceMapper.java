package com.ahub.user.mapper;

import java.util.List;

import com.ahub.user.model.ResourceDO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface ResourceMapper extends BaseMapper<ResourceDO>{

    /**
     * 更新记录
     * @param resourceDO
     * @return
     */
    int update(ResourceDO resourceDO);

    List<ResourceDO> selectResourceListByRoleIdList(@Param("list") List<Long> list);
}
