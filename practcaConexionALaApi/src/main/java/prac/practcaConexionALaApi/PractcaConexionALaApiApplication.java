package prac.practcaConexionALaApi;

import prac.practcaConexionALaApi.Controlador.loginControlador;
import prac.practcaConexionALaApi.Dtos.UsuariosDtos;

//@SpringBootApplication
public class PractcaConexionALaApiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PractcaConexionALaApiApplication.class, args);
		loginControlador controlador = new loginControlador();
		UsuariosDtos usuari = new UsuariosDtos();
		usuari.setCorreoUsu("jaime.p.r0234@gmail.com");
		usuari.setContraseniaUsu("noadmin");
		controlador.metodoDeLoguearse(usuari); 
	}

}
