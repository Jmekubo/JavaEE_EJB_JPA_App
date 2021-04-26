/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John Mekubo
 */
@Entity
@Table(name = "critical_path_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriticalPathView.findAll", query = "SELECT c FROM CriticalPathView c")
    , @NamedQuery(name = "CriticalPathView.findByProjectdetails", query = "SELECT c FROM CriticalPathView c WHERE c.projectdetails = :projectdetails")
    , @NamedQuery(name = "CriticalPathView.findByTaskdetails", query = "SELECT c FROM CriticalPathView c WHERE c.taskdetails = :taskdetails")
    , @NamedQuery(name = "CriticalPathView.findByStartdate", query = "SELECT c FROM CriticalPathView c WHERE c.startdate = :startdate")
    , @NamedQuery(name = "CriticalPathView.findByEnddate", query = "SELECT c FROM CriticalPathView c WHERE c.enddate = :enddate")
    , @NamedQuery(name = "CriticalPathView.findByStatus", query = "SELECT c FROM CriticalPathView c WHERE c.status = :status")
    , @NamedQuery(name = "CriticalPathView.findByCriticalpdays", query = "SELECT c FROM CriticalPathView c WHERE c.criticalpdays = :criticalpdays")})
public class CriticalPathView implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "projectdetails")
    private String projectdetails;
    @Basic(optional = false)
    @Column(name = "taskdetails")
    private String taskdetails;
    @Basic(optional = false)
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Basic(optional = false)
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Column(name = "status")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "criticalpdays")
    private Double criticalpdays;
    @Id
    private int projId;

    public CriticalPathView() {
    }

    public String getProjectdetails() {
        return projectdetails;
    }

    public void setProjectdetails(String projectdetails) {
        this.projectdetails = projectdetails;
    }

    public String getTaskdetails() {
        return taskdetails;
    }

    public void setTaskdetails(String taskdetails) {
        this.taskdetails = taskdetails;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getCriticalpdays() {
        return criticalpdays;
    }

    public void setCriticalpdays(Double criticalpdays) {
        this.criticalpdays = criticalpdays;
    }

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }
    
}
