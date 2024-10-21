/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packUser;

/**
 *
 * @author Usuario
 */
public class Produto {
    private static String codigo;
    private static String descricao;
    private static String fabricante;
    private static int quantidade;
    private static float preco;
   
public Produto(){}    
    
    public static void setCodigo(String _codigo){codigo=_codigo;}
    public static void setDescricao(String _descricao){descricao=_descricao;}
    public static void setFabricante(String _fabricante){fabricante=_fabricante;}
    public static void setQuantidade(int _quantidade){quantidade=_quantidade;}
    public static void setPreco(float _preco){preco=_preco;}

    public static String getCodigo(){return codigo;}
    public static String getDescricao(){return descricao;}
    public static String getFabricante(){return fabricante;}
    public static int getQuantidade(){return quantidade;}
    public static float getPreco(){return preco;}

}