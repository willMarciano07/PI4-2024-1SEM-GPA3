package Projeto.BackEnd.atributos.produtos;

public class Compras {
    
    private int ID_Produto;
    private int ID_Compra;
    int ID_pessoaUsuario;
    private int ID_vendaProduto;

    public int getID_Produto() {
        return ID_Produto;
    }

    public void setID_Produto(int ID_Produto) {
        this.ID_Produto = ID_Produto;
    }

    public int getID_Compra() {
        return ID_Compra;
    }

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public int getID_vendaProduto() {
        return ID_vendaProduto;
    }

    public void setID_vendaProduto(int ID_vendaProduto) {
        this.ID_vendaProduto = ID_vendaProduto;
    }
    

}
