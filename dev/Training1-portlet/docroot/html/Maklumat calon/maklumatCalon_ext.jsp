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
String idCalonSek = request.getParameter("idCalonSek");
System.out.println("idCalonSek : "+idCalonSek);
MaklumatCalon maklCalon = new MaklumatCalon();
String[] calon = maklCalon.maklumatCalonSekolah(idCalonSek);
 
%>

<portlet:renderURL var="senaraiCalon">
<portlet:param name="jspPage" value="/html/Maklumat calon/senaraiCalon.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="penyediaanCalon">
<portlet:param name="jspPage" value="/html/Maklumat calon/kemasukanMaklumat.jsp"></portlet:param>
</portlet:renderURL>

<script>
function toSenaraiCalon(){
	document.getElementsByTagName("form")[0].action = "<%=senaraiCalon%>";
	document.form.submit();	
}

</script>