package centroVacunacion;

public class Persona {
	String nombre;
	int edad;
	int dni;
	boolean enfermedadPre;
	boolean personalSalud;
	Fecha fechaNacimiento;
	boolean estaVacunado;
	int prioridad;
	
	public Persona (int dni, Fecha fechaNac, boolean tienePadecimientos, boolean esEmpleadoSalud){
		this.edad=Fecha.diferenciaAnios(Fecha.hoy(), fechaNac);
		this.dni=dni;
		this.enfermedadPre=tienePadecimientos;
		this.personalSalud=esEmpleadoSalud;
		this.fechaNacimiento=fechaNac;
	}
	
	public boolean mayorDe60 (){
		if (this.edad>60)
			return true;
		else
			return false;
			
	}
	
	public boolean enfermedadPreexistente (){
		if (this.enfermedadPre)
			return true;
		else
			return false;
	}
	
	public boolean esPersonalSalud (){
		if (this.personalSalud)
			return true;
		else
			return false;
	}
	
	public void esPrioridad () {
		if (personalSalud)
			this.prioridad=1;

		if(enfermedadPre)
			this.prioridad=2;
		if (mayorDe60())
			this.prioridad=3;
		else
			this.prioridad=4;
	}
	
	public Persona damePersona (Persona persona) throws Exception{
		if(this.dni==persona.getDni())
			return persona;
		else
			throw new Exception("La persona no se encuentra ingresada");
	
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni
				+ ", enfermedadPre=" + enfermedadPre + ", personalSalud="
				+ personalSalud + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public boolean isEnfermedadPre() {
		return enfermedadPre;
	}

	public void setEnfermedadPre(boolean enfermedadPre) {
		this.enfermedadPre = enfermedadPre;
	}

	public boolean isPersonalSalud() {
		return personalSalud;
	}

	public void setPersonalSalud(boolean personalSalud) {
		this.personalSalud = personalSalud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni != other.dni)
			return false;
		return true;
	}

}
