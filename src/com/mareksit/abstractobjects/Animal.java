package com.mareksit.abstractobjects;

import com.mareksit.world.TheWorld;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal extends Organism{
    int pX,pY;
    boolean isCollision;

    public Animal(){
        super();
    }

    public Animal(int x,int y){
        super(x,y);
        isCollision=true;
        pX=this.x;
        pY=this.y;
    }
    @Override
    public void action() {
        this.pX=this.x;
        this.pY=this.y;

        int[] coord = this.changePosition(this.x,this.y);
        this.x=coord[0];
        this.y=coord[1];
    }

    @Override
    public void collision(){
        System.out.println("------------------------"+this+"------------------------");
        for(Organism organism:TheWorld.organisms){
            if(organism.getX()==this.x){
                if(organism.getY()==this.y){
                    if(organism.equals(this)){
                        continue;
                    }
                    System.out.println(organism.getClass().getSimpleName()+this.getClass().getSimpleName());
                    if(organism.getClass().getSimpleName().equals(this.getClass().getSimpleName())){ ///!!!! Pamietac ze zjebane, prawidlowa wersja zawiera zbadanie czy trofilo sie na swoj gatunek zeby sie porozmnazac
                        //!!!!!!!!!!trzeba tu wdrozyc rozmnartzanie i powrot pierwotnego obiektu na pozycje na pozycje i oraz j
                        //1.powrot na pozycje
                        System.out.println("kolizja-rozmanarzanie organizmow");

                        this.x=this.pX;
                        this.y=this.pY;
                        try {

                            String className = this.getClass().getSimpleName();
                            System.out.println(className);
                            //////////////////////
                            TheWorld.organisms.add(getClass().newInstance()); //to jest spierdolone, trzeba uzyskac informacje jaka klase dodawac
                            Organism o = TheWorld.organisms.get(TheWorld.organisms.size() - 1);
                            //////////////////////



                            int[] coor=new int[2];
                            while(isCollision) {
                                coor = this.changePosition(this.x, this.y);
                                this.isCollision=this.coolisionChceker(coor[0], coor[1]);
                            }
                            o.setX(coor[0]);
                            o.setY(coor[1]);
                            System.out.println("blok try zakonczony");
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("kolizja-walka miedzy organizmami");
                        List<Organism> list=TheWorld.organisms;

                        if(organism.getStrenght()>this.getStrenght()){
                            System.out.println("kolizja-walka miedzy organizmami-wygrywa obcy organizm");
                            boolean notDeleted=true;
                            int counter=0;
                            while (notDeleted){
                                if (list.get(counter).equals(this)){
                                    System.out.println(this +" this zostal usuniety");
                                    TheWorld.organisms.remove(counter);
                                    notDeleted=false;
                                }
                                counter++;
                            }
                        } else {
                            System.out.println("kolizja-walka miedzy organizmami-wygrywa obecny organizm");
                            boolean notDeleted=true;
                            int counter=0;
                            while (notDeleted){
                                if (list.get(counter).equals(organism)) {
                                    System.out.println(organism + " organism zostal usuniety");
                                    TheWorld.organisms.remove(counter);
                                    notDeleted=false;
                                }
                                counter++;
                            }
                        }
                    }
                    break;
                }
            }
        }
    }

    @Override
    public void drawing(){

    }

    public int[] changePosition (int x, int y){
        System.out.println("xs: " + x + ",ys: " + y);
        int[] coord = new int[2];
        coord[0] = x + ((int) ((Math.random() * 3) - 1));
        coord[1] = y + ((int) ((Math.random() * 3) - 1));
        if(this.spatialChecker(coord[0],coord[1])==false||(coord[0]==x&&coord[1]==y)){
            changePosition (x,y);
        }
        System.out.println("x: " + coord[0] + ",y: " + coord[1]);
        return coord;
    }
    //funkcja moze booleanowa ktora bedzie sprawdzala czy wpsolrzedne są dobre
    public static boolean spatialChecker(int x,int y){
        boolean flag=true;
        if (x<0&&x>=20&&y<0&&y>=20) {
            flag=false;
        }
        return flag;
    }
    public static boolean coolisionChceker(int x,int y){
        boolean flag=false;
        for(Organism o:TheWorld.organisms) {
            if(o.getX()==x && o.getY()==y){
                flag=true;
            }
        }
        return flag;
    }
}
