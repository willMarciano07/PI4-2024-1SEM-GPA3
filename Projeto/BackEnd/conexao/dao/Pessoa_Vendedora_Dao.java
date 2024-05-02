package Projeto.BackEnd.conexao.dao;

import Projeto.BackEnd.atributos.pessoas.Pessoa_Usuario;
import Projeto.BackEnd.atributos.pessoas.Pessoa_Vendedora;
import Projeto.BackEnd.conexao.mysql.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Pessoa_Vendedora_Dao {

    private Conexao conexao;
    private Connection conectar;

    //Método de Conexão
    public void Pessoa_Usuario_Daos() {
        this.conexao = new Conexao();
        this.conectar = this.conexao.getConexao();
    }
    //Inserir dados na Tabela no SQL

    public void Inserir_Dados(Pessoa_Vendedora Pessoa_Vendedora) throws SQLException {
        //Comando SQL
        String sql = "INSERT INTO Pessoa_Vendedora " + " (nomeUsuario, nomeLogin, senhaUsuario, enderecoUsuario)" + " VALUES (?,?,?,?)";
        try {
            //Comando de Envio
            PreparedStatement stmt = this.conectar.prepareStatement(sql);
            //Ordem de Entrada de dados
            stmt.setString(1, Pessoa_Vendedora.getNomeLogin());
            stmt.setString(2, Pessoa_Vendedora.getNomeUsuario());
            stmt.setString(3, Pessoa_Vendedora.getSenhaUsuario());
            stmt.setString(4, Pessoa_Vendedora.getEnderecoUsuario());
            //Execute Query
            stmt.execute();
            //Fechando terminal
            stmt.close();

            //Mensagem de Cadastro
            JOptionPane.showMessageDialog(null, "Novo Cadastro de Vendedor(a) Inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados no BD_MySQL" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Inserir novo cadastro!");
        }
    }

//Update dados na Tabela no SQL
    public void Update_Dados(Pessoa_Vendedora Pessoa_Vendedora) throws SQLException {
        // Comando SQL
        String sql = "UPDATE Pessoa_Vendedora SET nomeUsuario = ?, nomeLogin = ?, senhaUsuario = ?, enderecoUsuario = ? WHERE id_pessoaUsuario = ?";
        try {
            // Ordem de Entrada de dados
            PreparedStatement stmt = this.conectar.prepareStatement(sql);
            // Ordem de Entrada de dados
            stmt.setString(1, Pessoa_Vendedora.getNomeLogin());
            stmt.setString(2, Pessoa_Vendedora.getNomeUsuario());
            stmt.setString(3, Pessoa_Vendedora.getSenhaUsuario());
            stmt.setString(4, Pessoa_Vendedora.getEnderecoUsuario());
            stmt.setInt(5, Pessoa_Vendedora.getId_pessoaVendedora());
            // Execute Query
            stmt.executeUpdate();
            // Fechando terminal
            stmt.close();
            // Mensagem de Cadastro
            JOptionPane.showMessageDialog(null, "Dados do Vendedor(a) atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao fazer Update dados no BD_MySQL" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar dados do !");
        }
    }
    //Atenção no Parametro
    public void Delete_Dados(Integer id) throws SQLException {
        try {
            PreparedStatement stmt = this.conectar.prepareStatement("DELETE FROM Pessoa_Vendedora WHERE id_pessoaVendedora = ?");
            //Deletar por ID
            stmt.setInt(1, id);

            //Execute Query
            stmt.executeUpdate();
            //Fechando terminal
            stmt.close();

            stmt.execute();
            stmt.close();
            //Mensagem de Cadastro
            JOptionPane.showMessageDialog(null, "Vendedor(a) Deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao Deletar dados no BD_MySQL" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Deletar!");
        }
    }
//Método necessário para possibilitar o preenchimento da Tabela

    public List<Pessoa_Vendedora> obterDadosPessoa_Vendedora() throws SQLException {
        try {
            // Conectar com o banco de dados
            Conexao conect = new Conexao();
            conect.getConexao();

            // Comando do SQL para selecionar a tabela Pessoa_Usuario
            String sql = "SELECT * FROM Pessoa_Vendedora";

            // Executando Query
            PreparedStatement comando = conect.getConexao().prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            // Preparando a lista de Pessoa_Usuario
            List<Pessoa_Vendedora> listaDePessoa_Vendedora = new ArrayList<>();

            // Para cada item retornado do SQL, faça...
            while (resultado.next()) {
                // Criando uma nova instância
                Pessoa_Vendedora dadosPessoa_Vendedora = new Pessoa_Vendedora();

                // Pegando os Seguintes Atributos
                dadosPessoa_Vendedora.setId_pessoaVendedora(resultado.getInt("Id_pessoaUsuario"));
                dadosPessoa_Vendedora.setNomeUsuario(resultado.getString("nomeUsuario"));
                dadosPessoa_Vendedora.setNomeLogin(resultado.getString("nomeLogin"));
                dadosPessoa_Vendedora.setSenhaUsuario(resultado.getString("senhaUsuario"));
                dadosPessoa_Vendedora.setEnderecoUsuario(resultado.getString("enderecoUsuario"));

                // Insere na Lista Local 
                listaDePessoa_Vendedora.add(dadosPessoa_Vendedora);
            }

            // Após terminar, fechar a conexão
            resultado.close();
            comando.close();
            conect.getConexao().close();

            // Retorna a lista de Pessoa_Vendedora
            return listaDePessoa_Vendedora;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}


