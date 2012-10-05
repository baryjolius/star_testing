package org.nc.MaklumatCalon.entity;

import cjf.daab.EntityBase;
import cjf.daab.Util;
import java.io.Serializable;
import java.math.BigDecimal;

public class TestCalon extends EntityBase implements Serializable {
	
	private static final long serialVersionUID = -6846550805382659550L;
	public static final int NAMA_SIZE = 45;
	public static final int NAMASAMARAN_SIZE = 20;
	public static final int NOKP_SIZE = 15;
	
	private String nama = null;
	private String namaSamaran = null;
	private String nokp = null;
	private BigDecimal testCalonId = new BigDecimal(0);
	
	public TestCalon() {}

	public String getNama() {
		return this.nama;
	}
	
	public void setNama(String value) {
		if ((value != null) && (value.length() > NAMA_SIZE)) {
			throw new IllegalArgumentException("The length of nama cannot exceed NAMA_SIZE.");
		}
		this.notifyUpdate();
		this.nama = value;
	}

	public String getNamaSamaran() {
		return this.namaSamaran;
	}
	
	public void setNamaSamaran(String value) {
		if ((value != null) && (value.length() > NAMASAMARAN_SIZE)) {
			throw new IllegalArgumentException("The length of namaSamaran cannot exceed NAMASAMARAN_SIZE.");
		}
		this.notifyUpdate();
		this.namaSamaran = value;
	}

	public String getNokp() {
		return this.nokp;
	}
	
	public void setNokp(String value) {
		if ((value != null) && (value.length() > NOKP_SIZE)) {
			throw new IllegalArgumentException("The length of nokp cannot exceed NOKP_SIZE.");
		}
		this.notifyUpdate();
		this.nokp = value;
	}

	public BigDecimal getTestCalonId() {
		return this.testCalonId;
	}
	
	public void setTestCalonId(BigDecimal value) {
		if (value == null) {
			throw new NullPointerException("The property testCalonId cannot be null.");
		}
		this.notifyUpdate();
		this.testCalonId = value;
	}

	@Override
	public boolean equals(Object o) {
		if ((o == null) || !(o instanceof TestCalon)) {
			return false;
		}
		TestCalon obj = (TestCalon)o;
		return 
			Util.equals(this.nama, obj.nama) &&
			Util.equals(this.namaSamaran, obj.namaSamaran) &&
			Util.equals(this.nokp, obj.nokp) &&
			Util.equals(this.testCalonId, obj.testCalonId);
	}
	
	@Override
	public int hashCode() {
		return 797427867 ^
			Util.hashCode(this.nama) ^
			Util.hashCode(this.namaSamaran) ^
			Util.hashCode(this.nokp) ^
			Util.hashCode(this.testCalonId);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{nama=" + getNama());
		sb.append(", namaSamaran=" + getNamaSamaran());
		sb.append(", nokp=" + getNokp());
		sb.append(", testCalonId=" + getTestCalonId());
		sb.append("}");
		return sb.toString();
	}
	
	@Override
	public String toXmlString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<model><model-name>");
		sb.append("org.nc.MaklumatCalon.entity.TestCalon");
		sb.append("</model-name>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getNama());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getNamaSamaran());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getNokp());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getTestCalonId());
		sb.append("]]></column-value></column>");
		sb.append("</model>");
		return sb.toString();
	}
	
	@Override
	public String toJsonString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"nama\"=\"" + getNama() + "\"");
		sb.append(", \"namaSamaran\"=\"" + getNamaSamaran() + "\"");
		sb.append(", \"nokp\"=\"" + getNokp() + "\"");
		sb.append(", \"testCalonId\"=\"" + getTestCalonId() + "\"");
		sb.append("}");
		return sb.toString();
	}
	
}