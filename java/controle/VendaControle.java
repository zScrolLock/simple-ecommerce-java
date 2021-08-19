/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import static controle.Venda_ProdutoControle.itens;
import ejb.Venda_EJB;
import ejb.Venda_ProdutoEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Usuario;
import modelo.Venda;
import modelo.VendaTipoPagmt;
import modelo.Venda_Produto;
import modelo.Venda_ProdutoPK;
import util.Mensagem;

/**
 *
 * @author zscrollock
 */

@Named
@SessionScoped
public class VendaControle implements Serializable {

    @EJB
    private Venda_EJB vendaEJB;
    
    @Inject
    Venda_ProdutoEJB vpEJB;
    
    private Venda venda;

    private VendaTipoPagmt optionPayment;
    private boolean setOptionPayment = false;
    private int qtdParcelas = 1;
    
    public VendaControle(){
        this.venda = new Venda();
    }
    
    public void setCredito(){
        optionPayment = VendaTipoPagmt.CREDITO;
        setOptionPayment = true;
    }
    
    public void setAVista(){
        optionPayment = VendaTipoPagmt.A_VISTA;
        setOptionPayment = true;
    }
    
    public String createVenda(Usuario user){
        Venda_ProdutoControle vpControl = new Venda_ProdutoControle();
        List<Venda_Produto> itens = vpControl.getItens();
        float valorTot = 0;
        
        venda.setData(new Date());
        venda.setParcelas(this.qtdParcelas);
        venda.setUsuario(user);
        venda.setTipoPagmt(optionPayment);
        venda.setValortotal(0);
        vendaEJB.insert(venda);
        
        insertOnDB(venda);
        
        for (Venda_Produto iten : itens) {
            valorTot = valorTot + (iten.getQuantidade() * iten.getValortotal());
        }
        
        venda.setValortotal(valorTot);
        vendaEJB.update(venda);
        vpControl.setItens(new ArrayList<>());
        Mensagem.showInformacao("Venda Efetuada com Sucesso");
        return "/menu.xhtml";
    }
    
    public void insertOnDB(Venda venda){
        Venda_ProdutoPK vendaPK = new Venda_ProdutoPK();
        Venda_Produto item = new Venda_Produto();
        for (Venda_Produto vpItem : itens) {
            vendaPK.setProduto(vpItem.getProduto().getProductCode());
            vendaPK.setVenda(venda.getIdVenda());
            item.setVenda_ProdutoPK(vendaPK);
            
            item.setProduto(vpItem.getProduto());
            item.setVenda(venda);
            
            item.setQuantidade(vpItem.getQuantidade());
            item.setValortotal((float) (vpItem.getQuantidade() * vpItem.getProduto().getPrice()));
            
            vpEJB.insert(item);
            vendaPK = new Venda_ProdutoPK();
            item = new Venda_Produto();
        }
    }
    
    public String insertVenda(){
        return "/vendaPage.xhtml";
    }

    public Venda_ProdutoEJB getVpEJB() {
        return vpEJB;
    }

    public void setVpEJB(Venda_ProdutoEJB vpEJB) {
        this.vpEJB = vpEJB;
    }

    public boolean isSetOptionPayment() {
        return setOptionPayment;
    }

    public void setSetOptionPayment(boolean setOptionPayment) {
        this.setOptionPayment = setOptionPayment;
    }

    
    
    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public VendaTipoPagmt getOptionPayment() {
        return optionPayment;
    }

    public void setOptionPayment(VendaTipoPagmt optionPayment) {
        this.optionPayment = optionPayment;
    }   
        
    public Venda_EJB getVendaEJB() {
        return vendaEJB;
    }

    public void setVendaEJB(Venda_EJB vendaEJB) {
        this.vendaEJB = vendaEJB;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    
}
