<%@page import="java.util.ArrayList"%>   
<%@page import="entidad.Telefonos"%>
<%@page import="entidad.Usuario"%>
<%@page import="entidad.DatosPersonales"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Usuario</title>
</head>
<body>
<%@ page errorPage="errorBanco.jsp" %> 
 
<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterBanco.jsp"></jsp:include>	
		</div>		
		<div class="col">			  
		<h4>Modificar Usuario</h4>	
			<div class=".container-sm" style="width: 90%">
			
				<form action="servletBancoModificacionCliente" method= "get" class="formBusqueda" style="display:flex;" > 
	                 <div class="col-md-3 mb-3"> 
	               		<input type="text" class="form-control" placeholder="DNI"  name= "DNICliente" required>
				     </div>
				     <div class="col-md-3 mb-3"> 
	               		<input type="text" class="form-control" placeholder="Nombre Cliente"  name= "NombreCliente" required>
				    </div>
				     <div class="col-md-3 mb-3"> 
	               	<input type="submit" class="btn btn-outline-primary" value="Buscar" name="btnBuscar" style="margin-left: 10px;">
				    </div>
                </form>
			 
				<form action="servletBancoModificacionCliente" method="post" class="mb-3">  
				<%
					DatosPersonales dpMod = new DatosPersonales();
					Usuario uMod = new Usuario();
					Telefonos tMod = new Telefonos();

					if (request.getAttribute("DatosPersonales") != null) {
						dpMod = (DatosPersonales) request.getAttribute("DatosPersonales");
					}

					if (request.getAttribute("Usuario") != null) {
						uMod = (Usuario) request.getAttribute("Usuario");
					}
					
					if (request.getAttribute("Telefono") != null) {
						tMod = (Telefonos) request.getAttribute("Telefono");
					} 
				%>
				
				  <div class="form-row">
				    <div class="col-md mb-3">
				      <label for="Nombre">Nombre</label>
				      <input type="text" class="form-control" name="Nombre" placeholder="Nombre" value="<%=dpMod.getNombre() %>" required>
				    </div>
				    <div class="col-md mb-3">
				      <label for="Apellido">Apellido</label>
				      <input type="text" class="form-control" name="Apellido" placeholder="Apellido" value="<%=dpMod.getApellido() %>" required>
				    </div>
				  </div>
				  <div class="form-row">
				     <div class="col-md-3 mb-3">
				      <label for="FechaNacimiento">Fecha Nacimiento</label>
				      <input type="text"  class="form-control" name="FechaNacimiento" placeholder="YYYY/MM/DD" value="<%=dpMod.getFechaNacimiento() %>" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Apellido">DNI</label>
				      <input type="text" class="form-control" name="DNI" placeholder="DNI" value="<%=dpMod.getDni() %>" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Apellido">CUIL</label>
				      <input type="text" class="form-control" name="CUIL" placeholder="CUIL" value="<%=dpMod.getCuil() %>" required>
				    </div>
				  </div>
				  
				  
				  <div class="form-row">
				    <div class="col-md-5mb">
				      <label for="Direccion">Direccion</label>
				      <input type="text" class="form-control" name="Direccion" placeholder="Direccion" value="<%=dpMod.getDireccion() %>" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Localidad">Localidad</label>
				      <input type="text" class="form-control" name="Localidad" placeholder="Localidad" value="<%=dpMod.getLocalidad() %>" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Provincia">Provincia</label>
				      <input type="text" class="form-control" name="Provincia" placeholder="Provincia" value="<%=dpMod.getProvincia() %>" required>
				    </div>   
				</div>
				    
				  <div class="form-row">
				    <div class="col-md-4 mb">
				      <label for="Telefono">Telefono</label>
				      
					 <input type="hidden" class="form-control" name="idtel" value="<%=tMod.getId() %>">
				      <input type="text" class="form-control" name="Telefono" placeholder="Telefono" value="<%=tMod.getNumero() %>" required>
				    </div>
				    <div class="col-md-4 mb-3">
				      <label for="Email">Email</label>
				      <input type="email" class="form-control" name="Email" placeholder="Email" value="<%=dpMod.getMail() %>" required>
				    </div> 
				</div>		 
					
					<% HttpSession sesionPass = request.getSession();
			    	   sesionPass.setAttribute("pass", uMod.getContraseña());
			    	   sesionPass.setAttribute("passUsuairo", uMod.getNombreUsuario());
					%> 
					
					<input class="btn btn-outline-primary" type="submit" value="Aceptar" name="btnAceptar">
					<a class="btn btn-outline-primary" href="bancoModificarCliente.jsp" name="btnCancelar">Cancelar</a>
				
					<a class="btn btn-outline-primary" href="bancoGestionPassModificacion.jsp" role="button">Constraseña</a> 
				</form>
				 
			</div>  
		</div>		
	</div>	
</div>




	
	
	
	
</body>
</html>