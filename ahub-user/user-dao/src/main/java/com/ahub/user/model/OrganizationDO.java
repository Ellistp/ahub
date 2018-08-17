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
 * @date 2018/8/17
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class OrganizationDO implements Serializable{

    private static final long serialVersionUID = -6890282155313817667L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String name;

    private String address;

    private String code;

    private String icon;

    private Long parentId;

    private Integer seq;
}
