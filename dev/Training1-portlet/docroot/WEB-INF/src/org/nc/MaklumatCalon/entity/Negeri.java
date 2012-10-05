package org.nc.MaklumatCalon.entity;

import cjf.daab.EntityBase;
import cjf.daab.Util;
import java.io.Serializable;
import java.util.Calendar;

public class Negeri extends EntityBase implements Serializable {
	
	private static final long serialVersionUID = 1443610454712090606L;
	public static final int NEGERIKOD2_SIZE = 2;
	public static final int NEGERIKODPK_SIZE = 45;
	public static final int NEGERINAMA_SIZE = 45;
	public static final int NEGERIORDER_SIZE = 45;
	public static final int NEGERITEL_SIZE = 45;
	public static final int STAFFKEMASKINI_SIZE = 100;
	public static final int STAFFSIMPAN_SIZE = 100;
	
	private String negeriKod2 = null;
	private String negeriKodPk = "";
	private String negeriNama = null;
	private String negeriOrder = null;
	private String negeriTel = null;
	private String staffKemaskini = null;
	private String staffSimpan = null;
	private Calendar tkhKemaskini = null;
	private Calendar tkhMigrasi = null;
	private Calendar tkhSimpan = null;
	
	public Negeri() {}

	public String getNegeriKod2() {
		return this.negeriKod2;
	}
	
	public void setNegeriKod2(String value) {
		if ((value != null) && (value.length() > NEGERIKOD2_SIZE)) {
			throw new IllegalArgumentException("The length of negeriKod2 cannot exceed NEGERIKOD2_SIZE.");
		}
		this.notifyUpdate();
		this.negeriKod2 = value;
	}

	public String getNegeriKodPk() {
		return this.negeriKodPk;
	}
	
	public void setNegeriKodPk(String value) {
		if (value == null) {
			throw new NullPointerException("The property negeriKodPk cannot be null.");
		}
		if ((value != null) && (value.length() > NEGERIKODPK_SIZE)) {
			throw new IllegalArgumentException("The length of negeriKodPk cannot exceed NEGERIKODPK_SIZE.");
		}
		this.notifyUpdate();
		this.negeriKodPk = value;
	}

	public String getNegeriNama() {
		return this.negeriNama;
	}
	
	public void setNegeriNama(String value) {
		if ((value != null) && (value.length() > NEGERINAMA_SIZE)) {
			throw new IllegalArgumentException("The length of negeriNama cannot exceed NEGERINAMA_SIZE.");
		}
		this.notifyUpdate();
		this.negeriNama = value;
	}

	public String getNegeriOrder() {
		return this.negeriOrder;
	}
	
	public void setNegeriOrder(String value) {
		if ((value != null) && (value.length() > NEGERIORDER_SIZE)) {
			throw new IllegalArgumentException("The length of negeriOrder cannot exceed NEGERIORDER_SIZE.");
		}
		this.notifyUpdate();
		this.negeriOrder = value;
	}

	public String getNegeriTel() {
		return this.negeriTel;
	}
	
	public void setNegeriTel(String value) {
		if ((value != null) && (value.length() > NEGERITEL_SIZE)) {
			throw new IllegalArgumentException("The length of negeriTel cannot exceed NEGERITEL_SIZE.");
		}
		this.notifyUpdate();
		this.negeriTel = value;
	}

	public String getStaffKemaskini() {
		return this.staffKemaskini;
	}
	
	public void setStaffKemaskini(String value) {
		if ((value != null) && (value.length() > STAFFKEMASKINI_SIZE)) {
			throw new IllegalArgumentException("The length of staffKemaskini cannot exceed STAFFKEMASKINI_SIZE.");
		}
		this.notifyUpdate();
		this.staffKemaskini = value;
	}

	public String getStaffSimpan() {
		return this.staffSimpan;
	}
	
	public void setStaffSimpan(String value) {
		if ((value != null) && (value.length() > STAFFSIMPAN_SIZE)) {
			throw new IllegalArgumentException("The length of staffSimpan cannot exceed STAFFSIMPAN_SIZE.");
		}
		this.notifyUpdate();
		this.staffSimpan = value;
	}

	public Calendar getTkhKemaskini() {
		return this.tkhKemaskini;
	}
	
	public void setTkhKemaskini(Calendar value) {
		this.notifyUpdate();
		this.tkhKemaskini = value;
	}

	public Calendar getTkhMigrasi() {
		return this.tkhMigrasi;
	}
	
	public void setTkhMigrasi(Calendar value) {
		this.notifyUpdate();
		this.tkhMigrasi = value;
	}

	public Calendar getTkhSimpan() {
		return this.tkhSimpan;
	}
	
	public void setTkhSimpan(Calendar value) {
		this.notifyUpdate();
		this.tkhSimpan = value;
	}

	@Override
	public boolean equals(Object o) {
		if ((o == null) || !(o instanceof Negeri)) {
			return false;
		}
		Negeri obj = (Negeri)o;
		return 
			Util.equals(this.negeriKod2, obj.negeriKod2) &&
			Util.equals(this.negeriKodPk, obj.negeriKodPk) &&
			Util.equals(this.negeriNama, obj.negeriNama) &&
			Util.equals(this.negeriOrder, obj.negeriOrder) &&
			Util.equals(this.negeriTel, obj.negeriTel) &&
			Util.equals(this.staffKemaskini, obj.staffKemaskini) &&
			Util.equals(this.staffSimpan, obj.staffSimpan) &&
			Util.equals(this.tkhKemaskini, obj.tkhKemaskini) &&
			Util.equals(this.tkhMigrasi, obj.tkhMigrasi) &&
			Util.equals(this.tkhSimpan, obj.tkhSimpan);
	}
	
	@Override
	public int hashCode() {
		return -1965448724 ^
			Util.hashCode(this.negeriKod2) ^
			Util.hashCode(this.negeriKodPk) ^
			Util.hashCode(this.negeriNama) ^
			Util.hashCode(this.negeriOrder) ^
			Util.hashCode(this.negeriTel) ^
			Util.hashCode(this.staffKemaskini) ^
			Util.hashCode(this.staffSimpan) ^
			Util.hashCode(this.tkhKemaskini) ^
			Util.hashCode(this.tkhMigrasi) ^
			Util.hashCode(this.tkhSimpan);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{negeriKod2=" + getNegeriKod2());
		sb.append(", negeriKodPk=" + getNegeriKodPk());
		sb.append(", negeriNama=" + getNegeriNama());
		sb.append(", negeriOrder=" + getNegeriOrder());
		sb.append(", negeriTel=" + getNegeriTel());
		sb.append(", staffKemaskini=" + getStaffKemaskini());
		sb.append(", staffSimpan=" + getStaffSimpan());
		sb.append(", tkhKemaskini=" + (getTkhKemaskini() == null ? "null" : getTkhKemaskini().getTime()));
		sb.append(", tkhMigrasi=" + (getTkhMigrasi() == null ? "null" : getTkhMigrasi().getTime()));
		sb.append(", tkhSimpan=" + (getTkhSimpan() == null ? "null" : getTkhSimpan().getTime()));
		sb.append("}");
		return sb.toString();
	}
	
	@Override
	public String toXmlString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<model><model-name>");
		sb.append("org.nc.MaklumatCalon.entity.Negeri");
		sb.append("</model-name>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getNegeriKod2());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getNegeriKodPk());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getNegeriNama());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getNegeriOrder());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getNegeriTel());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getStaffKemaskini());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getStaffSimpan());
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append((getTkhKemaskini() == null ? "null" : getTkhKemaskini().getTime()));
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append((getTkhMigrasi() == null ? "null" : getTkhMigrasi().getTime()));
		sb.append("]]></column-value></column>");
		sb.append("<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append((getTkhSimpan() == null ? "null" : getTkhSimpan().getTime()));
		sb.append("]]></column-value></column>");
		sb.append("</model>");
		return sb.toString();
	}
	
	@Override
	public String toJsonString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"negeriKod2\":\"" + getNegeriKod2() + "\"");
		sb.append(", \"negeriKodPk\":\"" + getNegeriKodPk() + "\"");
		sb.append(", \"negeriNama\":\"" + getNegeriNama() + "\"");
		sb.append(", \"negeriOrder\":\"" + getNegeriOrder() + "\"");
		sb.append(", \"negeriTel\":\"" + getNegeriTel() + "\"");
		sb.append(", \"staffKemaskini\":\"" + getStaffKemaskini() + "\"");
		sb.append(", \"staffSimpan\":\"" + getStaffSimpan() + "\"");
		sb.append(", \"tkhKemaskini\":\"" + (getTkhKemaskini() == null ? "null" : getTkhKemaskini().getTime()) + "\"");
		sb.append(", \"tkhMigrasi\":\"" + (getTkhMigrasi() == null ? "null" : getTkhMigrasi().getTime()) + "\"");
		sb.append(", \"tkhSimpan\":\"" + (getTkhSimpan() == null ? "null" : getTkhSimpan().getTime()) + "\"");
		sb.append("}");
		return sb.toString();
	}
	
}