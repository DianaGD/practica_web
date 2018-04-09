package modelo;

public class Administrador {
	private String login;
	private String pass;
	private int id;
	
	public Administrador() {
	}

	public Administrador(String login, String pass, int id) {
		super();
		this.login = login;
		this.pass = pass;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String password) {
		this.pass = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Administrador [login=" + login + ", pass=" + pass
				+ ", id=" + id + "]";
	}
	
}
