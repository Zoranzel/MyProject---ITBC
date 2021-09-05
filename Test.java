import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	private static Scanner sc = new Scanner(System.in);



	public static Nutriment napraviSastojke() {

		System.out.println("Unesite ime firme: ");

		String s1 = sc.nextLine();

		System.out.println("Unesite ime proizvoda: ");

		String s2 = sc.nextLine();

		System.out.println("Unesite tezinu: ");

		String s3 = sc.nextLine();

		double tezina = Double.parseDouble(s3);

		System.out.println("Unesite kalorije: ");

		String s4 = sc.nextLine();

		double kalorije = Double.parseDouble(s4);

		System.out.println("Unesite procenat proteina: ");

		String s5 = sc.nextLine();

		double proteini = Double.parseDouble(s5);

		System.out.println("Unesite procenat ugljenih hidrata: ");

		String s6 = sc.nextLine();

		double ugljeniHidrati = Double.parseDouble(s6);

		System.out.println("Unesite procenat masti: ");

		String s7 = sc.nextLine();

		double masti = Double.parseDouble(s7);

		System.out.println("Unesite procenat vlakana: ");

		String s8 = sc.nextLine();

		double vlakna = Double.parseDouble(s8);

		Nutriment n = new Food(s1, s2, tezina, kalorije, proteini, ugljeniHidrati, masti, vlakna);

		System.out.println(n);

		return n;
	}


	public static Meal napraviMealIDodaSastojke() {

		System.out.println("Unesite ime jela: ");
		String ime = sc.nextLine();

		Meal me = new Meal(ime);

		Nutriment n = napraviSastojke();

		me.add(n);

		return me;
	}


	public static void dodaMealUMeals() {

		Meal m1 = napraviMealIDodaSastojke();

		Meals m = new Meals();

		m.add(m1);


		System.out.println("U listi jela se nalazi: ");
		System.out.println();
		System.out.println(m);

	}


	// metode za frizider


	public static void dodajSastojkeUFrizider(Fridge f) {

		Nutriment n = napraviSastojke();

		f.add(n);

		System.out.println(f);
	}


	public static void ukloniSastojakIzFrizidera(Fridge f) {	

		Nutriment n = napraviSastojke();

		f.remove(n);

		System.out.println(f);
	}


	public static void smanjiMasuSastojka(Fridge f) {

		Nutriment n = napraviSastojke();

		System.out.println("Unesite za koliko zelite da smanjite masu sastojka:");
		String smanjenje = sc.nextLine();
		double smanji = Double.parseDouble(smanjenje);

		f.remove(n, smanji);



		List<Nutriment> lista = f.getNutriments();

		String rez = lista.get(0).totalNutrientTable();

		System.out.println(rez);
	}


	public static void povecajMasuSastojkaKojiJeVecUFrizideru(Fridge f) {

		System.out.println("Napisite podatke sastojka koji je vec u frizideru, a zelite da mu povecate masu");
		Nutriment n = napraviSastojke();

		f.add(n);

		List<Nutriment> lista = f.getNutriments();

		String rez = lista.get(0).totalNutrientTable();

		System.out.println(rez);
	}


	public static void pregledajSvaDostupnaJela(Meals m) {

		System.out.println(m);
	}


	public static void pretraziJelaPoImenu(Meals m) {

		System.out.println("Da olaksam - sledecem koraku unesite veliko slovo P i metoda ce raditi");
		System.out.println("Unesite ime po kojem zelite da pretrazim jelo: ");
		String ime = sc.nextLine();

		List<Meal> listaJela = m.search(ime);

		for(Meal p : listaJela) {

			System.out.println(p);
		}
	}


	public static void nadjiSamoJelaKojaMozesDaNapravis() {

		// 	TODO: Implement me - nije bilo vremena
	}



	public static void main(String[] args) {


		Meals m = new Meals();

		Nutriment n = new Food("Imlek", "Kiselo mleko", 1258.90, 34.55, 72.34, 15.55, 12.90, 24.50);
		Nutriment n2 = new Food("BugBull", "Crveno meso", 1258.90, 34.55, 72.34, 15.55, 12.90, 24.50);

		List<Nutriment> list = new ArrayList<>();
		list.add(n);
		list.add(n2);

		Meal j1 = new Meal( list, "Pasulj sa kobasicama");
		Meal j2 = new Meal(list, "Piletina sa krompirom");
		Meal j3 = new Meal(list, "Grasak sa pirincom");


		m.add(j1);
		m.add(j2);
		m.add(j3);



		String answer;
		do {
			System.out.println();
			System.out.println("Program za vlasnika sajta/usluge");
			System.out.println("-------------------------------------------------");
			System.out.println(" 1 - Napravi sve sastojke za jelo");
			System.out.println(" 2 - Napravi Meal i doda prethodno napravljene sastojke");
			System.out.println(" 3 - Doda Meal u Meals");
			System.out.println(" x - Izlaz( i prelazak na drugi deo programa)");
			System.out.println();
			System.out.println("Unesite odgovor:");
			System.out.println();

			answer = sc.nextLine();

			switch(answer) {
			case "1":
				napraviSastojke();
				break;
			case "2":
				napraviMealIDodaSastojke();

				break;
			case "3":
				dodaMealUMeals();

				break;

			case "x":
				break;
			default:
				System.out.println("Pogresna opcija. Pokusajte ponovo.");
			}

		}while(!answer.equals("x"));




		Fridge f = new Fridge();


		String odgovor;
		do {
			System.out.println();
			System.out.println("Program za korisnika sajta/usluge");
			System.out.println("-------------------------------------------------");
			System.out.println(" 1 - Dodaj sastojke(Nutriment) u frizider");
			System.out.println(" 2 - Ukloni sastojak iz frizidera");
			System.out.println(" 3 - Povecaj masu sastojka koji je vec u frizideru");
			System.out.println(" 4 - Smanji masu sastojka koji je u frizideru.");
			System.out.println(" 5 - Pregledaj sva dostupna jela");
			System.out.println(" 6 - Pretrazi jela po imenu");
			System.out.println(" 7 - Nadji samo jela koja mozes da napravis sa sastojcima iz frizidera");
			System.out.println(" x - Izlaz");
			System.out.println("Unesite odgovor:");
			System.out.println();

			odgovor = sc.nextLine();

			switch(odgovor) {
			case "1":
				dodajSastojkeUFrizider(f);
				break;
			case "2":
				ukloniSastojakIzFrizidera(f);

				break;
			case "3":
				povecajMasuSastojkaKojiJeVecUFrizideru(f);

				break;
			case "4":
				smanjiMasuSastojka(f);

				break;
			case "5":
				pregledajSvaDostupnaJela(m);

				break;
			case "6":
				pretraziJelaPoImenu(m);

				break;
			case "7":
				nadjiSamoJelaKojaMozesDaNapravis();

				break;

			case "x":
				break;
			default:
				System.out.println("Pogresna opcija. Pokusajte ponovo.");
			}

		}while(!odgovor.equals("x"));




		//  Власник сајта / услуге:
		//  - Направи инстанцу класе Meals (Само један објекат)
		//  - Може да додаје јела у класу Meals
		//  - Направи све састојке за јело (Nutriment)
		//	- Направи Meal и дода претходно направљене састојке
		//	- Дода Meal у Meals

		//	   Meals m = new Meals();
		//	   
		//	   Nutriment n = new Food("Imlek", "Kiselo mleko", 1258.90, 34.55, 72.34, 15.55, 12.90, 24.50);
		//	   Nutriment n2 = new Food("BugBull", "Crveno meso", 1258.90, 34.55, 72.34, 15.55, 12.90, 24.50);
		//	   
		//	   List<Nutriment> list = new ArrayList<>();
		//	   list.add(n);
		//	   list.add(n2);
		//	   
		//	   Meal j1 = new Meal( list, "Pasulj sa kobasicama");
		//	   Meal j2 = new Meal(list, "Piletina sa krompirom");
		//	   Meal j3 = new Meal(list, "Grasak sa pirincom");
		//	  
		//	   
		//	   m.add(j1);
		//	   m.add(j2);
		//	   m.add(j3);
		//	   
		//	   for(Meal k : m.getMeals()) {
		//		   
		//		   System.out.println(k); 
		//		   
		//	   }



		//   Корисник сајта / услуге:
		//	 - Направи инстанци класе Fridge (Само један објекат)
		//	 - Може да додаје састојке (Nutriment) у фрижидер
		//	 - Може да уклања састојке, повећава и смањује масу састојака који су већ у
		//	 фрижидеру


		//		Fridge f = new Fridge();
		//		
		//		Nutriment n = new Food("Imlek", "Kiselo mleko", 1258.90, 34.55, 72.34, 15.55, 12.90, 24.50);
		//		Nutriment n2 = new Food("Soko Stark", "Jafa keks", 253.70, 14.72, 72.34, 15.55, 12.90, 24.50);
		//		Nutriment n3 = new Food("Mesara Korac", "Pileca krilca", 581.90, 134.55, 21.24, 25.91, 12.90, 14.50);
		//		
		//		Nutriment n4 = new Food("Dynazzy" , "Cleaner  -  Lime  Away" , 78.25 , 770.09 , 18.23 , 10.04 , 7.74 , 6.3);
		//		Nutriment n5 = new Food("Vinder" , "Tart  Shells  -  Barquettes,  Savory" , 73.54 , 495.52 , 6.62 , 21.45 , 13.24 , 18.82);

		//		String t = n4.totalNutrientTable();

		//		System.out.println(t);

		//		f.add(n);
		//		f.add(n2);
		//		f.add(n3);
		//		f.add(n4);
		//		
		//		f.remove(n3, 200.00);



		//		f.add(n2);

		//		for(Nutriment p : f.getNutriments()) {
		//			
		//			System.out.println(p.totalNutrientTable());
		//		}





	}

}
