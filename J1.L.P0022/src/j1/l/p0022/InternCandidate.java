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
public class InternCandidate extends Candidate {

    private String major;
    private String semester;
    private String university;

    public InternCandidate() {
    }

    public InternCandidate(String major, String semester, String university, String id, String name, Date birthDay, String address, String phone, String email, int candidateType) {
        super(id, name, birthDay, address, phone, email, candidateType);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String toString1() {
        return super.toString() + " | " + major + " | " + semester + " | " + university; //To change body of generated methods, choose Tools | Templates.
    }

}
