package com.pms.entities;

import com.pms.entities.Projects;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T17:51:02")
@StaticMetamodel(Tasks.class)
public class Tasks_ { 

    public static volatile SingularAttribute<Tasks, Projects> projId;
    public static volatile SingularAttribute<Tasks, Date> enddate;
    public static volatile SingularAttribute<Tasks, String> taskdetails;
    public static volatile SingularAttribute<Tasks, Date> startdate;
    public static volatile SingularAttribute<Tasks, Integer> taskId;
    public static volatile SingularAttribute<Tasks, String> status;

}