import java.util.ArrayList;
import java.util.List;

public class Fridge {                              //  sve radi provereno

	private List<Nutriment> nutriments;



	public Fridge(List<Nutriment> nutriments) {
		this.nutriments = nutriments;
	}

	public Fridge() {
		this.nutriments = new ArrayList<Nutriment>();;
	}




	//  metode

	//    add(Nutriment n)
	//    Додаје у листу ако већ не постоји
	//    Ако већ постоји, додати повећати његову масу

	public void add(Nutriment n) {


		if(!nutriments.contains(n)) {
			nutriments.add(n);
			return;
		}else {

			for(Nutriment p : nutriments) {

				if(p.equals(n)) {
					p.setWeight(p.getWeight() + n.getWeight());     // cini se da ne radi- ipak radi
				}
			}
		}
	}




	//  remove(Nutriment n) - u potpunosti brise

	public void remove(Nutriment n) {

		for(int i = 0; i < nutriments.size();i++) {

			if(nutriments.get(i).getCompany() == n.getCompany() &&
					nutriments.get(i).getName() == n.getName() &&
					nutriments.get(i).getWeight() == n.getWeight() &&
					nutriments.get(i).getKcal() == n.getKcal()) {

				nutriments.remove(i);
			}
		}

	}


	//    remove(Nutriment n, double weight)
	//    Смањује масу за прослеђену вредност (Ако постоји)


	public void remove(Nutriment n, double weight) {

		for(Nutriment p : nutriments) {

			if(p.equals(n)) {

				p.setWeight(p.getWeight() - weight);
			}
		}
	}

	public List<Nutriment> getNutriments() {
		return nutriments;	
	}

	@Override
	public String toString() {
		return "Fridge [nutriments=" + nutriments + "]";
	}




}
