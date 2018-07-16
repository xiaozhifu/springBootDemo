package com.fxz.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by fuxiaozhi on 2018\7\13 0013.
 */
public class FilmCombo {
    private Integer comboId;
    private Integer brandId;
    private String comboName;
    private Integer frontGoodsId;
    private Integer sideGoodsId;
    private Integer behindGoodsId;
    private String frontGoodsName;
    private String sideGoodsName;
    private String behindGoodsName;
    private BigDecimal comboPrice;
    private String comboUrl;
    private Integer comboType;
    private Integer sort;
    private Date createTime;
    private String remark;

    public Integer getComboId() {
        return comboId;
    }

    public void setComboId(Integer comboId) {
        this.comboId = comboId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public Integer getFrontGoodsId() {
        return frontGoodsId;
    }

    public void setFrontGoodsId(Integer frontGoodsId) {
        this.frontGoodsId = frontGoodsId;
    }

    public Integer getSideGoodsId() {
        return sideGoodsId;
    }

    public void setSideGoodsId(Integer sideGoodsId) {
        this.sideGoodsId = sideGoodsId;
    }

    public Integer getBehindGoodsId() {
        return behindGoodsId;
    }

    public void setBehindGoodsId(Integer behindGoodsId) {
        this.behindGoodsId = behindGoodsId;
    }

    public String getFrontGoodsName() {
        return frontGoodsName;
    }

    public void setFrontGoodsName(String frontGoodsName) {
        this.frontGoodsName = frontGoodsName;
    }

    public String getSideGoodsName() {
        return sideGoodsName;
    }

    public void setSideGoodsName(String sideGoodsName) {
        this.sideGoodsName = sideGoodsName;
    }

    public String getBehindGoodsName() {
        return behindGoodsName;
    }

    public void setBehindGoodsName(String behindGoodsName) {
        this.behindGoodsName = behindGoodsName;
    }

    public BigDecimal getComboPrice() {
        return comboPrice;
    }

    public void setComboPrice(BigDecimal comboPrice) {
        this.comboPrice = comboPrice;
    }

    public String getComboUrl() {
        return comboUrl;
    }

    public void setComboUrl(String comboUrl) {
        this.comboUrl = comboUrl;
    }

    public Integer getComboType() {
        return comboType;
    }

    public void setComboType(Integer comboType) {
        this.comboType = comboType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
