/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import model.Usuario;
import conexao.Conexao;
import javax.swing.JOptionPane;
public class DaoUsuario {
    
Connection con = null;    
PreparedStatement pstm = null;    
public List<Usuario> getUsuarios()
{
    List<Usuario> lista= new ArrayList<Usuario>();
    con = new Conexao().conectarBanco();
    try{
    pstm = con.prepareStatement("SELECT * FROM tb_usuario",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ResultSet rs = pstm.executeQuery();
    if(rs.first())
    {
        do{
           Usuario usuario = new Usuario();
           usuario.id = rs.getInt("id");
           usuario.nome = rs.getString("nome");
           usuario.senha = rs.getString("senha");        
           usuario.email = rs.getString("email");      
           usuario.tipo = rs.getInt("tipo");
           
           lista.add(usuario);
        }while(rs.next());
        
    }
    pstm.close();
    }catch(SQLException err)
    {
        JOptionPane.showMessageDialog(null,"Erro ao buscar dados da tabela usuario: " +err);
    }
    return lista;
}
}
