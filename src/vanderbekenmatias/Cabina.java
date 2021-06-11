package vanderbekenmatias;

import java.util.HashMap;

import java.util.Map;
import java.util.TreeMap;

public class Cabina {

	/*
	 * Fornato del Contador de vehiculo ejemplo Clave valor Moto 6 AutoBus 3 Moto 2
	 * 
	 */
	private Map<String, Integer> contadorDeVehiculos;

	private Integer numero;

	/*
	 * 
	 */
	private Double tarifaCoche;
	private Double tarifaMoto;
	private Double tarifaAutoBus;
	private Integer contadorAutoBuses = 0;
	private Integer contadorMotos = 0;
	private Integer contadorCoches = 0;

	/* recaudacion total de todos los vehiculos que pasaron por dicha cabina */
	private Double recaudacion;

	public Cabina(Integer numero) {
		this.numero = numero;
		this.recaudacion = 0.0;
		this.tarifaAutoBus = 200.0;
		this.tarifaCoche = 100.0;
		this.tarifaMoto = 50.0;
		contadorDeVehiculos = new TreeMap<String, Integer>();

		// Completar la inicializacion de los atributos restantes

	}

	/*
	 * Este metodo realiza el cobro y acumula la recaudacion de la cabina en funcion
	 * al tipo de auto Tambien contabiliza la cantidad de vehiculo ejemplo si es
	 * moto aumenta en uno el contador de moto
	 */
	public void pagar(Vehiculo vehiculo) {
		
		switch (vehiculo.getTipo()) {
		case "AutoBus":
			
		
			contadorDeVehiculos.put("AutoBus", contadorAutoBuses++);
			setRecaudacion(getTarifaAutoBus());
			recaudacion += getTarifaAutoBus();
			
			break;
			
		case "Moto": 
			
			contadorDeVehiculos.put("Moto", contadorMotos++);
			recaudacion += getTarifaMoto();
			
			break;
			
		case "Coche":
			
			contadorDeVehiculos.put("Coche", contadorCoches++ );
			recaudacion += getTarifaCoche() ;

		default:
			break;
		}
		
		

	}

	/*
	 * incrementa el contadorDeVehiculo
	 */
	private void contarVehiculo(Vehiculo vehiculo) {

	}

	public Map<String, Integer> getContadorDeVehiculos() {
		return contadorDeVehiculos;
	}

	public void setContadorDeVehiculos(Map<String, Integer> contadorDeVehiculos) {
		this.contadorDeVehiculos = contadorDeVehiculos;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getTarifaCoche() {
		return tarifaCoche;
	}

	public void setTarifaCoche(Double tarifaCoche) {
		this.tarifaCoche = tarifaCoche;
	}

	public Double getTarifaMoto() {
		return tarifaMoto;
	}

	public void setTarifaMoto(Double tarifaMoto) {
		this.tarifaMoto = tarifaMoto;
	}

	public Double getTarifaAutoBus() {
		return tarifaAutoBus;
	}

	public void setTarifaAutoBus(Double tarifaAutoBus) {
		this.tarifaAutoBus = tarifaAutoBus;
	}

	public Double getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(Double recaudacion) {
		this.recaudacion = recaudacion;
	}

	public Integer getContadorAutoBuses() {
		return contadorAutoBuses;
	}

	public void setContadorAutoBuses(Integer contadorAutoBuses) {
		this.contadorAutoBuses = contadorAutoBuses;
	}

	public Integer getContadorMotos() {
		return contadorMotos;
	}

	public void setContadorMotos(Integer contadorMotos) {
		this.contadorMotos = contadorMotos;
	}

	public Integer getContadorCoches() {
		return contadorCoches;
	}

	public void setContadorCoches(Integer contadorCoches) {
		this.contadorCoches = contadorCoches;
	}
	
	

}
