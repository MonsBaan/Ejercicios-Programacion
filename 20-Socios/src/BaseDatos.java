import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class BaseDatos {
	public static final String BD="socios";
	
	private String cadenaConex;
	private Connection cn;
	private PreparedStatement sentencia;
	
	public BaseDatos() {
		cadenaConex="jdbc:mysql://192.168.6.136:3306/"+BD+"?allowPublicKeyRetrieval=true&useSSL=false";

	}
	
	public void conectar() {
		try {
			cn=DriverManager.getConnection(cadenaConex, "phpRoot", "123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet obtenerDatos() {
		String sent;
		ResultSet rs;
		sent="SELECT * FROM socios ";
		
		//sent="SELECT * FROM socios WHERE numSocio>? and Poblacion=?"
		
		try {
			sentencia=cn.prepareStatement(sent, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=sentencia.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int obtenerMaxNumSocio() {
		String sent;
		ResultSet rs;
		sent="SELECT MAX(num_socio) from socios";
		
		try {
			sentencia=cn.prepareStatement(sent);
			rs=sentencia.executeQuery();
			rs.first();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int ejecutarSQL(String sent) {
		int refAffec=0;
		try {
			sentencia=cn.prepareStatement(sent);
			sentencia.executeUpdate();
			refAffec=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return refAffec;

		
	}

	public int editar(String nombre, String direccion, String telefono, String numSocio) {
		String sent;		
		try {
			sent="UPDATE socios SET nombre=?, direccion=?, telefono=? WHERE num_socio=?";
			sentencia=cn.prepareStatement(sent);
			sentencia.setString(1, nombre);
			sentencia.setString(2, direccion);
			sentencia.setString(3, telefono);
			sentencia.setString(4, numSocio);

			sentencia.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;

		}


	}

	public int añadir(String nombre, String direccion, String telefono) {
		String sent;
		
		try {
			sent="INSERT INTO socios(nombre, direccion, telefono) VALUES (?,?,?)";
			sentencia=cn.prepareStatement(sent);
			sentencia.setString(1, nombre);
			sentencia.setString(2, direccion);
			sentencia.setString(3, telefono);
			
			sentencia.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}
	
	public int eliminar(String numSocio) {
		String sent;
		
		sent="DELETE FROM socios WHERE num_socio=?";
		try {
			sentencia=cn.prepareStatement(sent);
			sentencia.setString(1, numSocio);
			
			sentencia.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;

		}
		
	}
}
