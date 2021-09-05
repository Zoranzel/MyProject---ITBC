import java.util.ArrayList;
import java.util.List;

public class Meals {

	private List<Meal> meals;



	public Meals(List<Meal> meals) {
		this.meals = meals;
	}

	public Meals() {
		meals = new ArrayList<Meal>();
	}


	//  metode

	public List<Meal> getMeals() {

		return meals;
	}

	public boolean add(Meal m) {

		if(!meals.contains(m)) {

			meals.add(m);
			return true;
		}

		return false;
	}


	//   void remove(Meal m) - Ако постоји у листи, избацује m

	public void remove(Meal m) {

		for(int i = 0; i < meals.size();i++) {

			if(meals.get(i).getId() == m.getId()) {

				meals.remove(i);
			}
		}
	}

	//  List<Meal> search(String s) - Враћа сва јела која садрже String s у имену


	public List<Meal> search(String s){

		List<Meal> mealsWithString = new ArrayList<>();

		for(Meal p : meals) {

			if(p.getName().contains(s)) {

				mealsWithString.add(p);
			}
		}


		return mealsWithString;
	}


	//  *List<Meal> search(List<Nutriment> nutriment) - Враћа она јела која могу да се
	//  направе уз помоћ прослеђене листе намирница
	//  Коришћење: Корисник унесе све што има у фрижидеру, метода му враћа све
	//  што може да направи уз помоћ ствари које већ има


	public List<Meal> search(List<Nutriment> nutriment){

		List<Meal> mealsYouCanMake = new ArrayList<>();

		for(Meal p : meals) {

			// imamo jedno jelo p

			List<Nutriment> listaNamirnica = p.getNutriment();

			for(int i = 0; i < listaNamirnica.size();i++) {

				if(listaNamirnica.get(i).getWeight() >= nutriment.get(i).getWeight() &&
						listaNamirnica.get(i).getKcal() >= nutriment.get(i).getKcal() &&
						listaNamirnica.get(i).getProteins() >= nutriment.get(i).getProteins() &&
						listaNamirnica.get(i).getCarbohydrates() >= nutriment.get(i).getCarbohydrates() &&
						listaNamirnica.get(i).getFats() >= nutriment.get(i).getFats() &&
						listaNamirnica.get(i).getFiber() >= nutriment.get(i).getFiber()) {

					mealsYouCanMake.add(p);
				}
			}
		}

		return mealsYouCanMake;
	}


	//  List<Meal> search(double kcal) - Враћа сва јела са мање од kcal калорија

	public List<Meal> search(double kcal) {

		List<Meal> mealsWithLessCalories = new ArrayList<>();

		for(Meal p : meals) {

			if(p.getKcal() < kcal) {

				mealsWithLessCalories.add(p);
			}
		}

		return mealsWithLessCalories;
	}


	//  toString() - Исписује сва јела:
	//   [{ id }] | Name: { name }
	//   нпр. [57b53f64-0809-11ec-9a03-0242ac130003] | Name: Шпагете са
	//   пилећим сосом

	@Override
	public String toString() {

		String rez = "";

		for(Meal p : meals) {

			rez += "[" + p.getId() + "]" + "| Name: " + p.getName() + "\n";
		}

		return rez;
	}


	//   *Додатно: Шта ако желимо да претражујемо по више параметара?



}
