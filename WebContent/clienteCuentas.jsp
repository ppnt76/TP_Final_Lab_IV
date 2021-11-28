<%@page import="negocio.TiposCuentaNegocio"%>
<%@page import="entidad.Cuentas"%>
<%@page import="negocioImpl.CuentasNegocioImpl"%>
<%@page import="negocio.CuentasNegocio"%>
<%@page import="entidad.Movimientos"%>
<%@page import="entidad.TipoCuentas"%>
<%@page import="negocioImpl.TiposCuentaNegocioImpl"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page errorPage="errorCliente.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cuentas</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src=" https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"
	defer></script>
<script type="text/javascript"
	src=" https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"
	defer></script>

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"
	defer></script>
<script type="text/javascript"
	src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/pdfmake.min.js"
	defer></script>
<script type="text/javascript"
	src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/vfs_fonts.js"
	defer></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"
	defer></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.2.1/js/buttons.print.min.js"
	defer></script>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css"></link>
<link rel="stylesheet"
	href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css"></link>

<script type="text/javascript">
	$(document).ready(function() {
		$('#table1').DataTable();
	});
</script>
</head>
<body>
	<%
		HttpSession sessionUsuario = request.getSession();
		int dni = 0;

		if (sessionUsuario.getAttribute("SesionDNI") != null) {
			dni = Integer.parseInt(sessionUsuario.getAttribute("SesionDNI").toString());

		} else {
			response.sendRedirect("Login.jsp");
		}
	%>

	<div class=".container">
		<div class="row row-principal">
			<div class="col-2 col-menu">
				<jsp:include page="masterCliente.jsp"></jsp:include>
			</div>
			<div class="col">
				<div class="container table-responsive-md">
				
				
				
				
					<br>
					<h4>Últimos movimientos</h4>
					<%
						String tipoCuenta = "";
						String numCuenta = ""; 
						if (request.getAttribute("tipoCuenta") != null) {
							tipoCuenta = request.getAttribute("tipoCuenta").toString();
						}
						if (request.getAttribute("numCuenta") != null) {
							numCuenta = request.getAttribute("numCuenta").toString();
						} 
					%>
					 
					<div class="col-md-3 mb-3">
						 <div class="dropdown">
						<a class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Elegir cuenta </a>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">

							<%
							
							CuentasNegocio cNimpDesde = new CuentasNegocioImpl();
							ArrayList<Cuentas> ListCDesde = cNimpDesde.ListarCuentas(dni);
							
							TiposCuentaNegocio tip = new TiposCuentaNegocioImpl();
							ArrayList<TipoCuentas> Ltip = tip.readAll();
							try {
								if (ListCDesde != null) {
									for (Cuentas list : ListCDesde) {
							%>
							<a class="dropdown-item" href="servletClienteCuentas?idTipoCuenta=<%=list.getNumeroCuenta()%>"><%=list.getTipoCuenta().getDescripcion()%> - <%=list.getNumeroCuenta()%></a>
							<%
							}
							}
							} catch (Exception e) {
							}
							%>

						</div>
					</div>
					</div>
					<br>
					<%
						ArrayList<Movimientos> Lmov = null;
						if (request.getAttribute("Lmov") != null) {
							Lmov = (ArrayList<Movimientos>) request.getAttribute("Lmov");
					%>
					<div>
						<h5><%=tipoCuenta%>	n°:	<%=numCuenta%></h5> 
						<br>
						<table id="table1"
							class="table table-sm table-hover table-bordered">
							<thead>
								<tr>
									<th scope="col">Mov</th>
									<th scope="col">Detalle</th>
									<th scope="col">Fecha</th>
									<th scope="col">Monto</th>
									<th scope="col">Tipo</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<%
										for (Movimientos list : Lmov) {
											if(Integer.parseInt(numCuenta) == list.getCuenta().getNumeroCuenta()){
									%>  
									<th scope="row"><%=list.getId()%></th>
									<th scope="row"><%=list.getDetalle()%></th>
									<th scope="row"><%=list.getFecha()%></th>
									<th scope="row"><%=list.getImporte()%></th>
									<th scope="row"><%=list.getTipoMovimiento().getDescripcion()%></th>
								</tr>
								<%
											}
										}
								%>
							</tbody>
						</table> 
					</div>

					<%
						} else {
					%>
					<br>
					<h5>No posee cuentas asociadas</h5>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>