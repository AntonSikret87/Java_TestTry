package ua.stqa.java_testtry.sandbox;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class Equetion {

    private double a;
    private double b;
    private double c;

    private  int n;

    public Equetion(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;

        double d = b*b-4*a*c;

        if(d>0){
            n=2;
        }else {
            if(d==0){
                n=1;
            }else {
                n=0;
            }
        }
    }

    public int rootNumber(){
        return n;
    }
}
