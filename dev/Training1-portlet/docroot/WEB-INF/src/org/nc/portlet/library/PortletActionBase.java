package org.nc.portlet.library;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.nc.ws.restful.RestfulBase;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class PortletActionBase extends MVCPortlet {
	public boolean forwardToJsp(String jspPage, ActionResponse response, ActionRequest request) {
		boolean success =true ;
		String portletName;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		portletName=(String) request.getAttribute(WebKeys.PORTLET_ID);
		PortletURL portletURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request),
										portletName,
										themeDisplay.getLayout().getPlid(),
										PortletRequest.RENDER_PHASE);
	 
		try {
			portletURL.setWindowState(WindowState.NORMAL);
		} catch (WindowStateException e) {
			//log.error(e);
			return success=false ;
		}
		
		portletURL.setParameter("jspPage",jspPage);
		try {
			response.sendRedirect(portletURL.toString());
		} catch (IOException e) {
			//logger.error(e);
			return success=false ;
		}
		
		return success ;
	}
	
	public boolean forwardToJsp(String jspPage, MultivaluedMap<String, String> args, ActionResponse response, ActionRequest request) {
		boolean success =true ;
		String portletName;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		portletName=(String) request.getAttribute(WebKeys.PORTLET_ID);
		PortletURL portletURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request),
										portletName,
										themeDisplay.getLayout().getPlid(),
										PortletRequest.RENDER_PHASE);
	 
		try {
			portletURL.setWindowState(WindowState.NORMAL);
		} catch (WindowStateException e) {
			//log.error(e);
			return success=false ;
		}
		
		portletURL.setParameter("jspPage",jspPage);
		for(Iterator<String> keyIterator = args.keySet().iterator(); keyIterator.hasNext();){
			String keyId = (String) keyIterator.next();
			for(Object value : (List<String>) args.get(keyId)) {
				portletURL.setParameter(keyId,(String)value);
			}
		}
		
		try {
			response.sendRedirect(portletURL.toString());
		} catch (IOException e) {
			//logger.error(e);
			return success=false ;
		}
		
		return success ;
	}
	
	public JsonNode toJsonNode(RestfulBase base){
		JsonNode json = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			json = mapper.readValue(base.getResponseString(), JsonNode.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return json;
	}
}
