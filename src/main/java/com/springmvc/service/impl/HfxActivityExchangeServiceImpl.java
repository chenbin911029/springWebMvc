/*************************************************************************
 *          HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *
 *          COPYRIGHT (C) HONGLING CAPITAL CORPORATION 2012
 *    ALL RIGHTS RESERVED BY HONGLING CAPITAL CORPORATION. THIS PROGRAM
 * MUST BE USED SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY
 * HONGLING CAPITAL CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
 * OR DISCLOSED TO OTHERS, IN ANY FORM, WITHOUT THE PRIOR WRITTEN
 * PERMISSION OF HONGLING CAPITAL CORPORATION. USE OF COPYRIGHT NOTICE
 * DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.
 *          HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *************************************************************************/

package com.springmvc.service.impl;


import com.springmvc.dao.HfxActivityExchangeDAO;
import com.springmvc.pojo.HfxActivityExchange;
import com.springmvc.service.HfxActivityExchangeService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 红粉X计划活动兑奖记录接口实现。
 *
 *  @author chenbin at 2017/08/04。
 */
@Service("hfxActivityExchangeService")
public class HfxActivityExchangeServiceImpl implements HfxActivityExchangeService {

    protected static final Logger LOG = LogManager.getLogger(HfxActivityExchangeServiceImpl.class);
    @Resource
    HfxActivityExchangeDAO hfxActivityExchangeDAO;

    /**
     * 根据userId查询兑奖记录
     * @return
     */
    public List<HfxActivityExchange> queryExchangeByUserId() {
        List<HfxActivityExchange> list = hfxActivityExchangeDAO.selectHfxExchangeByUserId();
        return list;
    }

}