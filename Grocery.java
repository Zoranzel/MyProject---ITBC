
public abstract class Grocery implements Energy{

	private String company;
	private String name;
	private int id;




	public Grocery(String company, String name) {
		this.company = company;
		this.name = name;
	}



	public Grocery(String company, String name, int id) {
		this.company = company;
		this.name = name;
		this.id = id;
	}



	// metode

	public Grocery(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {

		return id;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public boolean equals(Object o) {

		// prvo poredi reference - ako skonta da su reference iste onda odmah vrati tacno
		if(this == o) {
			return true;
		}
		// ispituje da li je objekat sa kojim poredimo null ili da li su klase dvaju objekata iste(ako nisu odmah vrati false)
		if(o == null || this.getClass() != o.getClass()) {

			return false;
		}

		Grocery g = (Grocery)o;     // kastovanje


		// na kraju kad smo utvrdili da su objekti iste klase, poredimo njihova polja
		if(this.company.equals(g.company) &&
				this.name.equals(g.name)) {

			return true;
		}

		return false;

	}


}
