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
@Table(name = "tasktime_view")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TasktimeView.findAll", query = "SELECT t FROM TasktimeView t")
    , @NamedQuery(name = "TasktimeView.findByProjectdetails", query = "SELECT t FROM TasktimeView t WHERE t.projectdetails = :projectdetails")
    , @NamedQuery(name = "TasktimeView.findByTaskdetails", query = "SELECT t FROM TasktimeView t WHERE t.taskdetails = :taskdetails")
    , @NamedQuery(name = "TasktimeView.findByStartdate", query = "SELECT t FROM TasktimeView t WHERE t.startdate = :startdate")
    , @NamedQuery(name = "TasktimeView.findByEnddate", query = "SELECT t FROM TasktimeView t WHERE t.enddate = :enddate")
    , @NamedQuery(name = "TasktimeView.findByStatus", query = "SELECT t FROM TasktimeView t WHERE t.status = :status")
    , @NamedQuery(name = "TasktimeView.findByTaskdays", query = "SELECT t FROM TasktimeView t WHERE t.taskdays = :taskdays")})
public class TasktimeView implements Serializable {

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
    @Basic(optional = false)
    @Column(name = "taskdays")
    private double taskdays;
    @Id
    private Long id;

    public TasktimeView() {
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

    public double getTaskdays() {
        return taskdays;
    }

    public void setTaskdays(double taskdays) {
        this.taskdays = taskdays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
