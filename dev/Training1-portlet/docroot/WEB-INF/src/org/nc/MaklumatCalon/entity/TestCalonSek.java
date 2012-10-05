package org.nc.MaklumatCalon.entity;

import cjf.daab.EntityBase;
import cjf.daab.Util;
import java.io.Serializable;
import java.math.BigDecimal;

public class TestCalonSek extends EntityBase implements Serializable {
	
	private static final long serialVersionUID = 2778143035044068656L;
	public static final int NOPELAJAR_SIZE = 45;
	
	private String noPelajar = null;
	private BigDecimal testCalonId = null;
	private BigDecimal testCalonSek = new BigDecimal(0);
	private BigDecimal testSekolahPk = null;
	
	public TestCalonSek() {}

	public String getNoPelajar() {
		return this.noPelajar;
	}
	
	public void setNoPelajar(String value) {
		if ((value != null) && (value.length() > NOPELAJAR_SIZE)) {
			throw new IllegalArgumentException("The length of noPelajar cannot exceed NOPELAJAR_SIZE.");
		}
		this.notifyUpdate();
		this.noPelajar = value;
	}

	public BigDecimal getTestCalonId() {
		return this.testCalonId;
	}
	
	public void setTestCalonId(BigDecimal value) {
		this.notifyUpdate();
		this.testCalonId = value;
	}

	public BigDecimal getTestCalonSek() {
		return this.testCalonSek;
	}
	
	public void setTestCalonSek(BigDecimal value) {
		if (value == null) {
			throw new NullPointerException("The property testCalonSek cannot be null.");
		}
		this.notifyUpdate();
		this.testCalonSek = value;
	}

	public BigDecimal getTestSekolahPk() {
		return this.testSekolahPk;
	}
	
	public void setTestSekolahPk(BigDecimal value) {
		this.notifyUpdate();
		this.testSekolahPk = value;
	}

	@Override
	public boolean equals(Object o) {
		if ((o == null) || !(o instanceof TestCalonSek)) {
			return false;
		}
		TestCalonSek obj = (TestCalonSek)o;
		return 
			Util.equals(this.noPelajar, obj.noPelajar) &&
			Util.equals(this.testCalonId, obj.testCalonId) &&
			Util.equals(this.testCalonSek, obj.testCalonSek) &&
			Util.equals(this.testSekolahPk, obj.testSekolahPk);
	}
	
	@Override
	public int hashCode() {
		return 709554622 ^
			Util.hashCode(this.noPelajar) ^
			Util.hashCode(this.testCalonId) ^
			Util.hashCode(this.testCalonSek) ^
			Util.hashCode(this.testSekolahPk);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{noPelajar=" + getNoPelajar());
		sb.append(", testCalonId=" + getTestCalonId());
		sb.append(", testCalonSek=" + getTestCalonSek());
		sb.append(", testSekolahPk=" + getTestSekolahPk());
		sb.append("}");
		return sb.toString();
	}
	
	@Override
	public String toXmlString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<model><model-name>");
		sb.append("org.nc.MaklumatCalon.entity.TestCalonSek");
		sb.append("</model-name>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getNoPelajar());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getTestCalonId());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getTestCalonSek());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getTestSekolahPk());
		sb.append("]]></column-value></column>");
		sb.append("</model>");
		return sb.toString();
	}
	
	@Override
	public String toJsonString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"noPelajar\"=\"" + getNoPelajar() + "\"");
		sb.append(", \"testCalonId\"=\"" + getTestCalonId() + "\"");
		sb.append(", \"testCalonSek\"=\"" + getTestCalonSek() + "\"");
		sb.append(", \"testSekolahPk\"=\"" + getTestSekolahPk() + "\"");
		sb.append("}");
		return sb.toString();
	}
	
}