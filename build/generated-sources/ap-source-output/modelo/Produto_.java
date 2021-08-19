package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.ProdutoStatus;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-18T15:21:37")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Integer> productCode;
    public static volatile SingularAttribute<Produto, Integer> quantity;
    public static volatile SingularAttribute<Produto, Double> price;
    public static volatile SingularAttribute<Produto, String> name;
    public static volatile SingularAttribute<Produto, String> description;
    public static volatile SingularAttribute<Produto, Date> validadeDate;
    public static volatile SingularAttribute<Produto, byte[]> archive;
    public static volatile SingularAttribute<Produto, String> photoName;
    public static volatile SingularAttribute<Produto, ProdutoStatus> status;

}