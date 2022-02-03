import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Servidor extends Conexion {

	public Servidor() throws IOException {
		super("servidor");
	}

	// Levantar el server
	public void startServer() {
		try {
			System.out.println("Esperando...");

			sc = ss.accept(); // Accept comienza el socket y espera una conexion desde un cliente

			System.out.println("Cliente en Linea");

			// Se obtiene el flujo entrante del cliente
			salidaCliente = new DataOutputStream(sc.getOutputStream());

			// Se le envia un mensaje al cliente usando el flujo de salida
			salidaCliente.writeUTF("Peticion recibida y aceptada");

			// Se obtiene el flujo entrante desde el cliente

			BufferedReader entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));

			while ((mensajeServidor = entrada.readLine()) != null) {
				System.out.println("Mensaje del servidor: " + mensajeServidor);
			}

			System.out.println("Fin de la conexion");

			ss.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
