package clase;

public class Contactos {

	String nombre;
	String apellido;
	int telefono;
	String twitter;
	
	public Contactos(String nombre, String apellido, int telefono, String twitter) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.twitter = twitter;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	@Override
	public String toString() {
		return "Contactos [nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", twitter="
				+ twitter + "]";
	}
	
	
}
