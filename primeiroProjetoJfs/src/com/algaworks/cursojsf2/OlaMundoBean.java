package com.algaworks.cursojsf2;


public class OlaMundoBean {
	private String nome;
	
	
	public OlaMundoBean() {
		
	}
	
	
	public String enviar(){
		 this.setNome(this.getNome().toUpperCase());
		 return "";
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
