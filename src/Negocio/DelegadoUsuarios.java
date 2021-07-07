package Negocio;

import Acceso.UsuarioDAO;
import Acceso.UsuarioVO;
import Presentacion.Login;


public class DelegadoUsuarios {
    
    public void consultarUsuario(Login Login){
        UsuarioVO UVO = new UsuarioVO();
        UVO.setMail(Login.txtUser.getText());
        UVO.setName(Login.txtPass.getText());
        String Nombre2 = Login.txtPass.getText();
        String Nombre = new UsuarioDAO().Login(UVO);
        
        if(Nombre.equals(Nombre2)){
            System.out.println("Creo q funciono");
        }else{
            System.out.println("O talvez no");
        }
    }
}
