package com.mareksit.objects.plants;

import com.mareksit.abstractobjects.Plant;

public class Grass extends Plant {
    public Grass(int x,int y){
        super(x,y);
        this.imagePath=this.imagePath+"grass.png";
    }
}
