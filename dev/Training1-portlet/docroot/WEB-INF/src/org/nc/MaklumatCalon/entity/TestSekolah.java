package org.nc.MaklumatCalon.entity;

import cjf.daab.EntityBase;
import cjf.daab.Util;
import java.io.Serializable;
import java.math.BigDecimal;

public class TestSekolah extends EntityBase implements Serializable {
	
	private static final long serialVersionUID = -103587414065855245L;
	public static final int NAMASEKOLAH_SIZE = 45;
	public static final int NEGERIPK_SIZE = 45;
	
	private String namaSekolah = null;
	private String negeriPk = null;
	private BigDecimal testSekolahPk = new BigDecimal(0);
	
	public TestSekolah() {}

	public String getNamaSekolah() {
		return this.namaSekolah;
	}
	
	public void setNamaSekolah(String value) {
		if ((value != null) && (value.length() > NAMASEKOLAH_SIZE)) {
			throw new IllegalArgumentException("The length of namaSekolah cannot exceed NAMASEKOLAH_SIZE.");
		}
		this.notifyUpdate();
		this.namaSekolah = value;
	}

	public String getNegeriPk() {
		return this.negeriPk;
	}
	
	public void setNegeriPk(String value) {
		if ((value != null) && (value.length() > NEGERIPK_SIZE)) {
			throw new IllegalArgumentException("The length of negeriPk cannot exceed NEGERIPK_SIZE.");
		}
		this.notifyUpdate();
		this.negeriPk = value;
	}

	public BigDecimal getTestSekolahPk() {
		return this.testSekolahPk;
	}
	
	public void setTestSekolahPk(BigDecimal value) {
		if (value == null) {
			throw new NullPointerException("The property testSekolahPk cannot be null.");
		}
		this.notifyUpdate();
		this.testSekolahPk = value;
	}

	@Override
	public boolean equals(Object o) {
		if ((o == null) || !(o instanceof TestSekolah)) {
			return false;
		}
		TestSekolah obj = (TestSekolah)o;
		return 
			Util.equals(this.namaSekolah, obj.namaSekolah) &&
			Util.equals(this.negeriPk, obj.negeriPk) &&
			Util.equals(this.testSekolahPk, obj.testSekolahPk);
	}
	
	@Override
	public int hashCode() {
		return -1042214517 ^
			Util.hashCode(this.namaSekolah) ^
			Util.hashCode(this.negeriPk) ^
			Util.hashCode(this.testSekolahPk);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{namaSekolah=" + getNamaSekolah());
		sb.append(", negeriPk=" + getNegeriPk());
		sb.append(", testSekolahPk=" + getTestSekolahPk());
		sb.append("}");
		return sb.toString();
	}
	
	@Override
	public String toXmlString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<model><model-name>");
		sb.append("org.nc.MaklumatCalon.entity.TestSekolah");
		sb.append("</model-name>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getNamaSekolah());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getNegeriPk());
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
		sb.append("{\"namaSekolah\":\"" + getNamaSekolah() + "\"");
		sb.append(", \"negeriPk\":\"" + getNegeriPk() + "\"");
		sb.append(", \"testSekolahPk\":\"" + getTestSekolahPk() + "\"");
		sb.append("}");
		return sb.toString();
	}
	
}