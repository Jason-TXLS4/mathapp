package ca.echocreativeworks.mathapp;

public class Equation {

    //data members
    int a;
    int b;//
    double r;//result

    //constructor
    Equation(int a, int b, double r){
        this.a = a;
        this.b = b;
        this.r = r;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}//end class
