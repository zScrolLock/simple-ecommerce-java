/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import ejb.Venda_ProdutoEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.Produto;
import modelo.Venda_Produto;
import util.Mensagem;


/**
 *
 * @author zscrollock
 */
@Named
@SessionScoped
public class Venda_ProdutoControle implements Serializable{
    
    @EJB
    private Venda_ProdutoEJB venda_prodEJB;
    
    private Venda_Produto venda_prod;
    public static List<Venda_Produto> itens = new ArrayList<Venda_Produto>();
    private boolean plusQuantity;
    
    public Venda_ProdutoControle(){
        this.venda_prod = new Venda_Produto();
    }
    
    public String paymentPage(){
        return "/pagamentoPage.xhtml";
    }
    
    public String insertVendaProduto(Produto prod){
        int index = 0;
     
        if(itens.size() == 0){
            venda_prod.setQuantidade(1);
            double v_total = (prod.getPrice() * venda_prod.getQuantidade());
            venda_prod.setProduto(prod);
            venda_prod.setValortotal((float) v_total);
            this.itens.add(venda_prod);
            System.out.println(itens.toString());
            venda_prod = new Venda_Produto();
            Mensagem.showInformacao("Produto Adicionado ao Carrinho");
            return "/vendaPage.xhtml";
        }else{
            for(int i = 0; i < itens.size(); i++){
                if(prod.getProductCode() == itens.get(i).getProduto().getProductCode()){
                    index = i;
                }
            }
            
            if(itens.get(index).getProduto().getProductCode() == prod.getProductCode()){
                venda_prod.setQuantidade(itens.get(index).getQuantidade()+1);
                double v_total = (prod.getPrice() * venda_prod.getQuantidade());
                venda_prod.setProduto(prod);
                venda_prod.setValortotal((float) v_total);
                this.itens.set(index,venda_prod);
                System.out.println(itens.toString());
                venda_prod = new Venda_Produto();
                Mensagem.showInformacao("Produto Adicionado ao Carrinho");
                return "/vendaPage.xhtml";
            }else{
                venda_prod.setQuantidade(1);
                double v_total = (prod.getPrice() * venda_prod.getQuantidade());
                venda_prod.setProduto(prod);
                venda_prod.setValortotal((float) v_total);
                this.itens.add(venda_prod);
                System.out.println(itens.toString());
                venda_prod = new Venda_Produto();
                Mensagem.showInformacao("Produto Adicionado ao Carrinho");
                return "/vendaPage.xhtml";
            }
        }
    }
    
    public void changeQuantityProductPlus(Produto prod){
        for(int i = 0; i < itens.size(); i++){
            if(itens.get(i).getProduto() == prod){
                if(prod.getQuantity() > itens.get(i).getQuantidade()){
                    itens.get(i).setQuantidade(itens.get(i).getQuantidade() + 1);
                } else{
                    plusQuantity = true;
                }
            }
        }
    }
    
    public void changeQuantityProductMinus(Produto prod){
        for(int i = 0; i < itens.size(); i++){
            if(itens.get(i).getProduto() == prod){
                itens.get(i).setQuantidade(itens.get(i).getQuantidade() - 1);
                if(itens.get(i).getQuantidade() == 0){
                    deleteVendaProduto(prod);
                }
                if(prod.getQuantity() > itens.get(i).getQuantidade()){
                    plusQuantity = false;
                }
            }
        }
    }
    
    public void deleteVendaProduto(Produto prod){
        System.out.println(prod.getDescription() + " | " + prod.getProductCode() );
        for(Iterator<Venda_Produto> iterator = itens.iterator(); iterator.hasNext();){
            Venda_Produto produto = iterator.next();
                if(produto.getProduto().getProductCode() == prod.getProductCode()){
                    iterator.remove();
                }
        }
        
        System.out.println(itens.toString());
    }

    public boolean isPlusQuantity() {
        return plusQuantity;
    }

    public void setPlusQuantity(boolean plusQuantity) {
        this.plusQuantity = plusQuantity;
    }

    public Venda_ProdutoEJB getVenda_prodEJB() {
        return venda_prodEJB;
    }

    public void setVenda_prodEJB(Venda_ProdutoEJB venda_prodEJB) {
        this.venda_prodEJB = venda_prodEJB;
    }  

    public Venda_Produto getVenda_prod() {
        return venda_prod;
    }

    public void setVenda_prod(Venda_Produto venda_prod) {
        this.venda_prod = venda_prod;
    }

    public List<Venda_Produto> getItens() {
        return itens;
    }

    public void setItens(List<Venda_Produto> itens) {
        this.itens = itens;
    }
          
}
