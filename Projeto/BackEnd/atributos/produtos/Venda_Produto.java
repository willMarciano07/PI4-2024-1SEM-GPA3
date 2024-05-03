package Projeto.BackEnd.atributos.produtos;

public class Venda_Produto {

    private int ID_vendaProduto;
    private int ID_Produto;
    private double valorTotal;

    public int getID_vendaProduto() {
        return ID_vendaProduto;
    }

    public void setID_vendaProduto(int ID_vendaProduto) {
        this.ID_vendaProduto = ID_vendaProduto;
    }

    public int getID_Produto() {
        return ID_Produto;
    }

    public void setID_Produto(int ID_Produto) {
        this.ID_Produto = ID_Produto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
