/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author hasil
 */
public class EmplyeeModel implements
        Serializable {

    int e_id;
    String name;
    String phone, address;
    int id;
    RecordModel recordmodel;

    public EmplyeeModel() {
    }

    EmplyeeModel(RecordModel rmodel) {
        this.recordmodel = recordmodel; //To change body of generated methods, choose Tools | Templates.
    }

    EmplyeeModel(int e_id, String name, RecordModel rmodel) {
        this.e_id = e_id;
        this.name = name;
        this.recordmodel = rmodel;
    }

    public RecordModel getRecordmodel() {
        return recordmodel;
    }

    public void setRecordmodel(RecordModel recordmodel) {
        this.recordmodel = recordmodel;
    }

    public EmplyeeModel(int e_id, String name, String phone, String adress, int id, RecordModel recordmodel) {
        this.e_id = e_id;
        this.name = name;
        this.phone = phone;
        this.address = adress;
        this.id = id;
        this.recordmodel = recordmodel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmplyeeModel(String name, String adress, String phone, int id) {
        this.name = name;
        this.phone = phone;
        this.address = adress;
        this.id = id;
    }

    public EmplyeeModel(int e_id, String name, String phone, String adress, int id) {
        this.e_id = e_id;
        this.name = name;
        this.phone = phone;
        this.address = adress;
        this.id = id;
    }

    public EmplyeeModel(int e_id, String name, String phone, String adress) {
        this.e_id = e_id;
        this.name = name;
        this.phone = phone;
        this.address = adress;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

}
