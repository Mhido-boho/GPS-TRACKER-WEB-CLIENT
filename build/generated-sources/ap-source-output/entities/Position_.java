package entities;

import entities.Gpstracker;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-13T08:27:58")
@StaticMetamodel(Position.class)
public class Position_ { 

    public static volatile SingularAttribute<Position, Integer> id;
    public static volatile SingularAttribute<Position, Double> laltitude;
    public static volatile ListAttribute<Position, Gpstracker> gpstrackerList;
    public static volatile SingularAttribute<Position, Double> longitude;

}