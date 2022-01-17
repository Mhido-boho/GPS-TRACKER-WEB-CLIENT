package entities;

import entities.Gpstracker;
import entities.Vehicule;
import entities.VehiculegpstrackerPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-13T08:27:58")
@StaticMetamodel(Vehiculegpstracker.class)
public class Vehiculegpstracker_ { 

    public static volatile SingularAttribute<Vehiculegpstracker, VehiculegpstrackerPK> vehiculegpstrackerPK;
    public static volatile SingularAttribute<Vehiculegpstracker, Date> dateDebut;
    public static volatile SingularAttribute<Vehiculegpstracker, Vehicule> vehicule;
    public static volatile SingularAttribute<Vehiculegpstracker, Date> dateFin;
    public static volatile SingularAttribute<Vehiculegpstracker, Gpstracker> gpstracker;

}