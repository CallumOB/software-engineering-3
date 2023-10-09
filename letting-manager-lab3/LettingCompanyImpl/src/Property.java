import java.util.List;
import java.util.ArrayList;


public class Property {
	private String name;
	private List<Apartment> apartments = new ArrayList<Apartment>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Apartment> getApartments() {
		return apartments;
	}

	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}

	
	public Property(String _name){
		this.name = _name;
	}
	
	public double computeMonthlyRent(){
		double rent = 0;

		for (Apartment apartment : apartments) {
			rent += apartment.getMonthlyRent();
		} 
		
		return rent;
	}
	
	public void addApartment(Apartment apartment){
		apartments.add(apartment);
	}
}
