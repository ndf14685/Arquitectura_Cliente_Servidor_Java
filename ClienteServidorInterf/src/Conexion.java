import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
	private final int PUERTO = 1234; //Puerto de la conexion
	//Mensajes entrantes (recibidos)
	private final String HOST = "localhost";
	
	protected String mensajeServidor;
	protected ServerSocket ss; //Socket del servidor
	protected Socket sc; //Socket del cliente
	
	protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida
	
	public Conexion (String tipo) throws IOException {
		
			if (tipo.equalsIgnoreCase("servidor")) {
			ss = new ServerSocket(PUERTO);//Se crea el socket para el servidor en el puerto 1234
			sc = new Socket(); //Socket para el cliente
			}else {
				sc = new Socket(HOST,PUERTO);//Socket para el cliente en localhost en el puerto 1234
			}
			
		
	}	
}
