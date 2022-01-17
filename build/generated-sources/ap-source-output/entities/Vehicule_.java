package entities;

import entities.Vehiculegpstracker;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-13T08:27:58")
@StaticMetamodel(Vehicule.class)
public class Vehicule_ { 

    public static volatile SingularAttribute<Vehicule, String> matricule;
    public static volatile SingularAttribute<Vehicule, Integer> id;
    public static volatile SingularAttribute<Vehicule, String> type;
    public static volatile SingularAttribute<Vehicule, String> marque;
    public static volatile ListAttribute<Vehicule, Vehiculegpstracker> vehiculegpstrackerList;

}