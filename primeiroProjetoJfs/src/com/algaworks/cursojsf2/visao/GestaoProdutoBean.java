package com.algaworks.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.dominio.Produto;
		
	/*
	 * Escopos de sessão do jsf aprendidos nesta aula.
	 * 
	 * @SessionScoped
 	 * @ApplicationScoped
 	 * @RequestScoped
 	 * @ViewEscoped
 	 * @noneEscoped
 	 * 
	 */
	
	
@ManagedBean
@ViewScoped
public class GestaoProdutoBean implements Serializable{
	
	private String fabricantePesquisa;
	private List<Produto> listaProduto;
	private Produto produto;
	private Produto produtoSelecionado;
	
	public GestaoProdutoBean() {
		this.produto = new Produto();
		this.listaProduto = new ArrayList<Produto>();
	}
	
	/*
	 *  Inclui um produto na lista de produtos
	 *  e zera o objeto produto para ter ganho de perfomance e 
	 *  Os produtos não se repetirem dentro da lista por estar no escopo de View.
	 */
	public void incluir(){
		System.out.println("incluindo...");
		this.listaProduto.add(produto);
		this.produto = new Produto();
		System.out.println("lista de produtos criada: "+listaProduto);
	}
	
	public String obterAjuda(){
		if(!this.listaProduto.isEmpty()){
			return "ajudaGestaoProdutos?faces-redirect=true";
		}else{
			return "ajudaGestaoProdutosTelefone?faces-redirect=true";
		}
	}
	/*
	 * Antes de incluir o produto, verifico atraves do evento actionListener 
	 * Chamado na linha do componente e executa antes da ação, verificando se o campo
	 * Fabricante foi preenchido.
	 */
	public void verificarInclusao(ActionEvent event){
		System.out.println("Verificando...");
		if("".equals(this.produto.getFabricante())){
			this.produto.setFabricante("Sem fabricante");
			
		}
	}
	
	/*
	 * Após o evento na view <f:setPropertyActionListener que inicia tambpem antes 
	 * do action, o produtoselecionado já possui o valor do produto na linha 
	 * ao clicar ele seleciona esse item e inclui dentro deste objeto.
	 */
	public void excluir(){
		this.listaProduto.remove(this.produtoSelecionado);
	}
	
	public void pesquisar(){
		
	}
	
	public void campoFabricantePesquisaAlterado(ValueChangeEvent event){
		System.out.println("Evento de mudança de valor... 	");
	}
	
	@PostConstruct
	public void inicializar(){
		System.out.println("Inicializou bean!");
		this.listaProduto = new ArrayList<Produto>();
	}
	
	@PreDestroy
	public void finalizar(){
		System.out.println("finalizando Bean!");
	}
	
	public Produto getProduto() {
		return produto;
	}
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}
	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public void setFabricantePesquisa(String fabricantePesquisa) {
		this.fabricantePesquisa = fabricantePesquisa;
	}
	
	public String getFabricantePesquisa(){
		return fabricantePesquisa;
	}

}
