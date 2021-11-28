<%@page import="entidad.Prestamos"%>
<%@page import="negocioImpl.PrestamosNegocioImpl"%>
<%@page import="negocio.PrestamosNegocio"%>
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
			<li class="page-item"><a class="page-link" href="bancoInformes.jsp"> Movimientos </a></li>
			<li class="page-item active" aria-current="page"><span class="page-link"> Prestamos</span></li>
			<li class="page-item"><a class="page-link" href="bancoClienteListado.jsp">Cliente Tipo de Cuenta </a></li>
			<li class="page-item"><a class="page-link" href="bancoListadoClienteEtario.jsp"> Cliente Rango Etario </a></li>
		</ul>
		</nav>		
		  <h5>Monto entre</h5>	
		  	<form class="formBusqueda" action="servletBancoInformesPrestamos" method="get">	  
				<div class="form-row">
				  <div class="col-md mb"> 
				    <input type="text" class="form-control" name="Desde" placeholder="desde" required>
				  </div>
				  <div class="col-md mb-3"> 
				    <input type="text" class="form-control" name="Hasta" placeholder="hasta" required>
				  </div> 
				  <div class="col-md mb-5"> 
				  	<input class="btn btn-outline-primary" type="submit" value="Buscar" name="btnBuscar">
				  	<a class="btn btn-outline-primary" href="bancoInformesPrestamos.jsp" >Limpiar</a>				  	 
				  </div> 
				</div>
			</form>  
						
<div class="container table-responsive-md">

	<%
		PrestamosNegocio PresN = new PrestamosNegocioImpl();
		ArrayList<Prestamos> ListaPres = null;  
		ListaPres = PresN.readAll();
		
		PrestamosNegocio PresNFiltro = new PrestamosNegocioImpl();
		ArrayList<Prestamos> ListaPresFiltro = null;   
			
		HttpSession sesionFiltroPres = request.getSession();

		if(sesionFiltroPres.getAttribute("desde") != null  && sesionFiltroPres.getAttribute("hasta") != null){ 
			ListaPresFiltro = PresNFiltro.FiltroMonto(sesionFiltroPres.getAttribute("desde").toString(), sesionFiltroPres.getAttribute("hasta").toString());
			
			System.out.println(ListaPresFiltro);
		} 		  
		
		sesionFiltroPres.invalidate();
		
	if (ListaPresFiltro != null) {
	%>

	<table id="table1" class="display table table-sm table-hover table-bordered">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Numero cuenta</th>
				<th scope="col">Tramite n°</th>
				<th scope="col">Imp. Total</th>
				<th scope="col">Imp. Cuota</th>
				<th scope="col">Cuotas Total</th>
				<th scope="col">Cuotas Paga</th> 
			</tr>
		</thead>
		<tbody> 
			<tr>
					<% for (Prestamos Lista : ListaPresFiltro) {
				%> 
				<td><%=Lista.getNumeroCuenta() %></td> 
				<td><%=Lista.getId() %></td> 
				<td><%=Lista.getImportePedidoTotal() %></td> 
				<td><%=Lista.getImporteCuota() %></td> 
				<td><%=Lista.getCuotasTotal() %></td> 
				<td><%=Lista.getCuotasPagas() %></td> 
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
					<th scope="col">Numero cuenta</th>
					<th scope="col">Tramite n°</th>
					<th scope="col">Imp. Total</th>
					<th scope="col">Imp. Cuota</th>
					<th scope="col">Cuotas Total</th>
					<th scope="col">Cuotas Paga</th> 
					</tr>
				</thead>
				<tbody> 
					<tr>
						<% for (Prestamos Lista : ListaPres) {
						%> 
						<td><%=Lista.getNumeroCuenta() %></td> 
						<td><%=Lista.getId() %></td> 
						<td><%=Lista.getImportePedidoTotal() %></td> 
						<td><%=Lista.getImporteCuota() %></td> 
						<td><%=Lista.getCuotasTotal() %></td> 
						<td><%=Lista.getCuotasPagas() %></td> 
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