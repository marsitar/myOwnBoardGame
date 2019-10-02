package com.mareksit.objects.animals;

import com.mareksit.abstractobjects.Animal;

public class Sheep extends Animal {

    public Sheep(){
        super();
        this.setStrenght(4);
        this.setIntitive(4);
        this.imagePath=this.imagePath+"sheep.png";
    }

    public Sheep(int x,int y){
        super(x,y);
        this.setStrenght(4);
        this.setIntitive(4);
        this.imagePath=this.imagePath+"sheep.png";
    }
}
