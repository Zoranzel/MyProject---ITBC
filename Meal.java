import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Meal implements Energy{

	private UUID id;                          
	private List<Nutriment> nutriments;
	private String name;



	public Meal(List<Nutriment> nutriments, String name) {

		id = UUID.randomUUID();
		this.nutriments = nutriments;
		this.name = name;
	}


	public Meal(String name) {

		id = UUID.randomUUID();
		this.name = name;
		this.nutriments = new ArrayList<Nutriment>();

	}



	// trebao mi je getter za id(za equals)
	public UUID getId() {

		return id;
	}

	// trebao mi je getter za poredjenje Meal- ova u klasi Meals
	public String getName() {
		return name;
	}

	public List<Nutriment> getNutriment(){
		return nutriments;
	}


	public void add(Nutriment n) {

		if(!nutriments.contains(n)) {

			nutriments.add(n);
		}

		// Ако постоји повећава његову масу

		for(Nutriment p : nutriments) {

			if(p.getId() == n.getId()) {
				p.setWeight(p.getWeight() + n.getWeight());
			}
		}

	}


	//   void remove(Nutriment n) - Брише из листе

	public void remove(Nutriment n) {

		for(int i = 0; i < nutriments.size();i++) {

			if(nutriments.get(i).getId() == n.getId()) {

				nutriments.remove(i);
			}
		}
	}

	//   void remove(Nutriment n, double weight) - Смањује масу нутријента (ако постоји)

	public void remove(Nutriment n, double weight) {

		for(int i = 0; i < nutriments.size();i++) {

			if(nutriments.get(i).getId() == n.getId()) {

				nutriments.get(i).setWeight(nutriments.get(i).getWeight() - weight);
			}
		}
	}


	//   getKcal() - Враћа укупну количину калорија у јелу  - ne znam valjda sabere sve sastojke

	@Override
	public double getKcal() {

		double sum = 0;

		for(Nutriment p : nutriments) {

			sum += p.getKcal();
		}

		return sum;
	}


	//	  За све, враћа укупну количину нутријената у јелу
	//	  getProteins()
	//	  getCarbohydrates
	//	  getFats()
	//	  getFiber()


	public double getProteins() {

		double sum = 0;

		for(Nutriment p : nutriments) {

			sum += p.getProteins();
		}

		return sum;
	}


	public double getCarbohydrates() {

		double sum = 0;

		for(Nutriment p : nutriments) {

			sum += p.getCarbohydrates();
		}

		return sum;
	}


	public double  getFats() {

		double sum = 0;

		for(Nutriment p : nutriments) {

			sum += p.getFats();
		}

		return sum;
	}


	public double getFiber() {

		double sum = 0;

		for(Nutriment p : nutriments) {

			sum += p.getFiber();
		}

		return sum;
	}

	//   equals(Object o) - Два објекта класе Meal су иста ако им је id исти

	@Override
	public boolean equals(Object o) {

		if(this == o) {

			return true;
		}

		if(o == null || this.getClass() != o.getClass()) {
			return false;
		}

		Meal m = (Meal)o;

		if(this.id == m.getId()) {

			return true;
		}

		return false;
	}


	@Override
	public String toString() {
		return "Meal [id=" + id + ", nutriments=" + nutriments + ", name=" + name + "]";
	}





}
