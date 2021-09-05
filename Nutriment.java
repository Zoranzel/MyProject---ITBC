import java.util.Set;

public abstract class Nutriment extends Grocery{

	private double weight;
	private double kcal;
	private double proteins;
	private double carbohydrates;
	private double fats;
	private double fiber;



	public Nutriment(String company, String name, double weight, double kcal, double proteins, double carbohydrates,
			double fats, double fiber) {
		super(company, name);
		this.weight = weight;
		this.kcal = kcal;
		this.proteins = proteins;
		this.carbohydrates = carbohydrates;
		this.fats = fats;
		this.fiber = fiber;
	}



	//  metode

	public double getWeight() {
		return weight;
	}



	public void setWeight(double weight) {
		this.weight = weight;
	}



	public double getKcal() {
		return kcal;
	}



	public void setKcal(double kcal) {
		this.kcal = kcal;
	}



	public double getProteins() {
		return proteins;
	}



	public void setProteins(double proteins) {
		this.proteins = proteins;
	}



	public double getCarbohydrates() {
		return carbohydrates;
	}



	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}



	public double getFats() {
		return fats;
	}



	public void setFats(double fats) {
		this.fats = fats;
	}



	public double getFiber() {
		return fiber;
	}



	public void setFiber(double fiber) {
		this.fiber = fiber;
	}




	public void update(String company, String name, Double weight, Double kcal, Double proteins, Double carbohydrates,
			Double fats, Double fiber) {

		if(company != null) {
			setCompany(company);
		}

		if(name != null) {
			setName(name);
		}

		if(weight != null) {
			setWeight(weight);
		}

		if(kcal != null) {
			setKcal(kcal);
		}

		if(proteins != null) {
			setProteins(proteins);
		}

		if(carbohydrates != null) {
			setCarbohydrates(carbohydrates);
		}

		if(fats != null) {
			setFats(fats);
		}

		if(fiber != null) {
			setFiber(fiber);
		}

	}


	//	toString()
	//	Company: { company }
	//	Name: { name }
	//	Weight: 100g
	//	Kcal: { kcal }
	//	Proteins: { proteins }%
	//	Carbohydrates: { carbohydrates }%
	//	Fats: { fats }%
	//	Fiber: { fiber }%


	public String toString() {

		return "Company: " + getCompany() + "\n"
				+ "Name: " + getName() + "\n"
				+ "Weight: " + 100 + "g" + "\n"
				+ "Kcal: " + kcal + "\n"
				+ "Proteins: " + proteins + " %" + "\n"
				+ "Carbohydrates: " + carbohydrates + " %" + "\n"
				+ "Fats: " + fats + " %" + "\n"
				+ "Fiber: " + fiber + " %" + "\n";

	}


	//  ne razumem bas ovu metodu - kako racuna 
	//   totalNutrientTable()
	//   Враћа све исто као toString, али рачуна конкретне вредности за све нутријенте
	//   (уместо у процентима)
	//   нпр: Weight: 100g - Proteins: 10g
	//   А у случају да је за исти производ Weight: 210g - Proteins: 21g


	public String totalNutrientTable() {

		return "Company: " + getCompany() + "\n"
				+ "Name: " + getName() + "\n"
				+ "Weight: " + weight + " g" + "\n"
				+ "Kcal: " + (weight/100) * kcal + "\n"
				+ "Proteins: " + (weight/100) * proteins + " g" + "\n"
				+ "Carbohydrates: " + (weight * carbohydrates)/100 + " g" + "\n"
				+ "Fats: " + (weight * fats)/100 + " g" + "\n"
				+ "Fiber: " + (weight * fiber)/100 + " g" + "\n";

	}








}
