package atividade1;
import view.FrmLogin;
import dao.DaoUsuario;
import model.Usuario;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Atividade1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoUsuario dao= new DaoUsuario();
        List<Usuario> usuariosdobanco = new ArrayList<Usuario>();
        usuariosdobanco = dao.getUsuarios();        
        
        
        for(int i=0;i<usuariosdobanco.size();i++){    
            JOptionPane.showMessageDialog(null,"Id: "+usuariosdobanco.get(i).id+"\nNome: "+usuariosdobanco.get(i).nome);    
        }
 // new FrmLogin().setVisible(true);
    
}
}