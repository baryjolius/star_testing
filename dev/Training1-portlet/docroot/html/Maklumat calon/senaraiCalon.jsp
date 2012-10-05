<%@include file="senaraiCalon_ext.jsp" %>
 
<form id="form" name="form" data-role="validated-form" method="post" action="<%=senaraiCalon %>">
<input type="hidden" id="idCalonSek" name="idCalonSek" value=""/>

<div id="tabs" name="tabs" class="ui-tabs ui-widget ui-widget-content ui-corner-all">
		<ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
			<li class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
				<a href="#tabpanel">Tab3</a>
			</li>
			<li class="ui-state-default ui-corner-top">
				<a href="#">Tab2</a>
			</li>
			<li class="ui-state-default ui-corner-top">
				<a href="#">Tab3</a>
			</li>
		</ul>
		
		<div id="tabpanel" class="ui-tabs-panel ui-widget-content ui-corner-bottom">
			<!-- Content goes here -->
			<div class="aui-layout-content">
			<div class="aui-column aui-w50 aui-column-first">
				<div class="aui-column-content">
					<fieldset>
						<table>
						<tr>
						<td>Nama</td>
						<td>:</td>
						<td><input type="text" name="namaCalon" value=""/></td>
						</tr>
						</table>
	                </fieldset>
                </div>
			</div>
			
			<div class="aui-column aui-w50 aui-column-first">
				<div class="aui-column-content">
					<fieldset>
						<!-- content for column 2 -->
	                </fieldset>
                </div>
			</div>
		</div>		
		
		<div class="form-button-bar">
			<button type="submit">Cari</button>
		</div>
		
		<!-- Resultset-Table -->
<div class="pane-container">
	<!-- Title -->
    <div class="pane-container-header"> <label>Senarai Calon Sekolah</label></div>
    <!-- Content -->
    <div class="pane-container-body">
		<table data-role="resultset">
			<thead>
				<tr class="data-row-header">
					<th class="header-column-first">Bil</th>
					<th class="header-column-mid left">Nama</th>
					<th class="header-column-mid left">No IC</th>
					<th class="header-column-mid">Sekolah</th>
					<th class="header-column-last right">Tindakan</th>
				</tr>
			</thead>
			<tbody> 
				<%
				int i=1;
				for(String[] item:maklCalon.senaraiCalonSekolah(nama)){ 
				%>
				<tr>
					<td><%=i++ %></td>
					<td><%=item[3] %></td>
					<td><a href="javascript:toMaklumatCalon('<%=item[5]%>')"><u><%=item[4] %></u></a></td>
					<td><%=item[2] %></td>
					<td>
					<input type="button" name="kemaskini" value="kemaskini" onclick="toPenmbaharuanCalon('<%=item[5]%>')"/> 
					<input type="button" name="delete" value="delete"  onclick="penghapusanMaklCalon('<%=item[5]%>')"/> 
					</td>
				</tr>
				<%} %>
			</tbody>
		</table>
    </div>
    <!-- Footer -->
    <div class="pane-container-footer">
    	<span class="pane-container-footer-column right-vertical-divider"> <label>saiz:</label> 
    	<select> <option>10</option> <option>30</option> </select></span> 
    	<span class="pane-container-footer-column"> <label>ms:</label> <input type="text" id="ms" 
    	name="ms" value="1" size="2"></span>
    </div>
</div>
		
		<hr>
		<div class="form-button-bar">
			<button type="button" onclick="penyediaanCalon()">Tambah</button>
		</div>
		</div>
	</div>

		
	</form>