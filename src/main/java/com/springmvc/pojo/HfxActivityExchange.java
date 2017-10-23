/*************************************************************************
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *
 *                COPYRIGHT (C) HONGLING CAPITAL CORPORATION 2012
 *    ALL RIGHTS RESERVED BY HONGLING CAPITAL CORPORATION. THIS PROGRAM
 * MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY
 * HONGLING CAPITAL CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
 * OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN
 * PERMISSION OF HONGLING CAPITAL CORPORATION. USE OF COPYRIGHT NOTICE
 DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *************************************************************************/
package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * desc:红粉X计划_兑换奖品记录表映射实体
 * <p>
 *   对应的表：pc_activity_hfx_exchange
 * </p>
 * Created by chenbin on 2017/8/2 14:55
 */
public class HfxActivityExchange implements Serializable {
    /**
     * column：id。
     * comment：id 主键
     */
    private String id;

    /**
     * column：user_id。
     * comment：userId 兑奖用户id
     */
    private Long userId;

    /**
     * column：user_name。
     * comment：兑奖用户姓名。
     */
    private String userName;

    /**
     * column：exchange_time。
     * comment：兑换时间。
     */
    private Date exchangeTime;

    /**
     * column：spend_reputation。
     * comment：spendReputation 消耗人品值
     */
    private Integer spendReputation;

    /**
     * column：prizes_code。
     * comment：兑换奖品编码。
     * (1：100积分，2：10红币，3：20元现金红包，4：50元现金红包，
     *  5：180VIP券，6：拍立得，7：Kindle，8：iPadmini4，9：iPhone7)
     */
    private Integer prizesCode;

    /**
     * column：prizes_name。
     * comment：兑换奖品名称。
     */
    private String prizesName;

    /**
     * column：prizes_type。
     * comment：奖品类型(0 虚拟奖品 1 实物奖品)。
     */
    private Integer prizesType;

    /**
     * column：pay_status。
     * comment：奖品发放状态(0 未发放 1 已发放)。
     */
    private Integer payStatus;

    /**
     * column：create_time。
     * comment：创建时间。
     */
    private Date createTime;

    /**
     * column：update_time。
     * comment：更新时间。
     */
    private Date updateTime;

    /**
     * column：status。
     * comment：删除标识 0 未删除 -2 已删除。
     */
    private Integer status;

    /**
     * column：remark。
     * comment：备注。
     */
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getExchangeTime() {
        return exchangeTime;
    }

    public void setExchangeTime(Date exchangeTime) {
        this.exchangeTime = exchangeTime;
    }

    public Integer getSpendReputation() {
        return spendReputation;
    }

    public void setSpendReputation(Integer spendReputation) {
        this.spendReputation = spendReputation;
    }

    public Integer getPrizesCode() {
        return prizesCode;
    }

    public void setPrizesCode(Integer prizesCode) {
        this.prizesCode = prizesCode;
    }

    public String getPrizesName() {
        return prizesName;
    }

    public void setPrizesName(String prizesName) {
        this.prizesName = prizesName;
    }

    public Integer getPrizesType() {
        return prizesType;
    }

    public void setPrizesType(Integer prizesType) {
        this.prizesType = prizesType;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}
