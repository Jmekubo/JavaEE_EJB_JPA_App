package com.pms.entities;

import com.pms.entities.Projects;
import com.pms.entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-12T17:51:02")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, String> address;
    public static volatile SingularAttribute<Customers, String> phone;
    public static volatile CollectionAttribute<Customers, Projects> projectsCollection;
    public static volatile SingularAttribute<Customers, Integer> custId;
    public static volatile SingularAttribute<Customers, String> customername;
    public static volatile SingularAttribute<Customers, Users> userId;
    public static volatile SingularAttribute<Customers, String> email;

}