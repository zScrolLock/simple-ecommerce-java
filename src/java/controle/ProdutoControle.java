/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import ejb.ProdutoEJB;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Produto;
import modelo.ProdutoStatus;
import java.util.Date;
import org.primefaces.PrimeFaces;
import org.primefaces.model.file.UploadedFile;
import util.Mensagem;

/**
 *
 * @author zscrollock
 */
@Named
@SessionScoped
public class ProdutoControle implements Serializable {

    @EJB
    private ProdutoEJB productEJB;

    private List<Produto> productList;
    private Produto selectedProduct;
    private Produto prod;

    private UploadedFile file;
    private boolean isUpload = false;
    
    private List<Produto> aux;
    private String productName = "";

    public ProdutoControle() {
        this.prod = new Produto();
    }

    public String otherPage() {
        return "/clientes/tablePageCliente.xhtml";
    }

    public int productListLength() {
        return this.productList.size();
    }
    
    public String setProductVenda(int code, String name, String description, double price, int quantity, ProdutoStatus status, Date validade, String photoName, byte[] archive){
        Venda_ProdutoControle vp = new Venda_ProdutoControle();
        this.prod = new Produto();
        this.prod.setProductCode(code);
        this.prod.setName(name);
        this.prod.setDescription(description);
        this.prod.setPrice(price);
        this.prod.setQuantity(quantity);
        this.prod.setStatus(status);
        this.prod.setValidadeDate(validade);
        this.prod.setPhotoName(photoName);
        this.prod.setArchive(archive);
        vp.insertVendaProduto(this.prod);
        this.prod = new Produto();
        Mensagem.showInformacao("Produto Adicionado ao Carrinho");
        return "/vendaPage.xhtml";
    }
    
    public void insertProduct() {
        if (this.prod.getArchive() == null) {
            Mensagem.showAlerta("Selecione uma Imagem para o Produto");
            return;
        }

        if (this.prod.getQuantity() <= 3) {
            this.prod.setStatus(ProdutoStatus.INDISPONIVEL);
        } else {
            this.prod.setStatus(ProdutoStatus.DISPONIVEL);
        }

        this.productEJB.insert(prod);
        System.out.println(prod);
        this.prod = new Produto();
        isUpload = false;
        this.search();
        Mensagem.showInformacao("Produto cadastrado com Sucesso");
        PrimeFaces.current().executeScript("PF('dialogCadastro').hide()");
    }

    public void deleteProduct() {
        if (this.selectedProduct == null) {
            Mensagem.showAlerta("Selecione um Produto");
            return;
        }
        this.productEJB.delete(this.selectedProduct);
        this.selectedProduct = null;
        Mensagem.showInformacao("Produto deletado com Sucesso");

        this.search();
    }

    public void upload() {
        System.out.println(file.getFileName());
        prod.setPhotoName(file.getFileName());
        prod.setArchive(file.getContent());
        isUpload = true;
        FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String searchProduct() {

        if (this.productName.equals(" ") || this.productName.equals("")) {
            Mensagem.showAlerta("Campo em Branco");
            return "/menu.xhtml";
        } else {
            aux = this.productEJB.findByName(productName);
            System.out.println(aux.toString());

            if (!aux.isEmpty()) {
                this.prod = aux.get(0);
                this.productName = "";
                Mensagem.showInformacao("Produto encontrado");
                return "/tableProductUnique.xhtml";
            } else {
                this.productName = "";
                Mensagem.showErro("Produto nao Encontrado");
                return "/menu.xhtml";
            }
        }
    }

    @PostConstruct
    private void search() {
        productName = "";
        this.productList = this.productEJB.findAll();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProdutoEJB getProductEJB() {
        return productEJB;
    }

    public void setProductEJB(ProdutoEJB productEJB) {
        this.productEJB = productEJB;
    }

    public List<Produto> getProductList() {
        return productList;
    }

    public void setProductList(List<Produto> productList) {
        this.productList = productList;
    }

    public Produto getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Produto selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public boolean isIsUpload() {
        return isUpload;
    }

    public void setIsUpload(boolean isUpload) {
        this.isUpload = isUpload;
    }

    public List<Produto> getAux() {
        return aux;
    }

    public void setAux(List<Produto> aux) {
        this.aux = aux;
    }
    
    
}
