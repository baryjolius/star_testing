<%
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="java.io.PrintWriter"%>
<%@ page import="com.sun.jersey.api.representation.Form"%>
<%@ page import="javax.ws.rs.core.MediaType"%>
<%@ page import="javax.ws.rs.core.MultivaluedMap" %>
<%@ page import="com.sun.jersey.core.util.MultivaluedMapImpl" %>
<%@ page import="org.nc.ws.restful.GetHttpMethod"%>
<%@ page import="org.nc.ws.restful.PostHttpMethod"%>
<%@ page import="org.nc.ws.restful.PutHttpMethod"%>
<%@ page import="org.nc.ws.restful.DeleteHttpMethod"%>