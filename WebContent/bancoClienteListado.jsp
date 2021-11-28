<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entidad.Cuentas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="negocioImpl.CuentasNegocioImpl"%>
<%@page import="negocio.CuentasNegocio"%>
<%@page import="negocioImpl.TiposCuentaNegocioImpl"%>
<%@page import="entidad.TipoCuentas"%>
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
			<li class="page-item active" aria-current="page"><span class="page-link">Cliente Tipo de Cuenta </span></li>
			<li class="page-item"><a class="page-link" href="bancoListadoClienteEtario.jsp"> Cliente Rango Etario </a></li>		
		</ul>
		</nav> 
		
		  <h5>Tipo de Cuenta</h5>	
		  	<form class="formBusqueda" action="servletBancoClienteListado" method="get">	  
					<div class="form-row">
						 <div class="col-md mb"> 
				  	<input class="btn btn-outline-primary" type="submit" value="Buscar" name="btnBuscar">
				  	<a class="btn btn-outline-primary" href="bancoClienteListado.jsp" >Limpiar</a>	
				  	<br></br>			  	 
				  </div> 
							<div class="col-md-3 mb-3">
								<select name="TipoCuenta" >
									<%
										TiposCuentaNegocioImpl tp = new TiposCuentaNegocioImpl();
										ArrayList<TipoCuentas> Listatp =tp.readAll();
										if(Listatp!=null)
										{
										  for(TipoCuentas List:Listatp)
										  {
												%><option value="<%=List.getId()%>"><%=List.getDescripcion() %> </option><%											
																								  }
										}
										%> 
										</select>
							</div>					
					</div>
			 </form>
			 
			 
			<div class="container table-responsive-md">

	<%
		CuentasNegocio CtaN = new CuentasNegocioImpl();
		ArrayList<Cuentas> ListaC = null;  
		ListaC = CtaN.readAll();
		
		CuentasNegocio FiltroTC = new CuentasNegocioImpl();
		ArrayList<Cuentas> Filtro =  null;		
		HttpSession sessionUsuario = request.getSession();
		int dato=0;
		
		if(sessionUsuario.getAttribute("tc") != null ){ 
			dato = Integer.parseInt(sessionUsuario.getAttribute("tc").toString());
			Filtro= FiltroTC.TC(dato);
		} 		  
		sessionUsuario.invalidate();
		
	if (Filtro != null) {
	%>

	<table id="table1" class="display table table-sm table-hover table-bordered">
		<thead class="thead-dark">
			<tr>
				<th scope="col">N° Cuenta</th>
				<th scope="col">DNI</th>
				<th scope="col">Apellido</th>
				<th scope="col">Nombre</th>
				<th scope="col">Tipo Cuenta</th>
				
			</tr>
		</thead>
		<tbody> 
			<tr>
					<% for (Cuentas Lista : Filtro) {
				%> 
				<td><%=Lista.getNumeroCuenta()%></td>
				<td><%=Lista.getDniCliente().getDni() %></td>
				<td><%=Lista.getDniCliente().getApellido() %></td>
				<td><%=Lista.getDniCliente().getNombre() %></td>
				<td><%=Lista.getTipoCuenta().getDescripcion() %></td>
				
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
						<th scope="col">N° Cuenta</th>
						<th scope="col">DNI</th>
					    <th scope="col">Apellido</th>
						<th scope="col">Nombre</th>
						<th scope="col">Tipo Cuenta</th>
						
					</tr>
				</thead>
				<tbody> 
					<tr>
						<% for (Cuentas ListaF : ListaC) {
						%> 
						<td><%=ListaF.getNumeroCuenta()%></td>
						<td><%=ListaF.getDniCliente().getDni() %></td>
						<td><%=ListaF.getDniCliente().getApellido() %></td>
						<td><%=ListaF.getDniCliente().getNombre() %></td>
						<td><%=ListaF.getTipoCuenta().getDescripcion() %></td>
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
			  
		