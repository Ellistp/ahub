package com.ahub.user.model;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
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
public class UserDO implements Serializable{

    private static final long serialVersionUID = -6067522261415546553L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String account;

    private String name;

    private String salt;

    private String password;

    private Integer sex;

    private Integer age;

    private String phone;

    private Integer userType;

    private Integer status;

    private Long organizationId;
}
