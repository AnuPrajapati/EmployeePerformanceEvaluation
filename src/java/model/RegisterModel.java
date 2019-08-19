/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hasil
 */
public class RegisterModel {

    int id;
    String username, password, companyname, managername;

    public RegisterModel(String username, String password, String companyname, String managername) {
        this.username = username;
        this.password = password;
        this.companyname = companyname;
        this.managername = managername;
    }

    public RegisterModel(int id, String username, String password, String companyname, String managername) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.companyname = companyname;
        this.managername = managername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

}
