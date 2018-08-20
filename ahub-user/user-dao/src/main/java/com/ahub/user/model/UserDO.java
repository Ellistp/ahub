package com.ahub.user.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author chengtianping
 * @description
 * 下面四个注解可以使用@Data注解代替
 * @Setter
   @Getter
   @ToString
   @EqualsAndHashCode
 * @date 2018/8/17
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@TableName("acc_user")
public class UserDO implements Serializable{

    @TableField(exist = false)
    private static final long serialVersionUID = -6067522261415546553L;

    /** 主键id */
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

    @TableField(value = "gmt_modified")
    private Date gmtModified;

    private String account;

    private String name;

    private String salt;

    private String password;

    private Integer sex;

    private Integer age;

    private String phone;

    @TableField(value = "user_type")
    private Integer userType;

    private Integer status;

    @TableField(value = "organization_id")
    private Long organizationId;
}
