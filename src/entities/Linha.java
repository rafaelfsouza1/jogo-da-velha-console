package entities;

public class Linha {
	
	private String linha;
	private Integer quantidade;
	
	public Linha(String linha, Integer quantidade) {
		this.linha = linha;
		this.quantidade = quantidade;
	}

	public String getLinha() {
		return linha;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

}
