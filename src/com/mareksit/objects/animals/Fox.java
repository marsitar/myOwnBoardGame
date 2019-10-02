package com.mareksit.objects.animals;

import com.mareksit.abstractobjects.Animal;

public class Fox extends Animal {

    public Fox(){
        super();
        this.setStrenght(3);
        this.setIntitive(7);
        this.imagePath=this.imagePath+"fox.png";
    }

    public Fox(int x,int y){
        super(x,y);
        this.setStrenght(3);
        this.setIntitive(7);
        this.imagePath=this.imagePath+"fox.png";
    }
}
