package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;
import modelo.VendaTipoPagmt;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-18T15:21:37")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Integer> parcelas;
    public static volatile SingularAttribute<Venda, Date> data;
    public static volatile SingularAttribute<Venda, Float> valortotal;
    public static volatile SingularAttribute<Venda, Usuario> usuario;
    public static volatile SingularAttribute<Venda, Integer> idVenda;
    public static volatile SingularAttribute<Venda, VendaTipoPagmt> tipoPagmt;

}