package com.mareksit.world;

import com.mareksit.objects.Human;
import com.mareksit.abstractobjects.Organism;

import java.util.Comparator;
import com.mareksit.objects.animals.*;
import com.mareksit.objects.plants.*;
import com.mareksit.repository.ObjectRepository;

public class TheWorld {
    public static Human human_;

    public TheWorld(){
        human_=new Human(16,11);
    }

    public void doTurn() {
        int counter = 0;
        while(true) {
            try {
                if (ObjectRepository.getOrganisms().get(counter) instanceof Human) {
                    counter++;
                    continue;
                } else {
                    ObjectRepository.getOrganisms().get(counter).action();
                    ObjectRepository.getOrganisms().get(counter).collision();
                }
                counter++;
            } catch (Exception ex) {
                ex.getStackTrace();
                break;
            }
        }
        ObjectRepository.getOrganisms().sort(Comparator.comparing(Organism::getAge).reversed().thenComparing(Organism::getIntitive).reversed());
    }

    public void drawTheWorld(){
        ObjectRepository.getOrganisms().add(human_);
        ObjectRepository.getOrganisms().add(new Antelope(0,0));
        ObjectRepository.getOrganisms().add(new Antelope(2,0));
        ObjectRepository.getOrganisms().add(new Antelope(3,1));
        ObjectRepository.getOrganisms().add(new CyberSheep(4,1));
        ObjectRepository.getOrganisms().add(new Fox(6,3));
        ObjectRepository.getOrganisms().add(new Sheep(7,0));
        ObjectRepository.getOrganisms().add(new Turtle(8,6));
        ObjectRepository.getOrganisms().add(new Wolf(9,0));
        ObjectRepository.getOrganisms().add(new Grass(0,8));
        ObjectRepository.getOrganisms().add(new Guarana(11,5));
        ObjectRepository.getOrganisms().add(new SosnowskyHogweed(12,0));
        ObjectRepository.getOrganisms().add(new SowThistle(13,5));
        ObjectRepository.getOrganisms().add(new Wolfberry(14,9));
    }
}
