/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John Mekubo
 */
@Entity
@Table(name = "customer_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerView.findAll", query = "SELECT c FROM CustomerView c")
    , @NamedQuery(name = "CustomerView.findByProjectdetails", query = "SELECT c FROM CustomerView c WHERE c.projectdetails = :projectdetails")
    , @NamedQuery(name = "CustomerView.findByCustomername", query = "SELECT c FROM CustomerView c WHERE c.customername = :customername")
    , @NamedQuery(name = "CustomerView.findByTaskdetails", query = "SELECT c FROM CustomerView c WHERE c.taskdetails = :taskdetails")
    , @NamedQuery(name = "CustomerView.findByStatus", query = "SELECT c FROM CustomerView c WHERE c.status = :status")})
public class CustomerView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "projectdetails")
    private String projectdetails;
    @Basic(optional = false)
    @Column(name = "customername")
    private String customername;
    @Basic(optional = false)
    @Column(name = "taskdetails")
    private String taskdetails;
    @Column(name = "status")
    private String status;
    @Id
    private int custId;

    public CustomerView() {
    }

    public String getProjectdetails() {
        return projectdetails;
    }

    public void setProjectdetails(String projectdetails) {
        this.projectdetails = projectdetails;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getTaskdetails() {
        return taskdetails;
    }

    public void setTaskdetails(String taskdetails) {
        this.taskdetails = taskdetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }
    
}
