package prac.practcaConexionALaApi.Controlador;

import prac.practcaConexionALaApi.Dtos.UsuariosDtos;
import prac.practcaConexionALaApi.Servicios.loginImplementacion;

public class loginControlador {

	loginImplementacion metodosLogin = new loginImplementacion();

	public void metodoDeLoguearse( UsuariosDtos usuarios) {
		try {
			metodosLogin.enviarDatosLogin(usuarios);
		} catch (Exception e) {
			System.out.println("Error donde esta el try catch de el metodo loguearse");
			e.printStackTrace();
		}
	    
	}
}
