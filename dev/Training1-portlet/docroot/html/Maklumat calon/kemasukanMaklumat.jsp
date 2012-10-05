<%@include file="kemasukanMaklumat_ext.jsp" %>

<form id="form" name="form" data-role="validated-form" method="post" action="<%=(idCalonSek.equals("0"))?PenyediaanMaklumatCalon:PembaharuanMaklumatCalon %>">
<input type="hidden" id="idCalonSek" name="idCalonSek" value="<%=idCalonSek %>"/>
<input type="hidden" id="idCalon" name="idCalon" value="<%=calon[1] %>"/>
<input type="hidden" id="idSek" name="idSek" value="<%=calon[2] %>"/>
		<div class="aui-layout-content">
			<div class="aui-column aui-w50 aui-column-first">
				<div class="aui-column-content">
					<fieldset>
						<!-- content for column 1 -->
						<div class="field-group">
							<label for="dfNamaCalon"><%=LanguageUtil.get(pageContext,"maklumatcalon-label-namaCalon") %>: </label>
							<input type="text" id="dfNamaCalon" name="dfNamaCalon" value="<%=calon[4] %>">
						</div>
						<div class="field-group">
							<label for="df_nokp">No. kad pengenalan: </label>
							<input type="text" id="df_nokp" name="df_nokp" value="<%=calon[5] %>" onkeyup="checkNokp(this)" size="14"/>
						</div> 
						<div class="field-group">
							<label for="df_noPelajar">No. pelajar : </label>
							<input type="text" id="df_noPelajar" name="df_noPelajar" value="<%=calon[3] %>" size="14" />
						</div>
	                </fieldset>
                </div>
			</div>
			
			<div class="aui-column aui-w50 aui-column-first">
				<div class="aui-column-content">
					<fieldset>
						<!-- content for column 2 -->
						<nce:combobox codeField="negeriKodPk" name="negeri" displayField="negeriNama" selectedItemByCode="<%=calon[7]%>">
							<nce:datasource jsonData="<%=negeri %>" />
						</nce:combobox>
						<nce:combobox codeField="testSekolahPk" name="sekolah" displayField="namaSekolah" selectedItemByCode="<%=calon[2]%>">
							<nce:datasource jsonData="<%=sekolah %>" />
						</nce:combobox>
	                </fieldset>
                </div>
			</div>
		</div>
		
		<hr>
		<div class="form-button-bar">
			<button type="submit"><%=LanguageUtil.get(pageContext,"form-button-save") %></button>
			<button type="button" onclick="history.go(-1);"><%=LanguageUtil.get(pageContext,"form-button-back") %></button>
		</div>
	</form>