package com.pms.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T17:51:02")
@StaticMetamodel(CriticalPathView.class)
public class CriticalPathView_ { 

    public static volatile SingularAttribute<CriticalPathView, Integer> projId;
    public static volatile SingularAttribute<CriticalPathView, String> projectdetails;
    public static volatile SingularAttribute<CriticalPathView, Date> enddate;
    public static volatile SingularAttribute<CriticalPathView, String> taskdetails;
    public static volatile SingularAttribute<CriticalPathView, Double> criticalpdays;
    public static volatile SingularAttribute<CriticalPathView, Date> startdate;
    public static volatile SingularAttribute<CriticalPathView, String> status;

}