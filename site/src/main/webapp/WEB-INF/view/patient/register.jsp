<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-md-12">
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-md-4 control-label" for="name">Nome</label>
				<div class="col-md-4">
					<input id="name" name="name" type="text" class="form-control input-md" required> 
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="rg">RG</label>
				<div class="col-md-4">
					<input id="rg" name="rg" type="text" class="form-control input-md"> 
				</div>
			</div>
			
			<div class="form-group" id="photoDisplay" style="display: none;" align="center">
			  	<video id="video" width="200" height="200" style="margin: 10px;"></video>
				<canvas id="canvas" width="200" height="200"></canvas>
			</div>
		</form>
	</div>
</div>


