package com.mareksit.repository;

import com.mareksit.abstractobjects.Organism;

import java.util.ArrayList;
import java.util.List;

public class ObjectRepository {
	public static List<Organism> organisms = new ArrayList<>();

	public static List<Organism> getOrganisms() {
		return organisms;
	}

	public static void setOrganisms(List<Organism> organisms) {
		ObjectRepository.organisms = organisms;
	}
}
