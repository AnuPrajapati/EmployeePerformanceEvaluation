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
public class RecordModel {

    public RecordModel(String final_result) {
        this.final_result = final_result;
    }

    String final_result;
    double communication, work_product, adaptability, reliablity, attitude, attendance, mean;
    int e_id, r_id, status;

    public String getFinal_result() {
        return final_result;
    }

    public void setFinal_result(String final_result) {
        this.final_result = final_result;
    }

    public RecordModel() {
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public RecordModel(double communication, double work_product, double adaptability, double reliablity, double attitude, double attendance, int e_id) {
        this.communication = communication;
        this.work_product = work_product;
        this.adaptability = adaptability;
        this.reliablity = reliablity;
        this.attitude = attitude;
        this.attendance = attendance;
        this.e_id = e_id;
    }

    public RecordModel(double communication, double work_product, double adaptability, double reliablity, double attitude, double attendance, int e_id, int r_id) {
        this.communication = communication;
        this.work_product = work_product;
        this.adaptability = adaptability;
        this.reliablity = reliablity;
        this.attitude = attitude;
        this.attendance = attendance;
        this.e_id = e_id;
        this.r_id = r_id;
    }

    public RecordModel(double communication, double work_product, double adaptability, double reliablity, double attitude, double attendance) {
        this.communication = communication;
        this.work_product = work_product;
        this.adaptability = adaptability;
        this.reliablity = reliablity;
        this.attitude = attitude;
        this.attendance = attendance;
    }

    public RecordModel(double communication, double work_product, double adaptability, double reliablity, double attitude, double attendance, double mean, String final_result) {
        this.communication = communication;
        this.work_product = work_product;
        this.adaptability = adaptability;
        this.reliablity = reliablity;
        this.attitude = attitude;
        this.attendance = attendance;
        this.mean = mean;
        this.final_result = final_result;
    }

    public RecordModel(double communication, double work_product, double adaptability, double reliablity, double attitude, double attendance, double mean) {
        this.communication = communication;
        this.work_product = work_product;
        this.adaptability = adaptability;
        this.reliablity = reliablity;
        this.attitude = attitude;
        this.attendance = attendance;
        this.mean = mean;
    }

    public double getCommunication() {
        return communication;
    }

    public void setCommunication(double communication) {
        this.communication = communication;
    }

    public double getWork_product() {
        return work_product;
    }

    public void setWork_product(double work_product) {
        this.work_product = work_product;
    }

    public double getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(double adaptability) {
        this.adaptability = adaptability;
    }

    public double getReliablity() {
        return reliablity;
    }

    public void setReliablity(double reliablity) {
        this.reliablity = reliablity;
    }

    public double getAttitude() {
        return attitude;
    }

    public void setAttitude(double attitude) {
        this.attitude = attitude;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public RecordModel(double communication, double work_product, double adaptability, double reliablity, double attitude, double attendance, int e_id, int r_id, int status) {
        this.communication = communication;
        this.work_product = work_product;
        this.adaptability = adaptability;
        this.reliablity = reliablity;
        this.attitude = attitude;
        this.attendance = attendance;
        this.e_id = e_id;
        this.r_id = r_id;
        this.status = status;
    }

    public RecordModel(double communication, double work_product, double adaptability, double reliablity, double attitude, double attendance, int e_id, int r_id, int status, String final_result) {
        this.communication = communication;
        this.work_product = work_product;
        this.adaptability = adaptability;
        this.reliablity = reliablity;
        this.attitude = attitude;
        this.attendance = attendance;
        this.e_id = e_id;
        this.r_id = r_id;
        this.status = status;
        this.final_result = final_result;
    }

}
