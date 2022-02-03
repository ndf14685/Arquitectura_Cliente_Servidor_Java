import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class servidor {
	public static void main(String[] args) {
		// Socket (proceso o hilo) del servidor
		ServerSocket servidor = null;
		// Socket (proceso o hilo) del cliente
		Socket sc = null;
		DataInputStream in;
		DataOutputStream out;

		final int PUERTO = 5000;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor Iniciado ....");

			// Hacemos que el servidor se quede esperando, es decir, generamos un ciclo que
			// finalice cuando lo necesite
			while (true) {
				// Detectar cuando el cliente se conecta
				// Por ej: Cuando lanzamos una peticion
				sc = servidor.accept();

				// iniciamos la interaccion con el cliente
				System.out.println("Cliente Conectado");

				// Aca lo que hacemos es comunicar el cliente y el servidor.
				// Puente de ida y vuelta entre ambos (Cliente servidor)
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());

				// Esperamos la peticion o mensaje del Cliente
				String mensaje = in.readUTF();
				System.out.println("Mensaje del Cliente: " + mensaje);

				// Respuesta del servidor al recibir una peticion del cliente
				out.writeUTF("Hola Mundo desde el servidor");
				// Cerramos el cliente, esta peticion, OJO no cerramos el servidor
				sc.close();
				System.out.println("Cliente  Desconectado");

			}

		} catch (IOException e) {
			// Hacemos un catch para capturar una excecion en el servidor
			System.out.println("ERROR");
			Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
