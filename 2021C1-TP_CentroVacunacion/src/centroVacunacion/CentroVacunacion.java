package centroVacunacion;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class CentroVacunacion {
	int capacidad;
	String nombre;
	ArrayList <Vacuna> vacunas;
	ArrayList<Turno> turnos;
	HashSet <Persona> inscriptos;
	int vacunasVencidas;
	int stock;
	
	//* Constructor.
	//* recibe el nombre del centro y la capacidad de vacunación diaria.
	//* Si la capacidad de vacunación no es positiva se debe generar una excepción.
	//* Si el nombre no está definido, se debe generar una excepción.
	//*/
	public  CentroVacunacion(String nombreCentro, int capacidadVacunacionDiaria) {
		this.nombre=nombreCentro;
		this.capacidad=capacidadVacunacionDiaria;
	}
		
	/**
	* Solo se pueden ingresar los tipos de vacunas planteados en la 1ra parte.
	* Si el nombre de la vacuna no coincidiera con los especificados se debe generar
	* una excepción.
	* También se genera excepción si la cantidad es negativa.
	* La cantidad se debe
	* sumar al stock existente, tomando en cuenta las vacunas ya utilizadas.
	 * @throws Exception 
	*/
	public void ingresarVacunas(String nombreVacuna, int cantidad, Fecha fechaIngreso) throws Exception {
		if (nombreVacuna.toLowerCase()=="sputnik")
				vacunas.add(new Sputnik (nombreVacuna, cantidad, fechaIngreso));
				this.stock=this.stock+cantidad;
		if (nombreVacuna.toLowerCase()=="moderna")
				vacunas.add(new Moderna (nombreVacuna, cantidad, fechaIngreso));
				this.stock=this.stock+cantidad;	
		if (nombreVacuna.toLowerCase()=="pfizer")
				vacunas.add(new Pfizer (nombreVacuna, cantidad, fechaIngreso));
				this.stock=this.stock+cantidad;
		if (nombreVacuna.toLowerCase()=="sinopharm")
				vacunas.add(new Sinopharm (nombreVacuna, cantidad, fechaIngreso));
				this.stock=this.stock+cantidad;
		if (nombreVacuna.toLowerCase()=="astrazeneca")
				vacunas.add(new Astrazeneca (nombreVacuna, cantidad, fechaIngreso));
				this.stock=this.stock+cantidad;
		if (nombreVacuna.toLowerCase()!="sputnik" && nombreVacuna.toLowerCase()!="moderna" &&
				nombreVacuna.toLowerCase()!="pfizer" && nombreVacuna.toLowerCase()!="sinopharm"
				&& nombreVacuna.toLowerCase()!="astrazeneca")
			throw new Exception ("el nombre ingresado no corresponde a una vacuna");
		
		if (cantidad<1)
			throw new Exception ("el numero ingresado debe ser mayor que uno");
	}
	/**
	* total de vacunas disponibles no vencidas sin distinción por tipo.
	*/
	public int vacunasDisponibles() {
		
		return vacunasVencidas;
	}
	/**
	* total de vacunas disponibles no vencidas que coincida con el nombre de
	* vacuna especificado.
	*/
	public int vacunasDisponibles(String nombreVacuna) {
		return 0;
	}
	/**
	* Se inscribe una persona en lista de espera.
	* Si la persona ya se encuentra inscripta o es menor de 18 años, se debe
	* generar una excepción.
	* Si la persona ya fue vacunada, también debe generar una excepción.
	*/
	public void inscribirPersona(int dni, Fecha nacimiento,
	boolean tienePadecimientos, boolean esEmpleadoSalud) {
		Persona paciente= new Persona(dni, nacimiento,
				tienePadecimientos, esEmpleadoSalud);
		inscriptos.add(paciente);
		
	}
	/**
	* Devuelve una lista con los DNI de todos los inscriptos que no se vacunaron
	* y que no tienen turno asignado.
	* Si no quedan inscriptos sin vacunas debe devolver una lista vacía.
	*/
	public ArrayList<Integer> listaDeEspera(){
		ArrayList<Integer>  lista = new ArrayList <Integer> ();
		Iterator<Persona> iterador = inscriptos.iterator();
		if (iterador.hasNext())
			lista.add(iterador.next().getDni());
		return lista;
	}
	/**
	* Primero se verifica si hay turnos vencidos. En caso de haber turnos
	* vencidos, la persona que no asistió al turno debe ser borrada del sistema
	* y la vacuna reservada debe volver a estar disponible.
	*
	* Segundo, se deben verificar si hay vacunas vencidas y quitarlas del sistema.
	*
	* Por último, se procede a asignar los turnos a partir de la fecha inicial
	* recibida según lo especificado en la 1ra parte.
	* Cada vez que se registra un nuevo turno, la vacuna destinada a esa persona
	* dejará de estar disponible. Dado que estará reservada para ser aplicada
	* el día del turno.
	*
	*
	*/
	public void generarTurnos(Fecha fechaInicial) {
		
	}
	/**
	* Devuelve una lista con los dni de las personas que tienen turno asignado
	* para la fecha pasada por parámetro.
	* Si no hay turnos asignados para ese día, se debe devolver una lista vacía.
	* La cantidad de turnos no puede exceder la capacidad por día de la ungs.
	*/
	public ArrayList<Integer> turnosConFecha(Fecha fecha){
		ArrayList<Integer>  lista = new ArrayList <Integer> ();
		return lista;
	}
	/**
	* Dado el DNI de la persona y la fecha de vacunación
	* se valida que esté inscripto y que tenga turno para ese dia.
	* - Si tiene turno y está inscripto se debe registrar la persona como
	* vacunada y la vacuna se quita del depósito.
	* - Si no está inscripto o no tiene turno ese día, se genera una Excepcion.
	*/
	public void vacunarInscripto(int dni, Fecha fechaVacunacion) {
		
	}
	/**
	* Devuelve un Diccionario donde
	* - la clave es el dni de las personas vacunadas
	* - Y, el valor es el nombre de la vacuna aplicada.
	*/
	public Map<Integer, String> reporteVacunacion(){
		Map lista= new HashMap <Integer,String> ();
		return lista;
	}
	/**
	* Devuelve en O(1) un Diccionario:
	* - clave: nombre de la vacuna
	* - valor: cantidad de vacunas vencidas conocidas hasta el momento.
	*/
	public Map<String, Integer> reporteVacunasVencidas(){
		Map lista= new HashMap <String,Integer> ();
		return lista;
	}

}
