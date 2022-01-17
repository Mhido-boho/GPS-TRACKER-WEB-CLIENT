package entities;

import entities.Position;
import entities.Vehiculegpstracker;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-13T08:27:58")
@StaticMetamodel(Gpstracker.class)
public class Gpstracker_ { 

    public static volatile SingularAttribute<Gpstracker, Position> idPosition;
    public static volatile SingularAttribute<Gpstracker, Integer> id;
    public static volatile SingularAttribute<Gpstracker, String> simNumber;
    public static volatile ListAttribute<Gpstracker, Vehiculegpstracker> vehiculegpstrackerList;

}