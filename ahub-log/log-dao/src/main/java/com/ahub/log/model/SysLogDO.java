package com.ahub.log.model;

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
public class SysLogDO implements Serializable{

    private static final long serialVersionUID = -2326845148851099545L;

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Long userId;

    private String optDesc;

    private String url;

    private String ip;
}
