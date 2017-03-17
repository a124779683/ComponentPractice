package com.shopin.commonlibrary.entity;

import java.io.Serializable;

public class SaleAttributeVo implements Serializable {

	@Override
	public String toString() {
		return "SaleAttributeVo{" +
				"goods='" + goods + '\'' +
				", value='" + value + '\'' +
				", goodsAndValId='" + goodsAndValId + '\'' +
				", isChecked=" + isChecked +
				'}';
	}

	private String goods;
	private String value;
	private String goodsAndValId;
	private boolean isChecked;

	public String getGoodsAndValId() {
		return goodsAndValId;
	}

	public void setGoodsAndValId(String goodsAndValId) {
		this.goodsAndValId = goodsAndValId;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SaleAttributeVo that = (SaleAttributeVo) o;

		return goodsAndValId != null ? goodsAndValId.equals(that.goodsAndValId) : that.goodsAndValId == null;
	}

	@Override
	public int hashCode() {
		return goodsAndValId != null ? goodsAndValId.hashCode() : 0;
	}
}
