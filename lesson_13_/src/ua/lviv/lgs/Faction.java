package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Faction {

	private String name;

	public Faction(String name) {
		super();
		this.name = name;
	}

	List<Deputy> listOfDeputies = new ArrayList<>();

	public void addDeputy() {

		System.out.println("Введіть депутата");

		System.out.println("Введіть вагу");
		Scanner sc = new Scanner(System.in);
		Double weight = sc.nextDouble();

		System.out.println("Введіть ріст");
		sc = new Scanner(System.in);
		int height = sc.nextInt();

		System.out.println("Введіть ім'я");
		sc = new Scanner(System.in);
		String name = sc.next();

		System.out.println("Введіть прізвище");
		sc = new Scanner(System.in);
		String secondName = sc.next();

		System.out.println("Введіть вік");
		sc = new Scanner(System.in);
		int age = sc.nextInt();

		System.out.println("Депутат - хабарник? якщо так - натисніть 1, якщо ні - натисніть 2");
		sc = new Scanner(System.in);
		int grafter = sc.nextInt();
		isGrafter(grafter);

		Deputy deputy = new Deputy(weight, height, secondName, name, age, isGrafter(grafter));
		listOfDeputies.add(deputy);

		if (isGrafter(grafter) == true) {
			deputy.giveGraft();
		}

		System.out.println("Ви додали депутата " + deputy);
	}

	public void removeDeputy() {
		System.out.println("Прізвище депутата, якого хочете видалити");

		Scanner sc = new Scanner(System.in);
		String secondName = sc.next();

		System.out.println("Ім'я депутата, якого хочете видалити");

		sc = new Scanner(System.in);
		String name = sc.next();

		boolean flag = false;

		for (Deputy deputy : listOfDeputies) {
			if (deputy.getName().equalsIgnoreCase(name) && deputy.getSecondName().equalsIgnoreCase(secondName)) {
				flag = true;
			}
		}

		if (true) {
			Iterator<Deputy> iterator = listOfDeputies.iterator();

			while (iterator.hasNext()) {
				Deputy next = iterator.next();

				if (next.getSecondName().equalsIgnoreCase(secondName) && next.getName().equalsIgnoreCase(name)) {
					System.out.println("Видалено депутата " + next);
					iterator.remove();
				}
			}
		} else {
			System.out.println("Такого депутата не знайдено");
		}
	}

	public void showGrafter() {
		for (Deputy deputy : listOfDeputies) {
			if (deputy.isGrafter() == true) {
				System.out.println(deputy.getSecondName() + " " + deputy.getName() + " отримав " + deputy.getGraft());
			}
		}
	}

	public void showBiggestGrafter() {
		Collections.sort(listOfDeputies, new DeputiesGraftComparator());
		if (listOfDeputies.get(0).getGraft() != 0) {
			System.out.println("Найбільший хабарник - " + listOfDeputies.get(0));
		} else {
			System.out.println("У цій фракції хабарників немає");
		}
	}

	public void showAllDeputies() {
		for (Deputy deputy : listOfDeputies) {
			System.out.println(deputy);
		}
	}

	public void cleanFaction() {
		listOfDeputies.clear();
	}

	public boolean isGrafter(int grafter) {
		if (grafter == 1) {
			return true;
		} else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Deputy> getListOfDeputies() {
		return listOfDeputies;
	}

	public void setListOfDeputies(List<Deputy> listOfDeputies) {
		this.listOfDeputies = listOfDeputies;
	}

	@Override
	public String toString() {
		return "Faction [name=" + name + ", listOfDeputies=" + listOfDeputies + "]";
	}

}
