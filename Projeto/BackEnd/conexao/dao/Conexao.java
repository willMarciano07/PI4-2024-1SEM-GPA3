package Projeto.BackEnd.conexao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement; 

public class Conexao {

    public Connection getConexao() {
        try {
            //Endereço do database
            String endereco = "jdbc:mysql://127.0.0.1:3306/thinkySys_senac_gpa3";
            //Usuario 
            String usuario = "ThinkSys_Senac";
            //Senha para se acessar o Banco de dados
            String senha = "@ThynkSys04";
            //Driver de Conexão entre banco de dados 
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectar = DriverManager.getConnection(endereco, usuario, senha);
            return conectar;
            //Tratativa de Excessão
        } catch (Exception e) {
            System.out.println("Erro ao tentar conectar-se: " + e);
        }
        return null;
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

