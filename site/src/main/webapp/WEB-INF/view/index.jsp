<%@ include file="/WEB-INF/imports.jsp"%>
<!DOCTYPE html>
<html lang="pt">
 <head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta name="description" content="">
   <meta name="author" content="">
   <link rel="icon" href="../../favicon.ico">

   <title>Login</title>

   	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
   	<link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
   	
	<script type="text/javascript" charset="utf8" src='<c:url value="/resources/js/jquery.js"/>'/></script>
   	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootbox.min.js"/>"></script>
	<script type="text/javascript" charset="utf8" src="<c:url value='/resources/js/expert.js'/>"></script>
	
	<style type="text/css">
	.margin {
		margin: 10px;
	}
	
	.center {
		text-align: center;
	}
	</style>    
 </head>
 <body>
 <div class="col-xs-6 col-md-4" align="center"></div>
    <div class="col-xs-6 col-md-4" align="center">
        <h2 class="form-signin-heading">Bem Vindo ao <font color="gray">Speaks</font><font color="bluecian">Healthy</font></h2>
        <hr>
        <p align="left" class="help-block" style="font-size: 1.2em; font-weight: bold; padding-left: 10px;">
        	Entre com CRFa
        </p>
        <select class="form-control margin" id="select">
        	<option>Selecione a Região</option>
        	<option value="1">1° Região</option>
        	<option value="2">2° Região</option>
        	<option value="3">3° Região</option>
        	<option value="4">4° Região</option>
        	<option value="5">5° Região</option>
        	<option value="6">6° Região</option>
        	<option value="7">7° Região</option>
        	<option value="8">8° Região</option>
        </select>
        <input type="password" id="register" class="form-control margin" placeholder="Número de Registro" required autofocus>
        <button class="btn btn-lg btn-primary btn-block margin" id="submit">Entrar</button>
    </div> 
  </body>
</html>
