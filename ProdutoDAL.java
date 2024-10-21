/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packUser;
import java.sql.*;

/**
 *
 * @author unisanta
 */
public class ProdutoDAL {

    private static Connection con = null;

    public static void conecta()
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/BD/Livros2.mdb", "", "");
        }
        catch (Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void desconecta()
    {
        try 
        {
            con.close();
        }
        catch (Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void inseriCadastro()
    {
        String aux = "INSERT INTO TabProduto (codigo,descricao,fabricante, qtd, preco) VALUES (" + Produto.getCodigo() + ",'" + Produto.getDescricao() + "'," + Produto.getFabricante() + ", "+ Produto.getQuantidade()+", "+ Produto.getPreco()+")";
    
    Erro.setErro(false);
    conecta();
    if (Erro.getErro()) return;
    try {
        Statement st = con.createStatement();
        st.executeUpdate(aux);
        st.close();
    }
    catch(Exception e){ Erro.setErro("Produto não cadastrado!"); }
    finally{desconecta();}
        
       
    }
    
    public static void alteraCadastro()
    {
        Erro.setErro(false);
    conecta();
    if (Erro.getErro()) return;
        try 
        {
        PreparedStatement st = con.prepareStatement("UPDATE TabProduto SET codigo=?, fabricante=?, qtd=?, preco=? WHERE descricao=?");
        st.setString(1,Produto.getCodigo());
        st.setString(2,Produto.getFabricante());
        st.setInt(3,Produto.getQuantidade());        
        st.setFloat(4,Produto.getPreco());
        st.setString(5,Produto.getDescricao());
        st.executeUpdate();
        st.close();
        }
        catch(Exception e)
        {
            Erro.setErro("Produto Não Alterado");
        }
        finally{desconecta();}
    }

    public static void deletaCadastro()
    {
        conecta();
        try
        {
        PreparedStatement st = con.prepareStatement("DELETE FROM TabProduto WHERE descricao=?");
        st.setString(1,Produto.getDescricao());
        st.executeUpdate();
        st.close();
        }
        catch(Exception e)
        {
            Erro.setErro("Produto não Deletado");
        }
        finally{desconecta();}
        
    }
    
    public static void consultaCadastro()
    {
        
        ResultSet rs;

        conecta();
        
        try
        {
            PreparedStatement st = con.prepareStatement("SELECT * FROM TabProduto WHERE descricao=?");
            st.setString(1,Produto.getDescricao());
            rs = st.executeQuery();
            if (rs.next())
            {
                Produto.setFabricante(rs.getString("fabricante"));
                Produto.setQuantidade(rs.getInt("qtd"));
                Produto.setPreco(rs.getFloat("preco"));
                Produto.setDescricao(rs.getString("descricao"));
                st.close();
                return;
            }
            else{
                Erro.setErro("Produto Não Cadastrado");
                st.close();
                return;
            }
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
            
        }
        finally{desconecta();}
    }
}