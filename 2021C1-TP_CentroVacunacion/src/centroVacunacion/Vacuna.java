package centroVacunacion;

public class Vacuna {
	boolean conservacion;
	private int cantidad;
	Fecha ingreso;
	String nombre;
	private int vencidas;
	
	public Vacuna (String nombre, int cant, Fecha fi) {
		this.nombre=nombre;
		cantidad=cantidad+cant;
		ingreso=fi;
		conservacion=esRefrigerada(nombre);
		
		
	}
	
	public boolean esRefrigerada (String nombre) {
		return (nombre.toLowerCase()=="moderna" || nombre.toLowerCase()=="sputnic" );
			
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	public int dameTotal () {
		return cantidad;
	}
	
	public int dameVencidad () {
		return vencidas;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacuna other = (Vacuna) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
