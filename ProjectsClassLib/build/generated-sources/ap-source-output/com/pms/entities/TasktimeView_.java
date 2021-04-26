package com.pms.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T17:51:02")
@StaticMetamodel(TasktimeView.class)
public class TasktimeView_ { 

    public static volatile SingularAttribute<TasktimeView, String> projectdetails;
    public static volatile SingularAttribute<TasktimeView, Date> enddate;
    public static volatile SingularAttribute<TasktimeView, String> taskdetails;
    public static volatile SingularAttribute<TasktimeView, Double> taskdays;
    public static volatile SingularAttribute<TasktimeView, Long> id;
    public static volatile SingularAttribute<TasktimeView, Date> startdate;
    public static volatile SingularAttribute<TasktimeView, String> status;

}