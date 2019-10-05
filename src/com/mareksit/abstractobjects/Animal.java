package com.mareksit.abstractobjects;

import com.mareksit.repository.ObjectRepository;

import java.util.List;
import java.util.Random;

public abstract class Animal extends Organism {
	int pX;
	int pY;
	boolean isCollision;

	public Animal() {
		super();
	}

	public Animal(int x, int y) {
		super(x, y);
		isCollision = true;
		pX = this.x;
		pY = this.y;
	}

	@Override
	public void action() {
		this.pX = this.x;
		this.pY = this.y;

		int[] coord = this.changePosition(this.x, this.y);
		this.x = coord[0];
		this.y = coord[1];
	}

	@Override
	public void collision() {
		System.out.println("------------------------" + this + "------------------------");
		for (Organism organism : ObjectRepository.getOrganisms()) {
			if (organism.getX() == this.x) {
				if (organism.getY() == this.y) {
					if (organism.equals(this)) {
						continue;
					}
					System.out.println(organism.getClass().getSimpleName() + this.getClass().getSimpleName());
					if (organism.getClass().getSimpleName().equals(this.getClass().getSimpleName())) {
						this.x = this.pX;
						this.y = this.pY;
						try {
							ObjectRepository.getOrganisms().add((Organism)this.clone());
						} catch (CloneNotSupportedException e) {
							e.printStackTrace();
						}
						Organism bornedOrganism = ObjectRepository.getOrganisms().get(ObjectRepository.getOrganisms().size() - 1);
						int[] coordinatesOfBornedOrganism = new int[2];
						while (isCollision) {
							coordinatesOfBornedOrganism = this.changePosition(this.x, this.y);
							this.isCollision = collisionChecker(coordinatesOfBornedOrganism[0], coordinatesOfBornedOrganism[1]);
						}
						bornedOrganism.setX(coordinatesOfBornedOrganism[0]);
						bornedOrganism.setY(coordinatesOfBornedOrganism[1]);
					} else {
						List<Organism> list = ObjectRepository.getOrganisms();
						if (organism.getStrenght() > this.getStrenght()) {
							boolean notDeleted = true;
							int counter = 0;
							while (notDeleted) {
								if (list.get(counter).equals(this)) {
									ObjectRepository.getOrganisms().remove(counter);
									notDeleted = false;
								}
								counter++;
							}
						} else {
							boolean notDeleted = true;
							int counter = 0;
							while (notDeleted) {
								if (list.get(counter).equals(organism)) {
									ObjectRepository.getOrganisms().remove(counter);
									notDeleted = false;
								}
								counter++;
							}
						}
					}
					break;
				}
			}
		}
	}

	@Override
	public void drawing() {

	}

	private int[] changePosition(int x, int y) {
		System.out.println("xs: " + x + ",ys: " + y);
		int[] coordinates = new int[2];
		do {
			int dx =new Random().ints(-1,2).findFirst().getAsInt();
			int dy =new Random().ints(-1,2).findFirst().getAsInt();
			coordinates[0] = x + dx;
			coordinates[1] = y + dy;
			System.out.println("x: " + coordinates[0] + ",y: " + coordinates[1]);
		} while(!spatialChecker(coordinates[0], coordinates[1]) || (coordinates[0] == x && coordinates[1] == y));
		return coordinates;
	}

	public static boolean spatialChecker(int x, int y) {
		boolean isPositionCorrect = true;
		if (x < 0 || x >= 20 || y < 0 || y >= 20) {
			isPositionCorrect = false;
		}
		return isPositionCorrect;
	}

	private static boolean collisionChecker(int x, int y) {
		return ObjectRepository
				.getOrganisms()
				.stream()
				.anyMatch(o ->
						o.getX() == x && o.getY() == y);
	}
}
