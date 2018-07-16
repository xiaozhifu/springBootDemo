package com.fxz.demo.entity;

import java.math.BigDecimal;

public class FilmGoods {
    private Integer goodsId;

    private Integer brandId;

    private String goodsName;

    private BigDecimal frontPrice;

    private BigDecimal behindPrice;

    private BigDecimal sidePrice;

    private BigDecimal behindSidePrice;

    private String positionStr;

    private Integer sort;

    private Integer status;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getFrontPrice() {
        return frontPrice;
    }

    public void setFrontPrice(BigDecimal frontPrice) {
        this.frontPrice = frontPrice;
    }

    public BigDecimal getBehindPrice() {
        return behindPrice;
    }

    public void setBehindPrice(BigDecimal behindPrice) {
        this.behindPrice = behindPrice;
    }

    public BigDecimal getSidePrice() {
        return sidePrice;
    }

    public void setSidePrice(BigDecimal sidePrice) {
        this.sidePrice = sidePrice;
    }

    public BigDecimal getBehindSidePrice() {
        return behindSidePrice;
    }

    public void setBehindSidePrice(BigDecimal behindSidePrice) {
        this.behindSidePrice = behindSidePrice;
    }

    public String getPositionStr() {
        return positionStr;
    }

    public void setPositionStr(String positionStr) {
        this.positionStr = positionStr == null ? null : positionStr.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}