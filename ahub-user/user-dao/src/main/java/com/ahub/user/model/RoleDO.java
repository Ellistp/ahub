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
public class RoleDO implements Serializable{

    private static final long serialVersionUID = 6547481218644737430L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String name;

    private String description;

    private Integer seq;

    private Integer status;
}
