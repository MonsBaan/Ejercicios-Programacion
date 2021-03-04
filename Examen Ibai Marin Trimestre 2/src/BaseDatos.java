import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDatos {
	public static final String BD="peliculas";
	
	private String cadenaConex;
	private Connection cn;
	private PreparedStatement sentencia;
	
	public BaseDatos() {
		cadenaConex="jdbc:mysql://192.168.6.233:3306/"+BD+"?allowPublicKeyRetrieval=true&useSSL=false";

	}
	
	public void conectar() {
		try {
			cn=DriverManager.getConnection(cadenaConex, "roberto", "Almi123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet obtenerDatos() {
		String sent;
		ResultSet rs;
		sent="SELECT * FROM peliculas ";
		
		
		try {
			sentencia=cn.prepareStatement(sent, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=sentencia.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet obtenerDatosLetra(String letra) {
		String sent;
		ResultSet rs;
		
		sent="SELECT * FROM peliculas WHERE titulo LIKE '"+letra+"%'";
		
		try {
			sentencia=cn.prepareStatement(sent, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=sentencia.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
