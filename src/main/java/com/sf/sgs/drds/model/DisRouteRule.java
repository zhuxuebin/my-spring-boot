/*
 * Copyright (c) 2018, S.F. Express Inc. All rights reserved.
 */

package com.sf.sgs.drds.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述： 路由规则信息
 *
 * @author 01374806
 * @date 2018/6/2
 */
@Data
public class DisRouteRule implements Serializable {

    private static final long serialVersionUID = -9203137104668362256L;

    private Long id;

    private Long configId;

    private Integer ruleType;

    private Integer version;

    private String routeRule;

    private String creator;

    private Date createTime;

    private String modifier;

    private Date modifyTime;


}