package com.mareksit.objects.plants;

import com.mareksit.abstractobjects.Plant;

public class Wolfberry extends Plant {
    public Wolfberry(int x,int y){
        super(x,y);
        this.setStrenght(99);
        this.imagePath=this.imagePath+"wolferry.png";
    }
}
