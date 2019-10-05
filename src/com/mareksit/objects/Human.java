package com.mareksit.objects;

import com.mareksit.abstractobjects.Animal;

public class Human extends Animal {
    private boolean isSpecial;

    public Human(int x,int y){
        super(x,y);
        this.setStrenght(5);
        this.setIntitive(4);
        this.isSpecial=false;
        this.imagePath=this.imagePath+"human2.png";
    }
//    @Override
//    public void action(){
//
//    }
}
