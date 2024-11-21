package prac.practcaConexionALaApi.Servicios;

import java.util.regex.Pattern;

import com.fasterxml.jackson.core.util.JacksonFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import prac.practcaConexionALaApi.Dtos.UsuariosDtos;

public class loginImplementacion {

	// representa un patrón de expresión regular para luego compararla
	private Pattern email1 = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.(com|net|es)$");

	/**
	 * Metodo privado que valida el email correctamente
	 * 
	 * @author jpribio - 19/11/24
	 * @param correo electronico introducido por el usuario
	 * @return devuelve el email validado
	 */
	private boolean validarEmail(String email) {
		if (email == null) {
			return false;
		}
		return email1.matcher(email).matches();
	}

	public void enviarDatosLogin(UsuariosDtos usuario) throws Exception {

		if (!validarEmail(usuario.getCorreoUsu())) {
			System.out.println("Error al validar la contraseña");
		}

		ObjectMapper objetoMapeador = new ObjectMapper();
		String formatoJson = objetoMapeador.writeValueAsString(usuario);

		Client cliente = ClientBuilder.newClient();

		jakarta.ws.rs.core.Response respuestaApi = cliente
				.target("http://192.168.30.150:8081/api/ProyectoDWS/verificarUsuario?correoUsuario="
						+ usuario.getCorreoUsu() + "&contraseniaUsuario=" + usuario.getContraseniaUsu())
				.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get();
		
		System.out.println(respuestaApi.getStatus());
		if (respuestaApi.getStatus() == 200) {
			
			UsuariosDtos respuestaCuerpoApi = respuestaApi.readEntity(UsuariosDtos.class);
		
			if (respuestaCuerpoApi.esAdmin()) {
				System.out.println("Eres admin");
			} else {
				System.out.println("Eres usuario");
			}
		} else {
			System.out.println("No ha encontrado una conexion");
		}
		respuestaApi.close();
	}

}
