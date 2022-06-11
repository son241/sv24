/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0065;

/**
 *
 * @author Admin
 */
public class Student {

    private String name;
    private String className;
    private double math;
    private double physical;
    private double chemistry;

    public Student() {
    }

    public Student(String name, String className, double math, double physical, double chemistry) {
        this.name = name;
        this.className = className;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }
    
    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getAverage() {
        return (math + physical + chemistry) / 3;
    }

    public String getType() {
        if (getAverage() > 7.5) {
            return "A";
        }else if(getAverage() >= 6 && getAverage() <= 7.5){
            return "B";
        }else if(getAverage() >= 4 && getAverage() < 6){
            return "C";
        }
        return "D";
    }

    public void display(){
        System.out.println("Name: " + name);
        System.out.println("Class: " + className);
        System.out.printf("Average: %.2f\n", getAverage());
        System.out.println("Type: " + getType());
    }
    
    
}
