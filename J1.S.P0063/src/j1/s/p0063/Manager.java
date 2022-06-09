/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0063;

/**
 *
 * @author Admin
 */
public class Manager {

   
    
    Person inputPersonInfo(String name, String address, double salary) {
        Person p = new Person(name, address, salary);
        return p;
    }
    
    Person[] sortBySalary(Person[] list) {
        Person temp;
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i].getSalary() > list[j].getSalary()) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        return list;
    }
}
