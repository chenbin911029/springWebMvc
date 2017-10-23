/*************************************************************************
*                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
*
*                COPYRIGHT (C) HONGLING CAPITAL CORPORATION 2012
*    ALL RIGHTS RESERVED BY HONGLING CAPITAL CORPORATION. THIS PROGRAM
* MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY
* HONGLING CAPITAL CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
* OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN
* PERMISSION OF HONGLING CAPITAL CORPORATION. USE OF COPYRIGHT NOTICE
* DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.
*                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
*************************************************************************/

package com.springmvc.dao;

import com.springmvc.pojo.HfxActivityExchange;

import java.util.List;

/**
* 2017红粉X计划活动兑换奖品实体的DAO接口定义。
*
* @author chenbin at 2017/08/03
*/
public interface HfxActivityExchangeDAO {

    /**
     * 根据用户id查询兑换奖品记录

     * @return
     */
    List<HfxActivityExchange> selectHfxExchangeByUserId();

}
