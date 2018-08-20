package com.ahub.log.model;

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
@TableName("sys_log")
public class SysLogDO extends BaseDO implements Serializable{

    @TableField(exist = false)
    private static final long serialVersionUID = -2326845148851099545L;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "opt_desc")
    private String optDesc;

    private String url;

    private String ip;
}
