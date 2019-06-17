package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Parlament {

	private static final Parlament instance = new Parlament();

	private Parlament() {
	}

	public static Parlament getInstance() {
		return instance;
	}

	List<Faction> listOfFactions = new ArrayList<>();

	public void addFaction() {
		System.out.println("Введіть назву фракції");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		listOfFactions.add(new Faction(name));
		System.out.println("Ви додали нову фракцію: " + name);
	}

	public void removeFaction() {
		System.out.println("Введіть назву фракції");
		Scanner scanner = new Scanner(System.in);
		String nameOfFaction = scanner.next();

		boolean flag = ifFactionExcists(nameOfFaction);

		Iterator<Faction> iterator = listOfFactions.iterator();

		if (flag) {
			while (iterator.hasNext()) {
				Faction next = iterator.next();
				if (next.getName().equalsIgnoreCase(nameOfFaction)) {
					System.out.println("Ви видалили фракцію " + next);
					iterator.remove();
				}
			}
		} else {
			System.out.println("Такої фракції не існує");
		}
	}

	public void showAllFactions() {
		for (Faction faction : listOfFactions) {
			System.out.println(faction);
		}
	}

	public void showFaction() {
		System.out.println("Введіть назву фракції");
		Scanner scanner = new Scanner(System.in);
		String nameOfFaction = scanner.next();

		boolean flag = ifFactionExcists(nameOfFaction);

		if (flag) {
			for (Faction faction : listOfFactions) {
				if (faction.getName().equalsIgnoreCase(nameOfFaction)) {
					System.out.println(faction);
				}
			}
		} else {
			System.out.println("Такої фракції не існує");
		}
	}

	public void addDeputyToFaction() {
		System.out.println("Введіть назву фракції");
		Scanner scanner = new Scanner(System.in);
		String nameOfFaction = scanner.next();

		boolean flag = ifFactionExcists(nameOfFaction);

		if (flag) {

			for (Faction faction : listOfFactions) {
				if (faction.getName().equalsIgnoreCase(nameOfFaction)) {
					faction.addDeputy();
					System.out.println("до фракції " + faction);
				}
			}
		} else {
			System.out.println("Такої фракції не існує");
		}

	}

	// пошук депутата по всіх фракціях
//	public void removeDeputy() { 
//
//		System.out.println("Прізвище депутата, якого хочете видалити");
//		Scanner sc = new Scanner(System.in);
//		String secondName = sc.next();
//
//		System.out.println("Ім'я депутата, якого хочете видалити");
//		sc = new Scanner(System.in);
//		String name = sc.next();
//
//		Iterator<Faction> iterator = listOfFactions.iterator();
//
//		while (iterator.hasNext()) {
//			Faction next = iterator.next();
//			List<Deputy> newListOfDeputies = new ArrayList<>();
//			newListOfDeputies = next.getListOfDeputies();
//
//			Iterator<Deputy> iterator2 = newListOfDeputies.iterator();
//			while (iterator2.hasNext()) {
//				Deputy next2 = iterator2.next();
//
//				if (next2.getSecondName().equalsIgnoreCase(secondName) && next2.getName().equalsIgnoreCase(name)) {
//					System.out.println("Видалено депутата " + next2 + " з фракції " + next);
//					iterator.remove();
//				}
//			}
//		}
//	}

	// Пошук депутата в конкретній фракції
	public void removeDeputy() {
		System.out.println("Введіть назву фракції");
		Scanner scanner = new Scanner(System.in);
		String nameOfFaction = scanner.next();

		boolean flag = ifFactionExcists(nameOfFaction);

		if (flag) {
			for (Faction faction : listOfFactions) {
				if (faction.getName().equals(nameOfFaction)) {
					faction.removeDeputy();
				}
			}
		} else {
			System.out.println("Такої фракції не існує");
		}
	}

	public void showAllGrafters() {
		for (Faction faction : listOfFactions) {
			faction.showGrafter();
		}
	}

	public void showBiggestGrafterInFaction() {
		for (Faction faction : listOfFactions) {
			System.out.println(faction);
			faction.showBiggestGrafter();
		}
	}

	public void showAllDeputiesInFaction() {
		for (Faction faction : listOfFactions) {
			faction.showAllDeputies();
		}
	}

	private boolean ifFactionExcists(String nameOfFaction) {
		boolean flag = false;

		for (Faction faction : listOfFactions) {
			if (faction.getName().equalsIgnoreCase(nameOfFaction)) {
				flag = true;
			}
		}
		return flag;
	}

}
