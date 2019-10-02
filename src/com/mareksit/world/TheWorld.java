package com.mareksit.world;

import com.mareksit.objects.Human;
import com.mareksit.abstractobjects.Organism;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.mareksit.objects.animals.*;
import com.mareksit.objects.plants.*;

public class TheWorld {
    public static List<Organism> organisms;
    public static Human human_;

    public TheWorld(){
        organisms  = new ArrayList<>();
        human_=new Human(16,11);
    }

    public void doTurn() {
        int counter = 0;
        while(true) {
            try {
                if (organisms.get(counter) instanceof Human) {
                    counter++;
                    continue;
                } else {
                    organisms.get(counter).action();
                    organisms.get(counter).collision();
                }
                counter++;
            } catch (Exception ex) {
                ex.getStackTrace();
                break;
            }
        }
        organisms.sort(Comparator.comparing(Organism::getAge).reversed().thenComparing(Organism::getIntitive).reversed());
    }

    public void drawTheWorld(){
        TheWorld.organisms.add(new Antelope(0,0));
        TheWorld.organisms.add(new Antelope(2,0));
        TheWorld.organisms.add(new Antelope(3,1));
        TheWorld.organisms.add(new CyberSheep(4,1));
        TheWorld.organisms.add(new Fox(6,3));
        TheWorld.organisms.add(new Sheep(7,0));
        TheWorld.organisms.add(new Turtle(8,6));
        TheWorld.organisms.add(new Wolf(9,0));
        TheWorld.organisms.add(new Grass(0,8));
        TheWorld.organisms.add(human_);
        TheWorld.organisms.add(new Guarana(11,5));
        TheWorld.organisms.add(new SosnowskyHogweed(12,0));
        TheWorld.organisms.add(new SowThistle(13,5));
        TheWorld.organisms.add(new Wolfberry(14,9));
    }

    public List<Organism> getOrganisms() {
        return organisms;
    }

}
