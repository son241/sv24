/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0022;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class FresherCandidate extends Candidate {

    private Date graduationDate;
    private String rankOfGraduation;
    private String education;

    public FresherCandidate() {
    }

    public FresherCandidate(Date graduationDate, String rankOfGraduation, String education, String id, String name, Date birthDay, String address, String phone, String email, int candidateType) {
        super(id, name, birthDay, address, phone, email, candidateType);
        this.graduationDate = graduationDate;
        this.rankOfGraduation = rankOfGraduation;
        this.education = education;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getRankOfGraduation() {
        return rankOfGraduation;
    }

    public void setRankOfGraduation(String rankOfGraduation) {
        this.rankOfGraduation = rankOfGraduation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String toString1() {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + " | " + f.format(graduationDate) + " | " + rankOfGraduation + " | " + education; //To change body of generated methods, choose Tools | Templates.
    }

}
