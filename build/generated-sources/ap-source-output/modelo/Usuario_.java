package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.UsuarioEnum;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-18T15:21:37")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, UsuarioEnum> level;
    public static volatile SingularAttribute<Usuario, String> name;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, String> login;

}