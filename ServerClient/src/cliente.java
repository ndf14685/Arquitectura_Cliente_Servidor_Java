import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cliente {
	public static void main(String[] args) {
		// Indicamos donde nos vamos a conectar, en este caso va a ser 127.0.0.1 nuestra
		// maquina

		final String HOST = "127.0.0.1";
		// Indicamos puerto donde nos vamos a conectar
		final int PUERTO = 5000;

		// Esto lo definimos en el servidor y va a ser lo que vamos a usar para
		// comunicarnos
		DataInputStream in;

		DataOutputStream out;

		try {
			// Creamos un socket (proceso o hilo) para el host y puerto declarados
			Socket sc = new Socket(HOST, PUERTO);

			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());

			out.writeUTF("Hola mundo desde el cliente");

			String mensaje = in.readUTF();

			System.out.println("Mensaje a enviar: " + mensaje);

			// Cerramos la conexion
			sc.close();

		} catch (IOException e) {
			// Hacemos un catch para capturar una excecion en el servidor

			Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, e);
		}

	}
}
