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
@TableName("acc_role_resource")
public class RoleResourceDO extends BaseDO implements Serializable{

    @TableField(exist = false)
    private static final long serialVersionUID = 7536874030246215912L;

    @TableField(value = "role_id")
    private Long roleId;

    @TableField(value = "resource_id")
    private Long resourceId;

}
