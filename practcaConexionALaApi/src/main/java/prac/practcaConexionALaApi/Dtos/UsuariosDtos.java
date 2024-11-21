package prac.practcaConexionALaApi.Dtos;

public class UsuariosDtos {

	private String correoUsu = "aaaaa";
	private String contraseniaUsu = "aaaaa";
	private boolean esAdmin=false;

	public String getCorreoUsu() {
		return correoUsu;
	}

	public void setCorreoUsu(String correoUsu) {
		this.correoUsu = correoUsu;
	}

	public String getContraseniaUsu() {
		return contraseniaUsu;
	}

	public void setContraseniaUsu(String contraseniaUsu) {
		this.contraseniaUsu = contraseniaUsu;
	}

	public boolean esAdmin() {
		return esAdmin;
	}

	public void setesAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	
	
}
