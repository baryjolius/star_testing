<%@page import="org.nc.MaklumatCalon.logic.MaklumatCalon"%>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="org.codehaus.jackson.JsonNode"%>
<%@page import="java.util.List" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/init.jsp" %>


<% 
String idCalonSek = request.getParameter("idCalonSek");
System.out.println("idCalonSek....:"+idCalonSek);
MaklumatCalon maklCalon = new MaklumatCalon();
String[] calon = maklCalon.maklumatCalonSekolah(idCalonSek);


ObjectMapper mapper = new ObjectMapper();
JsonNode negeri =mapper.readValue(maklCalon.senaraiNegeri(),JsonNode.class);

JsonNode sekolah =mapper.readValue(maklCalon.senaraiSekolah(),JsonNode.class);
%>

<portlet:renderURL var="maklumatCalon">
<portlet:param name="jspPage" value="/html/Maklumat calon/maklumatCalon.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL var="PembaharuanMaklumatCalon" name="PembaharuanMaklumatCalon"/>

<portlet:actionURL var="PenyediaanMaklumatCalon" name="PenyediaanMaklumatCalon"/>

<script>
function toSubmitForm(){
	document.getElementsByTagName("form")[0].action = "<%=maklumatCalon%>";
	document.form.submit();		
}

function checkNokp(objectText){
	var value = objectText.value;
	
	if(value.length >= 12){
		
		
	}
	
}
</script>