<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Baja Usuario</title>
</head>
<body>
<%@ page errorPage="errorBanco.jsp" %> 

<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterBanco.jsp"></jsp:include>	
		</div>		
		<div class="col">		 
		<h4>Baja Usuario</h4> 
			<div class=".container-sm" style="width: 90%"> 
			
				<form action="serveltBancoBajaCliente" method="get"> 
				  <div class="form-row">
				    <div class="col-md mb">
				      <label for="Usuario">Usuario</label>
				      <input type="text" class="form-control" name="Usuariobaja" placeholder="Usuario" required>
				    </div>
				    <div class="col-md mb-3">
				      <label for="DNI">DNI</label>
				      <input type="text" class="form-control" name="DNIbaja" placeholder="DNI" required>
				    </div>
				  </div>     
					<input class="btn btn-outline-primary" type="submit" value="Aceptar" name="btnAceptar">
					<a class="btn btn-outline-primary" href="bancoBajaCliente.jsp" name="btnCancelar">Cancelar</a>
				</form>
			</div> 	 
		</div>		
	</div>	
</div>


</body>
</html>