package vanderbekenmatias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TelepaseTest {
	
	
	@Test
	public void queVerificaQueSeEncuentreElTagConIdUno () throws TagNoEncontradoException {
		//Para este test se debeinvocar al metodo public Boolean verifcarExiste(Tag tag)
		//el mismo no se puede modificar
		
		//Preparación
		Tag tagUno= new Tag(1);
		Telepase telepaseUno = new Telepase(1000);
		
		//Ejecución
		telepaseUno.cargarTag(tagUno);
		
		
		//Verificación
		assertTrue(telepaseUno.verifcarExiste(tagUno));
		
	}
	

	@Test(expected = SaldoInsuficienteError.class)
	public void queAlPasarAutobusconSaldoInsuficienteLanceUnaExcepcion () throws SaldoInsuficienteError, VehiculoNoPermitidoExceptions {
		
		Tag tagUno = new Tag(2);
		tagUno.setSaldo(0D);
		Vehiculo autobus = new AutoBus("AZ54D", tagUno);
		
		Telepase uno = new Telepase(1000);
		uno.cargarTag(tagUno);
		
		uno.pagarAutomatico(autobus);
		
	}
	
	@Test(expected = TagNoEncontradoException.class)
	public void queAlPasarUnAutobusconUnTagInvalidoLanceUnaExcepcion () throws TagNoEncontradoException {
		
		//Preparacion
		Tag tagUno = new Tag(2);
		Tag tagDos = new Tag(3);
		
		Vehiculo autobus = new AutoBus("AZ54D", tagUno);
		
		Telepase uno = new Telepase(1000);
		
		
		//Ejecucion
		uno.cargarTag(tagDos);
		uno.verifcarExiste(tagUno);
		
	}
	
	

}
