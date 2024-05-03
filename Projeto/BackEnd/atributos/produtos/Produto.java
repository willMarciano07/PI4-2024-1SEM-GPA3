package Projeto.BackEnd.atributos.produtos;
import Projeto.BackEnd.atributos.pessoas.Pessoa_Vendedora;

public class Produto extends Pessoa_Vendedora {
    
    private int ID_produto;
    private String nomeProduto;
    private double precoUnidade;



    public int getID_produto() {
        return ID_produto;
    }

    public void setID_produto(int ID_produto) {
        this.ID_produto = ID_produto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoUnidade() {
        return precoUnidade;
    }

    public void setPrecoUnidade(double precoUnidade) {
        this.precoUnidade = precoUnidade;
    }
}
