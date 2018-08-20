package com.ahub.user.model;

import java.io.Serializable;

import com.ahub.common.model.BaseDO;
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
@TableName("acc_role")
public class RoleDO extends BaseDO implements Serializable{

    @TableField(exist = false)
    private static final long serialVersionUID = 6547481218644737430L;

    private String name;

    private String description;

    private Integer seq;

    private Integer status;
}
