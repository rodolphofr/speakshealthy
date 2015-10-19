<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/imports.jsp"%>
<%@ attribute name="title" required="true" rtexprvalue="true"
	type="java.lang.String"%>
	
<div align="center">
	<div class="col-xs-6 col-md-3 thumbnail" style="margin-right:10px;">
		<h3>${title}</h3><br>
		
		<div class="form-group">
		  	<input id="new" class="form-control" placeholder="Conteúdo" required>
		</div>
		
		<div id="record-audio">
			<audio id="audioExpert" autoplay controls style="width: 46px;"></audio>
		</div>
		
		<button id="btnRecord" type="button" class="btn btn-danger" style="margin: 10px;" data-status="deactivated">
		 	 <span class="glyphicon glyphicon-record"></span>
		</button> 
		
		<button id="btnSave" type="button" class="btn btn-primary" >
		 	 <span class="glyphicon glyphicon-floppy-disk"></span>
		</button>
		
		<input type="hidden" id="phoneme" value=""/>
		
	</div>
</div>