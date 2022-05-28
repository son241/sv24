/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0022;

/**
 *
 * @author Admin
 */
public interface IManager {
    public void createExperience() throws Exception;
    public void createFresher() throws Exception;
    public void createIntern() throws Exception;
    public void updateById(int option)throws Exception;
    public void searchByName(int type, String name);
    public void deleteById(int option);
    public void reportName();
    public void reportInformation(int op);
}
