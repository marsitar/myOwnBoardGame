package com.mareksit.objects.animals;

import com.mareksit.abstractobjects.Animal;

public class Turtle extends Animal {

    public Turtle(){
        super();
        this.setStrenght(2);
        this.setIntitive(1);
        this.imagePath=this.imagePath+"turtle.png";
    }

    public Turtle(int x,int y){
        super(x,y);
        this.setStrenght(2);
        this.setIntitive(1);
        this.imagePath=this.imagePath+"turtle.png";
    }
}
