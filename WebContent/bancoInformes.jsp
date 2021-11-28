<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entidad.Movimientos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="negocioImpl.MovimientosNegocioImpl"%>
<%@page import="negocio.MovimientosNegocio"%>
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
			<li class="page-item active" aria-current="page"><span class="page-link"> Movimientos</span></li>
			<li class="page-item"><a class="page-link" href="bancoInformesPrestamos.jsp"> Prestamos </a></li>
			<li class="page-item"><a class="page-link" href="bancoClienteListado.jsp">Cliente Tipo de Cuenta </a></li>
			<li class="page-item"><a class="page-link" href="bancoListadoClienteEtario.jsp"> Cliente Rango Etario </a></li>
		</ul>
		</nav> 
		
		  <h5>Desde - Hasta</h5>	
		  	<form class="formBusqueda" action="servletBancoReporte" method="get">	  
				<div class="form-row">
				  <div class="col-md mb"> 
				    <input type="date" class="form-control" name="Desde" placeholder="yyyy/mm/dd" required>
				  </div>
				  <div class="col-md mb-3"> 
				    <input type="date" class="form-control" name="Hasta" placeholder="yyyy/mm/dd" required>
				  </div> 
				  <div class="col-md mb-5"> 
				  	<input class="btn btn-outline-primary" type="submit" value="Buscar" name="btnBuscar">
				  	<a class="btn btn-outline-primary" href="bancoInformes.jsp" >Limpiar</a>				  	 
				  </div> 
				</div>
			</form>  
						
<div class="container table-responsive-md">

	<%
		MovimientosNegocio MovN = new MovimientosNegocioImpl();
		ArrayList<Movimientos> ListaMov = null;  
		ListaMov = MovN.readAll();
		
		MovimientosNegocio MovFiltroFecha = new MovimientosNegocioImpl();
		ArrayList<Movimientos> MovFiltro =  null;		
		HttpSession sessionUsuario = request.getSession();

		if(sessionUsuario.getAttribute("desde") != null  && sessionUsuario.getAttribute("hasta") != null){ 
			MovFiltro = MovFiltroFecha.FiltroFechas(sessionUsuario.getAttribute("desde").toString(), sessionUsuario.getAttribute("hasta").toString());	
		} 		  
		sessionUsuario.invalidate();
		
	if (MovFiltro != null) {
	%>

	<table id="table1" class="display table table-sm table-hover table-bordered">
		<thead class="thead-dark">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">DNI</th>
				<th scope="col">Numero cuenta</th>
				<th scope="col">Tipo cuenta</th>
				<th scope="col">Detalle</th>
				<th scope="col">Fecha</th>
				<th scope="col">Importe</th>
				<th scope="col">Movimiento</th> 
			</tr>
		</thead>
		<tbody> 
			<tr>
					<% for (Movimientos Lista : MovFiltro) {
				%> 
				<td><%=Lista.getId() %></td>
				<td><%=Lista.getCuenta().getDniCliente().getDni() %></td>				
				<td><%=Lista.getCuenta().getNumeroCuenta() %></td>				
				<td><%=Lista.getCuenta().getTipoCuenta().getDescripcion() %></td>
				<td><%=Lista.getDetalle() %></td>
				<td><%=Lista.getFecha() %></td>
				<td><%=Lista.getImporte() %></td>
				<td><%=Lista.getTipoMovimiento().getDescripcion() %></td>
			</tr>
			
			<%   
					}%></tbody> <%
				}else{
			%>
		</tbody>
	</table>
		<% 	
			%>

			<table id="table1" class="display table table-sm table-hover table-bordered">
				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">DNI</th>
						<th scope="col">Numero cuenta</th>
						<th scope="col">Tipo cuenta</th>
						<th scope="col">Detalle</th>
						<th scope="col">Fecha</th>
						<th scope="col">Importe</th>
						<th scope="col">Movimiento</th> 
					</tr>
				</thead>
				<tbody> 
					<tr>
						<% for (Movimientos Lista : ListaMov) {
						%> 
						<td><%=Lista.getId() %></td>
						<td><%=Lista.getCuenta().getDniCliente().getDni() %></td>				
						<td><%=Lista.getCuenta().getNumeroCuenta() %></td>				
						<td><%=Lista.getCuenta().getTipoCuenta().getDescripcion() %></td>
						<td><%=Lista.getDetalle() %></td>
						<td><%=Lista.getFecha() %></td>
						<td><%=Lista.getImporte() %></td>
						<td><%=Lista.getTipoMovimiento().getDescripcion() %></td>
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