<%@page import="negocioImpl.RolNegocioImpl"%>
<%@page import="negocioImpl.NacionalidadNegocioImpl"%> 
<%@page import="entidad.Rol"%> 
<%@page import="entidad.Nacionalidad"%> 
<%@page import="java.util.ArrayList"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Usuario</title>
</head>
<body>

<%@ page errorPage="errorBanco.jsp"%>
<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterBanco.jsp"></jsp:include>	
		</div>		
		<div class="col">			  
		<h4>Alta Usuario</h4>	
			<div class=".container-sm" style="width: 90%">
			 
				<form action="servletBancoAltaCliente" method="post">
				
				  <div class="form-row">
				    <div class="col-md mb">
				      <label for="Nombre">Nombre</label>
				      <input type="text" class="form-control" name="Nombre" placeholder="Nombre" required>
				    </div>
				    <div class="col-md mb-3">
				      <label for="Apellido">Apellido</label>
				      <input type="text" class="form-control" name="Apellido" placeholder="Apellido" required>
				    </div>
				  </div>
				  
				  <div class="form-row">
				     <div class="col-md-3 mb-3">
				      <label for="FechaNacimiento">Fecha Nacimiento</label>
				      <input type="text"  class="form-control" name="FechaNacimiento" placeholder="YYYY/MM/DD" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Apellido">DNI</label>
				      <input type="text" class="form-control" name="DNI" placeholder="DNI" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Apellido">CUIL</label>
				      <input type="text" class="form-control" name="CUIL" placeholder="CUIL - Entre 7 y 11 carateres" required>
				    </div>
				  </div>
				  
				  
				  <div class="form-row">
				    <div class="col-md-5mb">
				      <label for="Direccion">Direccion</label>
				      <input type="text" class="form-control" name="Direccion" placeholder="Direccion" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Localidad">Localidad</label>
				      <input type="text" class="form-control" name="Localidad" placeholder="Localidad" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Provincia">Provincia</label>
				      <input type="text" class="form-control" name="Provincia" placeholder="Provincia" required>
				    </div>   
					<div class="col-md-3 mb-3">
					   <label for="Nacionalidad">Nacionalidad</label> 
					   <select name="Nacionalidad"> 
						   <%	NacionalidadNegocioImpl Nac = new NacionalidadNegocioImpl();
					 			ArrayList<Nacionalidad> ListaN =  Nac.readAll();
								if(Nac != null)
								{
									for(Nacionalidad nacLista : ListaN){
								       %><option value="<%=nacLista.getId() %>"><%=nacLista.getNacionalidad() %> </option><%
								       }		
								}			
							%> 
						</select>
					</div>	    
				</div>
				    
				  <div class="form-row">
				    <div class="col-md-4 mb">
				      <label for="Telefono">Telefono</label>
				      <input type="text" class="form-control" name="Telefono" placeholder="Telefono" required>
				    </div>
				    <div class="col-md-4 mb-3">
				      <label for="Email">Email</label>
				      <input type="email" class="form-control" name="Email" placeholder="Email" required>
				    </div>
					<div class="col-md-3 mb-3">
					   <label for="Rol">Rol</label> 
					   <br>
					   <select name="Rol" > 
						   <%	RolNegocioImpl Rol = new RolNegocioImpl();
					 			ArrayList<Rol> ListaRol =  Rol.readAll();
								if(ListaRol != null)
								{
									for(Rol List : ListaRol){
								       %><option value="<%=List.getId() %>"><%=List.getDescripcion() %> </option><%
								       }		
								}			
							%> 
						</select>
					</div>		
					</div>		
				  
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="radio" name="Sexo" id="Masculino" value="Masculino" required>
				      <label class="form-check-label" for="Masculino">Masculino</label> 
				      <br> 
				      <input class="form-check-input" type="radio" name="Sexo" id="Femenino" value="Femenino" required>
				      <label class="form-check-label" for="Femenino">Femenino</label> 
				    </div>
				  </div> 
				  
					<input class="btn btn-outline-primary" type="submit" value="Aceptar" name="btnAceptar">
					<a class="btn btn-outline-primary" href="bancoAltaCliente.jsp" name="btnCancelar">Cancelar</a>
				</form>
			</div>  
		</div>		
	</div>	
</div>




	
	
	
	
</body>
</html>