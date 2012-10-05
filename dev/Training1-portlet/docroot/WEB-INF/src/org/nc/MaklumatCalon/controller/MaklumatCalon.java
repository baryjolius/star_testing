package org.nc.MaklumatCalon.controller;

import java.math.BigDecimal;
import java.sql.Connection;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.enc.ReadConfig;
import org.nc.MaklumatCalon.entity.TestCalon;
import org.nc.MaklumatCalon.entity.TestCalonSek;
import org.nc.MaklumatCalon.entity.TestSekolah;
import org.nc.liferay.PortletActionBase;
import org.nc.utils.CalendarUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class MaklumatCalon extends PortletActionBase {

	public MaklumatCalon(){
		// TODO Auto-generated constructor stub
	}
	
	private final static String SYSTEM_PARAM_WADL = "application";
	public void PenyediaanMaklumatCalon(ActionRequest actionReq, ActionResponse actionResponse){

	  try{
		  //warna biru nama variable dari form portlet 
		  String idSek = actionReq.getParameter("sekolah");
		  
		  String dfNamaCalon = actionReq.getParameter("dfNamaCalon");
		  String df_nokp = actionReq.getParameter("df_nokp");
		  String df_noPelajar = actionReq.getParameter("df_noPelajar");
		  
	       //insert		  
		  TestCalon ts_calon = new TestCalon();
		  BigDecimal newCalonId = new BigDecimal(CounterLocalServiceUtil.increment(TestCalon.class.getName()));
		  ts_calon.setTestCalonId(newCalonId);
		  ts_calon.setNama(dfNamaCalon);
		  ts_calon.setNokp(df_nokp);
		  
		  TestCalonSek ts_calonSek = new TestCalonSek();
		  BigDecimal idCalonSek = new BigDecimal(CounterLocalServiceUtil.increment(TestCalonSek.class.getName()));
		  System.out.println("idCalonSek :"+idCalonSek);
		  ts_calonSek.setTestCalonSek(idCalonSek);
		  ts_calonSek.setTestCalonId(newCalonId);
		  ts_calonSek.setNoPelajar(df_noPelajar);
		  ts_calonSek.setTestSekolahPk(new BigDecimal(idSek));
		  
		  org.nc.MaklumatCalon.logic.MaklumatCalon newCalonLogic = new org.nc.MaklumatCalon.logic.MaklumatCalon();
		  newCalonLogic.PenyediaanCalon(ts_calon,ts_calonSek);

           
		  MultivaluedMap<String, String> args = new MultivaluedMapImpl();
		  args.add("idCalonSek", ""+idCalonSek);
           
          //forwardToJsp(actionReq.getParameter("jspPage"), args, actionResponse, actionReq);
          forwardToJsp("/html/Maklumat calon/maklumatCalon.jsp",args,actionResponse,actionReq);
	   
		 }catch(Exception e){
		    SessionErrors.add(actionReq, "error");
		 }
	}
	
	public void PembaharuanMaklumatCalon(ActionRequest actionReq, ActionResponse actionResponse){

		  try{
			  //warna biru nama variable dari form portlet 
			  String idCalonSek = actionReq.getParameter("idCalonSek");
			  String idCalon = actionReq.getParameter("idCalon");
			  String idSek = actionReq.getParameter("idSek");
			  
			  String dfNamaCalon = actionReq.getParameter("dfNamaCalon");
			  String df_nokp = actionReq.getParameter("df_nokp");
			  String df_noPelajar = actionReq.getParameter("df_noPelajar");
			  
		        
			  TestCalon ts_calon = new TestCalon();
			  ts_calon.setTestCalonId(new BigDecimal(idCalon));
			  ts_calon.setNama(dfNamaCalon);
			  ts_calon.setNokp(df_nokp);
			  			  
			  TestCalonSek ts_calonSek = new TestCalonSek();
			  ts_calonSek.setTestCalonSek(new BigDecimal(idCalonSek));
			  ts_calonSek.setTestCalonId(new BigDecimal(idCalon));
			  ts_calonSek.setNoPelajar(df_noPelajar);
			  ts_calonSek.setTestSekolahPk(new BigDecimal(idSek));
			  
			  org.nc.MaklumatCalon.logic.MaklumatCalon newCalonLogic = new org.nc.MaklumatCalon.logic.MaklumatCalon();
			  newCalonLogic.PembaharuanMaklCalon(ts_calon, ts_calonSek);

			  MultivaluedMap<String, String> args = new MultivaluedMapImpl();
			  args.add("idCalonSek", ""+idCalonSek);
	          
	          //forwardToJsp(actionReq.getParameter("jspPage"), args, actionResponse, actionReq);
			  forwardToJsp("/html/Maklumat calon/maklumatCalon.jsp",args,actionResponse,actionReq);
			 }catch(Exception e){
			    SessionErrors.add(actionReq, "error");
			 }
		}
	
	public void PhapusanMaklumatCalon(ActionRequest actionReq, ActionResponse actionResponse){

		  try{
			  //warna biru nama variable dari form portlet 
			  String idCalonSek = actionReq.getParameter("idCalonSek");
			  // String examExamPk =actionReq.getParameter("examExamPk"); //dropdown jenis exam 
		      // String tahun =actionReq.getParameter("tahun");
		       
		      //delete			
			  if((idCalonSek!=null && !idCalonSek.equals(""))){
			  org.nc.MaklumatCalon.logic.MaklumatCalon newCalonLogic = new org.nc.MaklumatCalon.logic.MaklumatCalon();
			  newCalonLogic.PenghapusanCalon(new BigDecimal(idCalonSek));
			  }
	           	           
			  forwardToJsp("/html/Maklumat calon/senaraiCalon.jsp",actionResponse,actionReq);
			 }catch(Exception e){
			    SessionErrors.add(actionReq, "error");
			 }
		}

}
