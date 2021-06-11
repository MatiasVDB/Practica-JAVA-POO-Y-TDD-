package vanderbekenmatias;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EstacionPeajeTest {

	
	@Test
	public void queQueObtieneListaDeCabinasOrdenaPorImporteDescendente () {
		
		Cabina cabinaUno = new Cabina(1000);
		Cabina cabinaDos = new Cabina(1001);
		Cabina cabinaTres = new Cabina(1002);
		
		cabinaUno.setRecaudacion(10000D);
		cabinaDos.setRecaudacion(40000D);
		cabinaTres.setRecaudacion(50D);
	
		EstacionDePeaje estacionUno = new EstacionDePeaje();
		
		
		estacionUno.agregarCabinas(cabinaUno);
		estacionUno.agregarCabinas(cabinaDos);
		estacionUno.agregarCabinas(cabinaTres);
		
		estacionUno.otenerCabinasOrdenadaImporteDescendente(new OrdenarCabinasImporteDescendente());
		
		
		
		
		
	}
	
	
	
	
	
}
