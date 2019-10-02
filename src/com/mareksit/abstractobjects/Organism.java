package com.mareksit.abstractobjects;

import com.mareksit.world.TheWorld;
import java.io.Serializable;

public abstract class Organism  implements Serializable,BasicMethods {
    protected int strenght;
    protected int intitive;
    protected int x;
    protected int y;
    protected int age;
    protected TheWorld referenceToWorld;
    protected String imagePath;

    public Organism(){
        this.imagePath="temp/";
    }

    public Organism(int x,int y){
        this.x=x;
        this.y=y;
        this.imagePath="temp/";
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getIntitive() {
        return intitive;
    }

    public void setIntitive(int intitive) {
        this.intitive = intitive;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TheWorld getReferenceToWorld() {
        return referenceToWorld;
    }

    public void setReferenceToWorld(TheWorld referenceToWorld) { this.referenceToWorld = referenceToWorld; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getImagePath() {
        return imagePath;
    }
}
