package com.shopin.commonlibrary.entity;

import java.io.Serializable;
import java.util.List;

public class SaleAttributeNameVo implements Serializable{

	private String name;
	private String nameId;
	private List<SaleAttributeVo> saleVo;
	private String saleAttr;
	private boolean nameIsChecked;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameId() {
		return nameId;
	}

	public void setNameId(String nameId) {
		this.nameId = nameId;
	}

	public List<SaleAttributeVo> getSaleVo() {
		return saleVo;
	}

	public void setSaleVo(List<SaleAttributeVo> saleVo) {
		this.saleVo = saleVo;
	}

	public String getSaleAttr() {
		return saleAttr;
	}

	public void setSaleAttr(String saleAttr) {
		this.saleAttr = saleAttr;
	}

	public boolean isNameIsChecked() {
		return nameIsChecked;
	}

	public void setNameIsChecked(boolean nameIsChecked) {
		this.nameIsChecked = nameIsChecked;
	}


	@Override
	public String toString() {
		return "SaleAttributeNameVo{" +
				"name='" + name + '\'' +
				", nameId='" + nameId + '\'' +
				", saleVo=" + saleVo +
				", saleAttr='" + saleAttr + '\'' +
				", nameIsChecked=" + nameIsChecked +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SaleAttributeNameVo that = (SaleAttributeNameVo) o;

		return name != null ? name.equals(that.name) : that.name == null;

	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}
}
