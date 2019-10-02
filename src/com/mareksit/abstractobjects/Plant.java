package com.mareksit.abstractobjects;

public abstract class Plant extends Organism{

    public Plant(int x,int y){
        super(x,y);
        this.intitive=0;
        this.strenght=0;
    }

    @Override
    public void action(){

    }

    @Override
    public void collision(){

    }

    @Override
    public void drawing(){

    }
}
