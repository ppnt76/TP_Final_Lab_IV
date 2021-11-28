<%@page import="negocioImpl.TiposCuentaNegocioImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.TipoCuentas"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cuentas</title>
</head>
<body>
	<%@ page errorPage="errorBanco.jsp"%>

	<div class=".container">
		<div class="row row-principal">
			<div class="col-2 col-menu">
				<jsp:include page="masterBanco.jsp"></jsp:include>
			</div>
			<div class="col">
				<h4>Alta Cuentas</h4>
				<div class=".container-sm" style="width: 90%">
					<form action="servletBancoCuentas" method="post">

						<div class="form-row">
							<div class="col-md-3 mb-3">
								<label for="DNICliente">DNI</label> <input type="text"
									class="form-control" name="DNICliente" placeholder="DNI"
									required>
							</div>
							<div class="col-md-3 mb-3">
								<label for="DNICliente">Usuario</label> <input type="text"
									class="form-control" name="UsuarioCliente"
									placeholder="Usuario" required>
							</div>
						</div>

						<div class="form-row">
							<div class="col-md-3 mb-3">
								<label for="TipoCuenta">Tipo Cuenta</label>
								<br>
								<select name="TipoCuenta">
									<%
										TiposCuentaNegocioImpl tp = new TiposCuentaNegocioImpl();
										ArrayList<TipoCuentas> Listatp = tp.readAll();
										if (tp != null) {
											for (TipoCuentas ltp : Listatp) {
									%><option value="<%=ltp.getId()%>"><%=ltp.getDescripcion()%>
									</option>
									<%
										}
										}
									%>
								</select>
							</div>
							<div class="col-md-3 mb-3">
								<label for="Saldo">Saldo</label> <input type="text"
									class="form-control" value="10000" name="Saldo"
									placeholder="Saldo" required>
							</div>
						</div>
						<br> 
						
						<input class="btn btn-outline-primary" type="submit" value="Aceptar" name="btnAceptar"> 
						<a	class="btn btn-outline-primary"	href="bancoCuentaModificacion.jsp" role="button">Modificar</a> 
						<a class="btn btn-outline-primary" href="bancoCuentasAlta.jsp" name="btnCancelar">Cancelar</a>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>