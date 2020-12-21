import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
