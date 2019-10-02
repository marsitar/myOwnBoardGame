package com.mareksit.objects.animals;

import com.mareksit.abstractobjects.Animal;

public class CyberSheep extends Animal {

    public CyberSheep(){
        super();
        this.setStrenght(11);
        this.setIntitive(4);
        this.imagePath=this.imagePath+"cyberSheep.png";
    }

    public CyberSheep(int x,int y){
        super(x,y);
        this.setStrenght(11);
        this.setIntitive(4);
        this.imagePath=this.imagePath+"cyberSheep.png";
    }
}
