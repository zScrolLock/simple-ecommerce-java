package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Produto;
import modelo.Venda;
import modelo.Venda_ProdutoPK;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-18T15:21:37")
@StaticMetamodel(Venda_Produto.class)
public class Venda_Produto_ { 

    public static volatile SingularAttribute<Venda_Produto, Venda> venda;
    public static volatile SingularAttribute<Venda_Produto, Venda_ProdutoPK> venda_ProdutoPK;
    public static volatile SingularAttribute<Venda_Produto, Produto> produto;
    public static volatile SingularAttribute<Venda_Produto, Float> valortotal;
    public static volatile SingularAttribute<Venda_Produto, Integer> quantidade;

}