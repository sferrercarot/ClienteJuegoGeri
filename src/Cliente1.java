import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente1 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("10.204.223.108 ", 5000);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {

            String mensaje;
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println(mensaje);
                if (mensaje.contains("Introduce") || mensaje.contains("Intenta")|| mensaje.contains("Elige")) {
                    String respuesta = teclado.readLine();
                    salida.println(respuesta);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
