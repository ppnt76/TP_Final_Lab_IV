<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Usuario"%>
<%@page import="entidad.Rol"%>
<%@page import="negocio.UsuarioNegocio"%>
<%@page import="negocioImpl.UsuarioNegocioImpl"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page errorPage="errorBanco.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes del banco</title>

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
	<div class=".container">

		<div class="row row-principal">
			<div class="col-2 col-menu">
				<jsp:include page="masterBanco.jsp"></jsp:include>
			</div>
			<div class="col">
				<h4>Clientes</h4>

				<div class="container table-responsive-md">

					<%
						UsuarioNegocio usuarioN = new UsuarioNegocioImpl();
						ArrayList<Usuario> listaUsuarios = null;
						listaUsuarios = usuarioN.readAll();
					%>
					<h6></h6>
					<%
						if (listaUsuarios != null) {
					%>

					<br>

					<table id="table1"
						class="display table table-sm table-hover table-bordered">
						<thead class="thead-dark">
							<tr>
								<th scope="col">DNI</th>
								<th scope="col">Apellido</th>
								<th scope="col">Nombre</th>
								<th scope="col">Usuario</th>
								<!--<th scope="col">Cuentas</th>
								<th scope="col">Prestamos</th>  -->
							</tr>
						</thead>
						<tbody>
							<tr>
								<%
									for (Usuario usuario : listaUsuarios) {
											if (usuario.getRol().getId() == 2) {
								%>
								<td><%=usuario.getdp_DNI().getDni()%></td>
								<td><%=usuario.getdp_DNI().getApellido()%></td>
								<td><%=usuario.getdp_DNI().getNombre()%></td>
								<td><%=usuario.getNombreUsuario()%></td>
								<!--<td>
									<button type="button" class="btn btn-outline-primary"
										name="btnGestionar" style="margin-left: 10px;">Cuentas</button>
								</td>
								<td>
									<button type="button" class="btn btn-outline-primary"
										name="btnGestionar" style="margin-left: 10px;">Prestamos</button>
								</td>  -->
							</tr>
							<%
								}
									}
								}
							%>
						</tbody>
					</table>
				</div>


			</div>
		</div>
	</div>

</body>
</html>