<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.DatosPersonales"%>
<%@page import="negocioImpl.DatosPersonalesNegocioImpl"%>
<%@page import="negocio.DatosPersonalesNegocio" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informes</title>


<script type="text/javascript"	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript"	src=" https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"	defer></script>
<script type="text/javascript"	src=" https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"	defer></script>

<script type="text/javascript"	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"	defer></script>
<script type="text/javascript"	src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/pdfmake.min.js"	defer></script>
<script type="text/javascript"	src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/vfs_fonts.js"	defer></script>
<script type="text/javascript"	src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"	defer></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.1/js/buttons.print.min.js" defer></script>

<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css"></link>
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css"></link>

<script type="text/javascript">
	$(document).ready(function() {
		$('#table1').DataTable();
	});
</script>
</head>
<body> 
<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterBanco.jsp"></jsp:include>	
		</div>		
		<div class="col">	 

		  <h4>Informes</h4>	
		  <br>	 
		<nav aria-label="Page navigation example">
		<ul class="pagination pagination-sm">
			<li class="page-item"><a class="page-link" href="bancoInformes.jsp"> Movimientos </a></li>
			<li class="page-item"><a class="page-link" href="bancoInformesPrestamos.jsp"> Prestamos </a></li>
			<li class="page-item"><a class="page-link" href="bancoClienteListado.jsp">Cliente Tipo de Cuenta </a></li>
			<li class="page-item active" aria-current="page"><span class="page-link">Cliente Rango Etario </span></li>
		</ul>
		</nav> 
		
		  <h5>Desde - Hasta</h5>	
		  	<form class="formBusqueda" action="servletBancoListadoClienteEtario" method="get">	  
				<div class="form-row">
				  <div class="col-md mb"> 
				    <input type="date" class="form-control" name="Desde" placeholder="yyyy/mm/dd" required>
				  </div>
				  <div class="col-md mb-3"> 
				    <input type="date" class="form-control" name="Hasta" placeholder="yyyy/mm/dd" required>
				  </div> 
				  <div class="col-md mb-5"> 
				  	<input class="btn btn-outline-primary" type="submit" value="Buscar" name="btnBuscar">
				  	<a class="btn btn-outline-primary" href="bancoListadoClienteEtario.jsp" >Limpiar</a>				  	 
				  </div> 
				</div>
			</form>  
						
<div class="container table-responsive-md">

	<%
		DatosPersonalesNegocio DPN = new DatosPersonalesNegocioImpl();
		ArrayList<DatosPersonales> ListaDP = null;  
		ListaDP = DPN.readAll();
		
		DatosPersonalesNegocio FN = new DatosPersonalesNegocioImpl();
		ArrayList<DatosPersonales> Filtro =  null;		
		HttpSession sessionUsuario = request.getSession();

		if(sessionUsuario.getAttribute("desde") != null  && sessionUsuario.getAttribute("hasta") != null){ 
			Filtro = FN.Fechas(sessionUsuario.getAttribute("desde").toString(), sessionUsuario.getAttribute("hasta").toString());

			} 		  
		sessionUsuario.invalidate();
		
	if (Filtro != null) {
	%>

	<table id="table1" class="display table table-sm table-hover table-bordered">
		<thead class="thead-dark">
			<tr>
				<th scope="col">DNI</th>
						<th scope="col">Apellido</th>
						<th scope="col">Nombre</th>
						<th scope="col">Sexo</th>
						<th scope="col">FechaNacimiento</th>
						<th scope="col">Mail</th>
			</tr>
		</thead>
		<tbody> 
			<tr>
			<% for (DatosPersonales Lista : Filtro) {%> 
				<td><%=Lista.getDni() %></td>				
				<td><%=Lista.getApellido() %></td>				
				<td><%=Lista.getNombre() %></td>
				<td><%=Lista.getSexo() %></td>
				<td><%=Lista.getFechaNacimiento()%></td>
				<td><%=Lista.getMail() %></td>	
			</tr>			
			<%}%></tbody>
			<%}else{
			%>
		</tbody>
	</table>
		<% 	
			%>

			<table id="table1" class="display table table-sm table-hover table-bordered">
				<thead class="thead-dark">
					<tr>
						<th scope="col">DNI</th>
						<th scope="col">Apellido</th>
						<th scope="col">Nombre</th>
						<th scope="col">Sexo</th>
						<th scope="col">FechaNacimiento</th>
						<th scope="col">Mail</th>
				
					</tr>
				</thead>
				<tbody> 
					<tr>
						<% for (DatosPersonales ListaA : ListaDP) {
						%> 
						<td><%=ListaA.getDni() %></td>				
						<td><%=ListaA.getApellido() %></td>				
						<td><%=ListaA.getNombre() %></td>
						<td><%=ListaA.getSexo() %></td>
						<td><%=ListaA.getFechaNacimiento()%></td>
						<td><%=ListaA.getMail() %></td>						
					</tr>
				</tbody>
				<%   
					}
			}
		%>
			</table>
			</div> 
			 
		</div>		
	</div>	
</div> 
</body>
</html>