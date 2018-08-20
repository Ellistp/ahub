package com.ahub.user.model;

import java.io.Serializable;

import com.ahub.common.model.base.BaseDO;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@TableName("res_resource")
public class ResourceDO extends BaseDO implements Serializable{

    @TableField(exist = false)
    private static final long serialVersionUID = -7949903748142282190L;

    private String name;

    private String url;

    @TableField(value = "open_mode")
    private String openMode;

    private String description;

    private String icon;

    @TableField(value = "parent_id")
    private Long parentId;

    private Integer seq;

    private Integer status;

    @TableField(value = "resource_type")
    private Integer resourceType;
}
