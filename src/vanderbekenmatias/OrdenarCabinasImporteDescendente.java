package vanderbekenmatias;

import java.util.Comparator;

public class OrdenarCabinasImporteDescendente implements Comparator<Cabina> {

	@Override
	public int compare(Cabina cabina1, Cabina cabina2) {
		// TODO Auto-generated method stub
		
		
		return cabina1.getRecaudacion().compareTo(cabina2.getRecaudacion());
	}

	
}
