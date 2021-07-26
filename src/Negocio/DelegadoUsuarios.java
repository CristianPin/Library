package Negocio;

import Acceso.UsuarioDAO;
import Acceso.UsuarioVO;
import Presentacion.Login;
import Presentacion.SignIn;

public class DelegadoUsuarios {

    public boolean Login(Login Login) {

        UsuarioVO UVO = new UsuarioVO();
        UVO.setName(Login.txtUser.getText());
        UVO.setPass(Login.txtPass.getText());
        String[] Nombre = new UsuarioDAO().ConsultaUserPass(UVO);

        if (Nombre[0] == null && Nombre[1] == null) {
            return false;
        } else {
            if (Nombre[0].equals(UVO.getName()) && Nombre[1].equals(UVO.getPass())) {
                System.out.println("Creo q funciono");
            }
            return true;
        }
    }
    
    public boolean SignIn(SignIn SignIn){
        UsuarioVO UVO = new UsuarioVO();
        UVO.setName(SignIn.txtName.getText());
        UVO.setPass(SignIn.txtPass.getText());
        UVO.setMail(SignIn.txtMail.getText());
        
        String [] Nombre = new UsuarioDAO().ConsultaUserPass(UVO);
        
        if (Nombre[1] == null){
            new UsuarioDAO().RegistroUser(UVO);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean UserType(Login Login){
        UsuarioVO UVO = new UsuarioVO();
        UVO.setName(Login.txtUser.getText());
        UVO.setPass(Login.txtPass.getText());
        
        String [] Nombre = new UsuarioDAO().ConsultaUserPass(UVO);
        
        if(Nombre [2].equals("Administrador")){
            return true;
        }else{
            return false;
        }
    }
}
