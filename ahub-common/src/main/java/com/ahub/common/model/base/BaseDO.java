package com.ahub.common.model.base;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/20
 */
@Setter
@Getter
public class BaseDO {

    /** 主键id */
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

    @TableField(value = "gmt_modified")
    private Date gmtModified;
}
