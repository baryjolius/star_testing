package org.nc.MaklumatCalon.logic;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cjf.daab.SqlHelper;
import cjf.daab.ext.util.EntityImplementer;


import org.codehaus.jackson.JsonNode;
import org.nc.MaklumatCalon.entity.Negeri;
import org.nc.MaklumatCalon.entity.NegeriImplementer;
import org.nc.MaklumatCalon.entity.TestCalon;
import org.nc.MaklumatCalon.entity.TestCalonImplementer;
import org.nc.MaklumatCalon.entity.TestCalonSek;
import org.nc.MaklumatCalon.entity.TestCalonSekImplementer;
import org.nc.MaklumatCalon.entity.TestSekolah;
import org.nc.MaklumatCalon.entity.TestSekolahImplementer;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

public class MaklumatCalon{
 
	public MaklumatCalon() {
		// TODO Auto-generated constructor stub
	}
	
	public String namaNegeri(String negeriKod) throws SQLException{
		NegeriImplementer impl = new NegeriImplementer();
		Negeri negeri = impl.getNegeri(negeriKod,"NEGERI_NAMA","NEGERI_KOD_PK");
		return negeri.getNegeriNama();
	}
	
	public List<String[]> senaraiCalonSekolah(String nama){
		System.out.println("flag kat sini A");
		EntityImplementer impl = new EntityImplementer();
		SqlHelper sqlhp = new SqlHelper();
		List<String[]> result = new ArrayList<String[]>();
		System.out.println("flag kat sini B");
		try {
			Connection conn = impl.getConnection();
			String sqlQuery="SELECT test_calon_sek.test_calon_sek, test_calon_sek.test_calon_id, "+
					       "test_calon_sek.test_sekolah_pk, test_calon_sek.no_pelajar, "+
					       "test_calon.nama, test_calon.nokp, test_calon.nama_samaran, "+
					       "test_sekolah.negeri_pk, test_sekolah.nama_sekolah "+
					  		"FROM test_calon, test_calon_sek, test_sekolah "+
					 "WHERE (    (test_calon.test_calon_id = test_calon_sek.test_calon_id) "+
					        "AND (test_sekolah.test_sekolah_pk = test_calon_sek.test_sekolah_pk) "+
					       ")";
			
			if(nama!=null && !nama.equals("")){
				sqlQuery += "AND test_calon.nama like '%"+nama+"%'";
			}
			
			ResultSet rsSet = sqlhp.executeQuery(conn, sqlQuery);
			System.out.println("flag kat sini C");
			System.out.println("rsSet : " + rsSet.getRow() );
			while (rsSet.next()){
				String[] temp= new String[10];
				temp[0] = rsSet.getString("test_calon_id");
				temp[1] = rsSet.getString("test_sekolah_pk");
				temp[2] = rsSet.getString("nama_sekolah");
				temp[3] = rsSet.getString("nama");
				temp[4] = rsSet.getString("nokp");
				temp[5] = rsSet.getString("test_calon_sek");
				
				result.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("flag kat sini Last");
		return result;		
		
	} 
	
	//maklumat calon
	public String[] maklumatCalonSekolah(String test_calon_sek){
		System.out.println("flag kat sini A");
		EntityImplementer impl = new EntityImplementer();
		SqlHelper sqlhp = new SqlHelper();
		String[] result = new String[10];
		System.out.println("flag kat sini B");
		try {
			Connection conn = impl.getConnection();
			String sqlQuery="SELECT test_calon_sek.test_calon_sek, test_calon_sek.test_calon_id, "+
					       "test_calon_sek.test_sekolah_pk, test_calon_sek.no_pelajar, "+
					       "test_calon.nama, test_calon.nokp, test_calon.nama_samaran, "+
					       "test_sekolah.negeri_pk, test_sekolah.nama_sekolah "+
					  		"FROM test_calon, test_calon_sek, test_sekolah "+
					 "WHERE (    (test_calon.test_calon_id = test_calon_sek.test_calon_id) "+
					        "AND (test_sekolah.test_sekolah_pk = test_calon_sek.test_sekolah_pk) "+
					       ") AND test_calon_sek.test_calon_sek ="+test_calon_sek;
			
			ResultSet results = sqlhp.executeQuery(conn, sqlQuery);
			System.out.println("flag kat sini C");
			while (results.next()){
				result[0] = results.getString("test_calon_sek");
				result[1] = results.getString("test_calon_id");
				result[2] = results.getString("test_sekolah_pk");
				result[3] = results.getString("no_pelajar");
				result[4] = results.getString("nama");
				result[5] = results.getString("nokp");
				result[6] = results.getString("nama_samaran");
				result[7] = results.getString("negeri_pk");
				result[8] = results.getString("nama_sekolah");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("flag kat sini Last");
		return result;		
		
	} 
	
	//public insert
	public boolean PenyediaanCalon(TestCalon calon, TestCalonSek ts_calonSek) throws SystemException{
		TestCalonImplementer calonImpl = new TestCalonImplementer();
		TestCalonSekImplementer implCalonSek = new TestCalonSekImplementer();
		boolean result = false;
		try {
			
			System.out.println("calon_id :"+calon.getTestCalonId());
			calonImpl.create(calon);
			implCalonSek.create(ts_calonSek);
			
			result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
		
	//update
	public boolean PembaharuanMaklCalon(TestCalon calon, TestCalonSek calonSek) throws SQLException{
		boolean result = false;
		
		TestCalonImplementer implCalon = new TestCalonImplementer();
		implCalon.update(calon);
		
		TestCalonSekImplementer implCalonSek = new TestCalonSekImplementer();
		implCalonSek.update(calonSek);
		
		return result;
	}
	
	public boolean PenghapusanCalon(BigDecimal calon_id) throws SQLException{
		boolean result = false;
		TestCalonSekImplementer calonImpl = new TestCalonSekImplementer();
		TestCalonSek calon = calonImpl.getTestCalonSek(calon_id);
		calonImpl.remove(calon);
		
		return result;
	}
	
	public String senaraiNegeri() throws SQLException{
		NegeriImplementer impl = new NegeriImplementer();
		List<Negeri> results = new ArrayList();
		results = impl.getNegeris();
		
		return impl.toJsonString(results);
	}
	
	public String senaraiSekolah() throws SQLException{
		TestSekolahImplementer impl = new TestSekolahImplementer();
		List<TestSekolah> results = new ArrayList();
		results = impl.getTestSekolahs();
		
		return impl.toJsonString(results);
	}
}
