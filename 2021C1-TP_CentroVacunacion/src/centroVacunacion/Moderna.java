package centroVacunacion;

public class Moderna extends Vacuna {
	Fecha vencimiento;
	int espacioEnHeladera;
	int tiempoDeVencimiento;
	
	public Moderna (String nombre, int cant, Fecha fi) {
		super(nombre,cant,fi);
		this.tiempoDeVencimiento=30;
		
	}
	
	public void asignarVencimiento(int venc) {
		//this.vencimiento=super.ingreso.avanzarDias(venc);
	}
}
