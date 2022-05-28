/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0022;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ExperienceCandidate extends Candidate {

    private double expInYear;
    private String proSkill;

    public ExperienceCandidate() {
    }

    public ExperienceCandidate(String id, String name, Date birthDay, String address, String phone, String email, int candidateType, double expInYear, String proSkill) {
        super(id, name, birthDay, address, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public double getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(double expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + expInYear + " | " + proSkill; //To change body of generated methods, choose Tools | Templates.

    }

}
