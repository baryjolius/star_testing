<%@include file="maklumatCalon_ext.jsp" %>

<form id="form" name="form" data-role="validated-form" method="post" action="<%=penyediaanCalon %>">
<input type="hidden" id="idCalonSek" name="idCalonSek" value="<%=idCalonSek %>"/>
		<div class="aui-layout-content">
			<div class="aui-column aui-w50 aui-column-first">
				<div class="aui-column-content">
					<fieldset>
						<div class="field-group">
							<label for="df_namaCalon">Nama : </label>
							<%=calon[4] %>
						</div>
						<div class="field-group">
							<label for="df_nokpCalon">No. kad pengenalan : </label>
							<%=calon[5] %>
						</div>						
						<div class="field-group">
							<label for="df_no_pelajar">No. pelajar : </label>
							<%=calon[3] %>
						</div>
	                </fieldset>
                </div>
			</div>
			
			<div class="aui-column aui-w50 aui-column-first">
				<div class="aui-column-content">
					<fieldset>
						<!-- content for column 2 -->
						<div class="field-group">
							<label for="optLabel">Negeri : </label>
							<%=calon[7] %>
						</div>  
						<div class="field-group">
							<label for="df_Sekolah">Sekolah : </label>
							<%=calon[8] %>
						</div>
	                </fieldset>
                </div>
			</div>
		</div>
		
		<hr>
		<div class="form-button-bar">
			<button type="submit">Kemaskini</button>
			<button type="button" onclick="toSenaraiCalon()">Kembali</button>
		</div>
	</form>