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
		sent="SELECT * FROM clientes";

		try {
			sentencia=cn.prepareStatement(sent, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=sentencia.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

	public int obtenerMaxNumSocio() {
		String sent;
		ResultSet rs;
		sent="SELECT MAX(clave) from clientes";

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

	public int alta (String clave, String nombre, String apellidos, String edad, String calle, String numero, String codigoPostal) {
		String sent;
		try {
			sent="INSERT INTO clientes(clave, nombre, apellidos, edad, calle, numero, cp) VALUES (?, ?, ?, ?, ? ,? ,?)";
			sentencia=cn.prepareStatement(sent);
			sentencia.setString(1, clave);
			sentencia.setString(2, nombre);
			sentencia.setString(3, apellidos);
			sentencia.setString(4, edad);
			sentencia.setString(5, calle);
			sentencia.setString(6, numero);
			sentencia.setString(7, codigoPostal);

			sentencia.executeUpdate();
			return 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}
	}	

	public int baja (String clave) {
		String sent;
		try {

			sent="DELETE FROM clientes WHERE clave=?";
			sentencia=cn.prepareStatement(sent);
			sentencia.setString(1, clave);

			sentencia.executeUpdate();
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}

	}

	public int modificar (String nombre, String apellidos, String edad, String calle, String numero, String codigoPostal, String clave) {
		String sent;
		try {
			sent="UPDATE clientes SET nombre=?, apellidos=?, edad=?, calle=?, numero=?, cp=? WHERE clave=?";
			sentencia=cn.prepareStatement(sent);
			sentencia.setString(1, nombre);
			sentencia.setString(2, apellidos);
			sentencia.setString(3, edad);
			sentencia.setString(4, calle);
			sentencia.setString(5, numero);
			sentencia.setString(6, codigoPostal);
			sentencia.setString(7, clave);
			sentencia.executeUpdate();

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
