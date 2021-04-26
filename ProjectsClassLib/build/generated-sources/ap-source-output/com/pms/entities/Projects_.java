package com.pms.entities;

import com.pms.entities.Customers;
import com.pms.entities.Tasks;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T17:51:02")
@StaticMetamodel(Projects.class)
public class Projects_ { 

    public static volatile SingularAttribute<Projects, Integer> projId;
    public static volatile SingularAttribute<Projects, String> projectdetails;
    public static volatile SingularAttribute<Projects, Date> enddate;
    public static volatile SingularAttribute<Projects, Customers> custId;
    public static volatile CollectionAttribute<Projects, Tasks> tasksCollection;
    public static volatile SingularAttribute<Projects, Date> startdate;

}