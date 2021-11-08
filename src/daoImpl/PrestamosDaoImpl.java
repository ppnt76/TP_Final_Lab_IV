package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.PrestamosDao;
import entidad.Prestamos;


public class PrestamosDaoImpl implements PrestamosDao{

	static String host = "localhost";
    static int port = 3306;
    static String db = "TPInt_GRUPO1_V2";
    static String user = "root";
    static String pass = "root";
    
    static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	@Override
	public boolean insertPrestamo(Prestamos prestamo) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		 int filas =0;
		 Connection conn = null;
		 try {
			 conn = DriverManager.getConnection(url, user, pass);
			 Statement st =   conn.createStatement();
			 
			 String query= "Insert into prestamos(cuotaspagas,cuotastotal, importeCuota, importePedido, FK_NumeroCuenta) values"
			 		+ " ('"+prestamo.getCuotasPagas()+"','"+prestamo.getCuotasTotal()+"','"+prestamo.getImporteCuota()+"','"
					 +prestamo.getImportePedidoTotal()+"','"+prestamo.getNumeroCuenta()+"')";
					 
			 filas = st.executeUpdate(query);
			 if(filas > 0) {
				conn.close();
				return true;
			 }
			 
			 
			 
		 }catch(SQLException e) {
				e.printStackTrace();
		}finally {
				
		}
		 return false;
		
	}

	@Override
	public ArrayList<Prestamos> readAll(int dni){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		ArrayList<Prestamos> lista  = new ArrayList<Prestamos>();
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url, user, pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT p.id, p.cuotaspagas, p.cuotastotal, p.importeCuota, p.importePedido, p.FechaUltimoPago,"
					+ " p.FK_NumeroCuenta FROM prestamos as p inner join cuentas as c on c.NumeroCuenta = p.FK_NumeroCuenta " + 
					"  inner join usuario as u on u.FK_DniDP = c.FK_DniCliente  where u.FK_DniDP =" + dni );
			
			while(rs.next()){
				
				Prestamos presRs= new Prestamos();
				presRs.setId(rs.getInt("id"));
				presRs.setCuotasPagas(rs.getInt("cuotaspagas"));
				presRs.setCuotasTotal(rs.getInt("cuotastotal"));
				presRs.setImporteCuota(rs.getDouble("importeCuota"));
				presRs.setImportePedidoTotal(rs.getFloat("importePedido"));
				presRs.setFechaUltimoPago(rs.getDate("FechaUltimoPago").toLocalDate());
				presRs.setNumeroCuenta(rs.getInt("FK_NumeroCuenta"));
				
				lista.add(presRs);
			
				
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return lista;
	}
	
	
	@Override
	public ArrayList<Prestamos> FiltroMonto(String desde, String hasta){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		ArrayList<Prestamos> lista  = new ArrayList<Prestamos>();
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url, user, pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT p.id, p.cuotaspagas, p.cuotastotal, p.importeCuota, p.importePedido, p.FechaUltimoPago,"
					+ " p.FK_NumeroCuenta FROM prestamos as p inner join cuentas as c on c.NumeroCuenta = p.FK_NumeroCuenta " + 
					"  inner join usuario as u on u.FK_DniDP = c.FK_DniCliente  where p.importePedido >= '" + desde + "' and  p.importePedido <= '" + hasta +"'");
			
			while(rs.next()){
				
				Prestamos presRs= new Prestamos();
				presRs.setId(rs.getInt("id"));
				presRs.setCuotasPagas(rs.getInt("cuotaspagas"));
				presRs.setCuotasTotal(rs.getInt("cuotastotal"));
				presRs.setImporteCuota(rs.getDouble("importeCuota"));
				presRs.setImportePedidoTotal(rs.getFloat("importePedido"));
				//presRs.setFechaUltimoPago(rs.getDate("FechaUltimoPago").toLocalDate());
				presRs.setNumeroCuenta(rs.getInt("FK_NumeroCuenta"));
				
				lista.add(presRs);
			
				
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return lista;
	}
	
	@Override
	public ArrayList<Prestamos> readAll(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		ArrayList<Prestamos> lista  = new ArrayList<Prestamos>();
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url, user, pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT p.id, p.cuotaspagas, p.cuotastotal, p.importeCuota, p.importePedido, p.FechaUltimoPago,"
					+ " p.FK_NumeroCuenta FROM prestamos as p inner join cuentas as c on c.NumeroCuenta = p.FK_NumeroCuenta " + 
					"  inner join usuario as u on u.FK_DniDP = c.FK_DniCliente ");
			
			while(rs.next()){
				
				Prestamos presRs= new Prestamos();
				presRs.setId(rs.getInt("id"));
				presRs.setCuotasPagas(rs.getInt("cuotaspagas"));
				presRs.setCuotasTotal(rs.getInt("cuotastotal"));
				presRs.setImporteCuota(rs.getDouble("importeCuota"));
				presRs.setImportePedidoTotal(rs.getFloat("importePedido"));
				//presRs.setFechaUltimoPago(rs.getDate("FechaUltimoPago").toLocalDate());
				presRs.setNumeroCuenta(rs.getInt("FK_NumeroCuenta"));
				
				lista.add(presRs); 
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return lista;
	}

	public ArrayList<Prestamos> BuscarPrestamo(String Nprestamo) {
		ArrayList<Prestamos> pres  = new ArrayList<Prestamos>();
		int NumPrestamos= Integer.parseInt(Nprestamo);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url, user, pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT id, cuotaspagas, cuotastotal, importeCuota, importePedido,"
					+ " FechaUltimoPago, FK_NumeroCuenta, FechaUltimoPago FROM prestamos where id =" + NumPrestamos );
			
			while(rs.next()){
				Prestamos presRs= new Prestamos();
				presRs.setId(rs.getInt("id"));
				presRs.setCuotasPagas(rs.getInt("cuotaspagas"));
				presRs.setCuotasTotal(rs.getInt("cuotastotal"));
				presRs.setImporteCuota(rs.getDouble("importeCuota"));
				presRs.setImportePedidoTotal(rs.getFloat("importePedido"));
				presRs.setFechaUltimoPago(rs.getDate("FechaUltimoPago").toLocalDate());
				presRs.setNumeroCuenta(rs.getInt("FK_NumeroCuenta"));
				
				pres.add(presRs);
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return pres;
	}
	
	
	public Prestamos BuscarPrestamos(String numero) {
		Prestamos presRs= new Prestamos();
		int NumPrestamos= Integer.parseInt(numero);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url, user, pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT id, cuotaspagas, cuotastotal, importeCuota, importePedido,"
					+ " FechaUltimoPago, FK_NumeroCuenta, FechaUltimoPago FROM prestamos where id =" + NumPrestamos );
			while(rs.next()){
				
				presRs.setId(rs.getInt("id"));
				presRs.setCuotasPagas(rs.getInt("cuotaspagas"));
				presRs.setCuotasTotal(rs.getInt("cuotastotal"));
				presRs.setImporteCuota(rs.getDouble("importeCuota"));
				presRs.setImportePedidoTotal(rs.getFloat("importePedido"));
				presRs.setFechaUltimoPago(rs.getDate("FechaUltimoPago").toLocalDate());
				presRs.setNumeroCuenta(rs.getInt("FK_NumeroCuenta"));
				
				
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return presRs;
	}
	
	
	public boolean ComprobarSaldo(double saldo, String Ncuenta) {
		int cuenta= Integer.parseInt(Ncuenta);
		double saldoRs=0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url, user, pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT Saldo FROM cuentas where NumeroCuenta="+cuenta);
		
			while(rs.next())
			{
				 saldoRs = rs.getDouble("saldo");
			}
			if(saldoRs > saldo) {
				conn.close();
				return true;
			}
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return false;
	}

	public boolean UpdateCuotas(String NPrestamo,int cantCuotasPagas) {
		int nPrestamo=Integer.parseInt(NPrestamo);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		int filas=0;
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url, user, pass);
			Statement st =   conn.createStatement();
			
			String query = ("update prestamos set cuotaspagas = (cuotaspagas+ '"+cantCuotasPagas+"'), FechaUltimoPago = now() "					
					+ "where id ="+nPrestamo);
			filas = st.executeUpdate(query);
			
			if(filas > 0) {
				conn.close();
				return true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
			return false;
		
	}
	
	
	public boolean RestarSaldo(int Ncuenta, double saldo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		int filas=0;
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url, user, pass);
			Statement st =   conn.createStatement();
			
			String query = ("update cuentas set Saldo = (Saldo - '"+saldo+"')"
					+ " where NumeroCuenta ="+Ncuenta);
			filas = st.executeUpdate(query);
			
			if(filas > 0) {
				conn.close();
				return true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
			return false;
	}
}
	
