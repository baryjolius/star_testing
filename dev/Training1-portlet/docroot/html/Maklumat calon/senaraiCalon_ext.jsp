<%@page import="org.nc.taglib.util.JsonNodeWrapper"%>
<%@page import="org.nc.ws.restful.PostHttpMethod"%>
<%@page import="com.sun.jersey.api.representation.Form"%>
<%@page import="org.nc.ws.restful.GetHttpMethod"%>
<%@page import="org.codehaus.jackson.JsonNode"%>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="javax.ws.rs.core.MediaType"%>
<%@page import="com.sun.jersey.core.util.MultivaluedMapImpl"%>
<%@page import="javax.ws.rs.core.MultivaluedMap"%>
<%@page import="org.nc.portal.ext.util.PropertiesReader"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="org.nc.ws.restful.ReaderWADL"%>
<%@page import="org.nc.MaklumatCalon.logic.*"%>
<%@ include file="/init.jsp" %>


<%
String nama = request.getParameter("namaCalon");

MaklumatCalon maklCalon = new MaklumatCalon();
//System.out.println("maklCalon :"+maklCalon.senaraiCalonSekolah(nama));

%>

<portlet:renderURL var="senaraiCalon">
<portlet:param name="jspPage" value="/html/Maklumat calon/senaraiCalon.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="maklumatCalon">
<portlet:param name="jspPage" value="/html/Maklumat calon/maklumatCalon.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="penyediaanCalon">
<portlet:param name="jspPage" value="/html/Maklumat calon/kemasukanMaklumat.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL var="hapusCalon" name="PhapusanMaklumatCalon"/>

<Script>
function toMaklumatCalon(_idCalonSek){
	document.getElementById("idCalonSek").value = _idCalonSek;
	document.getElementsByTagName("form")[0].action = "<%=maklumatCalon%>";
	document.form.submit();
}

function toPenmbaharuanCalon(_idCalonSek){
	document.getElementById("idCalonSek").value = _idCalonSek;
	document.getElementsByTagName("form")[0].action = "<%=penyediaanCalon%>";
	document.form.submit();
}

function penghapusanMaklCalon(_idCalonSek) {  	
		var message="Adakah Anda Pasti Untuk Simpan Maklumat Ini?"
			var displayPanel = '<p>' + message + '</p>';
			var $dialog = $('<div></div>')
			.html(displayPanel)
			.dialog({
				width:"300px",
				resizable: false,
				autoOpen: false,
				modal: true,
				title: 'Pengesahan',
				buttons: {
					"Ya": function(){					
						$(this).dialog("close");
						loading();	
						var $p = jQuery.noConflict();
						$p.post('<%=hapusCalon%>',{idCalonSek:_idCalonSek},
						function(response){			
							$p("form").submit();
							
						});
						
					},
					"Tidak": function(){
						$(this).dialog("close");
					}
				}
			});
	
			$dialog.dialog('open');
		
}

function penyediaanCalon(){
	document.getElementById("idCalonSek").value = 0;
	document.getElementsByTagName("form")[0].action = "<%=penyediaanCalon%>";
	document.form.submit();
}

</Script>