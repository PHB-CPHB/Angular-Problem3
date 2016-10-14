package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-13T14:04:34")
@StaticMetamodel(Car.class)
public class Car_ { 

    public static volatile SingularAttribute<Car, Integer> price;
    public static volatile SingularAttribute<Car, Integer> model_year;
    public static volatile SingularAttribute<Car, Date> registered;
    public static volatile SingularAttribute<Car, String> description;
    public static volatile SingularAttribute<Car, String> model;
    public static volatile SingularAttribute<Car, Integer> id;
    public static volatile SingularAttribute<Car, String> make;

}