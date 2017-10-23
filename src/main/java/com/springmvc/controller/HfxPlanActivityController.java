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

package com.springmvc.controller;


import com.springmvc.pojo.HfxActivityExchange;
import com.springmvc.service.HfxActivityExchangeService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 2017红岭红粉X计划活动前端控制器。
 *
 * @author chenbin at 2017/08/03。
 */
@Controller
@RequestMapping(
    value = "/activityHfxPlan",
    produces = "text/html")
public class HfxPlanActivityController {

    private static final Logger LOGGER = Logger.getLogger(HfxPlanActivityController.class);

    @Resource
    private HfxActivityExchangeService hfxActivityExchangeService;

    public HfxPlanActivityController() {
        super();
    }

    /**
     * 活动首页。
     *
     * @param request
     * @param model
     * @return
     * @throws IOException
     * @author: chenbin
     * @datetime: 2017-08-04 14:42:12
     */
    @RequestMapping
    public String indexHfxActivity(HttpServletRequest request, HttpServletResponse response, Model model) {
        //查询用户兑换奖品记录
        List<HfxActivityExchange> exchangeResultBean = hfxActivityExchangeService.
                queryExchangeByUserId();
        model.addAttribute("exchangeList", exchangeResultBean);
        return "hfx/hfx_plan_activity_app";
    }

    /**
     * 兑换奖品，虚拟奖品实时发放，实物奖品存放在兑换记录表
     *
     * @param request
     * @param prizesCode
     * @return
     */
    @RequestMapping(
        value = "exchangePrizes",
        method = RequestMethod.POST,
        produces = "application/json")
    @ResponseBody
    public Object exchangePrizes(HttpServletRequest request, Integer prizesCode) {
        return new String("感谢您的参与！暂不提供即时兑奖.");
    }

}