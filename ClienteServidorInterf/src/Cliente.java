import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends Conexion{

	public Cliente() throws IOException{
		super("cliente");

	}
	
	public void startClient() { //Metodo para iniciar el cliente
		try {
			salidaServidor=new DataOutputStream(sc.getOutputStream());
			
			//Enviar mensajes: 2 mensajes
			for (int i = 0; i < 2; i++) {
				salidaServidor.writeUTF("Este es el mensaje numero: " + (i+1) + "\n");
				
			}
			
			
			sc.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
