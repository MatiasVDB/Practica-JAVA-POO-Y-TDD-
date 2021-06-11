package vanderbekenmatias;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Telepase extends Cabina {

	/*
	 * Atribito donde se almacentodos los tags habilitados para el telepase No se
	 * permiten tags duplicados ( 2 tags son iguales cuando tienen el mismo id)
	 */
	private Set<Tag> tags;

	public Telepase(Integer numero) {

		super(numero);

		// siempre al momento de crear un telepase se crea el tag 1 con 200 pesos de
		// carga
		Tag tagInicial = new Tag(1);
		tagInicial.setSaldo(200.0);
		tags = new HashSet<Tag>();
		this.cargarTag(tagInicial);

	}

	public Boolean cargarTag(Tag tag) {

		if (tags.add(tag)) {

			return true;
		}

		else {

			return false;

		}

	}

	/*
	 * Este metodo es pago automatico y en estas cabinas solamente estan habilitados
	 * los autobuses Al momento de pasar un autobus se descuenta el importe del tag
	 * asociado al autobus y se incrementa la recaudacion de la cabina y tambien se
	 * tiene que incrementar el contador de AutoBus
	 * 
	 * Validaciones 1) en caso que el tag no este registrado lanza una
	 * TagNoEncontradoException 2) en caso que el vehiculo que ingreso al telepase
	 * no es un AutoBus lanza una VehiculoNoPermitidoExceptions 3) en caso que el
	 * importe que tiene el tag no alcanza para pagar el peaje laza una
	 * SaldoInsuficienteError
	 * 
	 */
	public void pagarAutomatico(Vehiculo vehiculo) throws SaldoInsuficienteError, VehiculoNoPermitidoExceptions {

		if (vehiculo instanceof AutoBus) {

			for (Tag tag : tags) {

				if (((AutoBus) vehiculo).getTag().getId().equals(tag.getId())
						&& ((AutoBus) vehiculo).getTag().getSaldo() > 200D) {

					tag.setSaldo(getRecaudacion() - getTarifaAutoBus());
				}

				else {

					new SaldoInsuficienteError();

				}

			}

		}

		else {

			new VehiculoNoPermitidoExceptions();
		}

	}

	// Metodo no obligatorio
	private void pagarConTelePase(Vehiculo vehiculo) throws SaldoInsuficienteError, TagNoEncontradoException {

	}

//Verifica que si existe el tag
	public Boolean verifcarExiste(Tag tag) throws TagNoEncontradoException {
		// No Se Puede modificar el comportamiento de este metodo
		// Los tags son iguales cuando tiene el mismo id

		for (Tag tagLeido : tags) {
			if (tagLeido.equals(tag))
				return Boolean.TRUE;
		}

		throw new TagNoEncontradoException();
	}

}
