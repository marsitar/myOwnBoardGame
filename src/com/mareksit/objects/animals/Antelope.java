package com.mareksit.objects.animals;

import com.mareksit.abstractobjects.Animal;

public class Antelope extends Animal {

    public Antelope(){
        super();
        this.setStrenght(4);
        this.setIntitive(4);
        this.imagePath=this.imagePath+"antylope.png";
    }

    public Antelope(int x,int y){
        super(x,y);
        this.setStrenght(4);
        this.setIntitive(4);
        this.imagePath=this.imagePath+"antylope.png";

    }
}
