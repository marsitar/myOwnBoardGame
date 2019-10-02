package com.mareksit.objects.animals;

import com.mareksit.abstractobjects.Animal;

public class Wolf extends Animal {

    public Wolf(){
        super();
        this.setStrenght(9);
        this.setIntitive(5);
        this.imagePath=this.imagePath+"wolf.png";
    }

    public Wolf(int x,int y){
        super(x,y);
        this.setStrenght(9);
        this.setIntitive(5);
        this.imagePath=this.imagePath+"wolf.png";
    }
}
