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
public class UserDO extends BaseDO implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = -6067522261415546553L;

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
