package Projeto.BackEnd.conexao.dao;

import Projeto.BackEnd.atributos.pessoas.Pessoa_Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Pessoa_Usuario_Dao {

    private Conexao conexao;
    private Connection conectar;

    //Método de Conexão
    public void Pessoa_Usuario_Daos() {
        this.conexao = new Conexao();
        this.conectar = this.conexao.getConexao();
    }
    //Inserir dados na Tabela no SQL

    public void Inserir_Dados(Pessoa_Usuario Pessoa_Usuario) throws SQLException {
        //Comando SQL
        String sql = "INSERT INTO Pessoa_Usuario " + " (nomeUsuario, nomeLogin, senhaUsuario, enderecoUsuario)" + " VALUES (?,?,?,?)";
        try {
            //Comando de Envio
            PreparedStatement stmt = this.conectar.prepareStatement(sql);
            //Ordem de Entrada de dados
            stmt.setString(1, Pessoa_Usuario.getNomeLogin());
            stmt.setString(2, Pessoa_Usuario.getNomeUsuario());
            stmt.setString(3, Pessoa_Usuario.getSenhaUsuario());
            stmt.setString(4, Pessoa_Usuario.getEnderecoUsuario());
            //Execute Query
            stmt.execute();
            //Fechando terminal
            stmt.close();

            //Mensagem de Cadastro
            JOptionPane.showMessageDialog(null, "Novo Cadastro de Usuário Inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados no BD_MySQL" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Inserir novo cadastro!");
        }
    }

//Update dados na Tabela no SQL
    public void Update_Dados(Pessoa_Usuario Pessoa_Usuario) throws SQLException {
        // Comando SQL
        String sql = "UPDATE Pessoa_Usuario SET nomeUsuario = ?, nomeLogin = ?, senhaUsuario = ?, enderecoUsuario = ? WHERE id_pessoaUsuario = ?";
        try {
            // Ordem de Entrada de dados
            PreparedStatement stmt = this.conectar.prepareStatement(sql);
            // Ordem de Entrada de dados
            stmt.setString(1, Pessoa_Usuario.getNomeLogin());
            stmt.setString(2, Pessoa_Usuario.getNomeUsuario());
            stmt.setString(3, Pessoa_Usuario.getSenhaUsuario());
            stmt.setString(4, Pessoa_Usuario.getEnderecoUsuario());
            stmt.setInt(5, Pessoa_Usuario.getId_pessoaUsuario());
            // Execute Query
            stmt.executeUpdate();
            // Fechando terminal
            stmt.close();
            // Mensagem de Cadastro
            JOptionPane.showMessageDialog(null, "Dados do Usuário atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao fazer Update dados no BD_MySQL" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar dados do usuário!");
        }
    }
//Delete dados na Tabela no SQL
    //Atenção no Parametro

    public void Delete_Dados(Integer id) throws SQLException {
        try {
            PreparedStatement stmt = this.conectar.prepareStatement("DELETE FROM Pessoa_Usuario WHERE id_pessoaUsuario = ?");
            //Deletar por ID
            stmt.setInt(1, id);

            //Execute Query
            stmt.executeUpdate();
            //Fechando terminal
            stmt.close();

            stmt.execute();
            stmt.close();
            //Mensagem de Cadastro
            JOptionPane.showMessageDialog(null, "Usuário Deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao Deletar dados no BD_MySQL" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Deletar!");
        }
    }
//Método necessário para possibilitar o preenchimento da Tabela

    public List<Pessoa_Usuario> obterDadosPessoa_Usuario() throws SQLException {
        try {
            // Conectar com o banco de dados
            Conexao conect = new Conexao();
            conect.getConexao();

            // Comando do SQL para selecionar a tabela Pessoa_Usuario
            String sql = "SELECT * FROM Pessoa_Usuario";

            // Executando Query
            PreparedStatement comando = conect.getConexao().prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            // Preparando a lista de Pessoa_Usuario
            List<Pessoa_Usuario> listaDePessoa_Usuario = new ArrayList<>();

            // Para cada item retornado do SQL, faça...
            while (resultado.next()) {
                // Criando uma nova instância
                Pessoa_Usuario dadosPessoa_Usuario = new Pessoa_Usuario();

                // Pegando os Seguintes Atributos
                dadosPessoa_Usuario.setId_pessoaUsuario(resultado.getInt("Id_pessoaUsuario"));
                dadosPessoa_Usuario.setNomeUsuario(resultado.getString("nomeUsuario"));
                dadosPessoa_Usuario.setNomeLogin(resultado.getString("nomeLogin"));
                dadosPessoa_Usuario.setSenhaUsuario(resultado.getString("senhaUsuario"));
                dadosPessoa_Usuario.setEnderecoUsuario(resultado.getString("enderecoUsuario"));

                // Insere na Lista Local 
                listaDePessoa_Usuario.add(dadosPessoa_Usuario);
            }

            // Após terminar, fechar a conexão
            resultado.close();
            comando.close();
            conect.getConexao().close();

            // Retorna a lista de Contas_Familia
            return listaDePessoa_Usuario;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
