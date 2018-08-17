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
public class RoleResourceDO implements Serializable{

    private static final long serialVersionUID = 7536874030246215912L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Long roleId;

    private Long resourceId;

}
