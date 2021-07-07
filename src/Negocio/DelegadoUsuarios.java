package Negocio;

import Acceso.UsuarioDAO;
import Acceso.UsuarioVO;
import Presentacion.Login;

public class DelegadoUsuarios {

    public void consultarUsuario(Login Login) {

        UsuarioVO UVO = new UsuarioVO();
        UVO.setName(Login.txtUser.getText());
        UVO.setPass(Login.txtPass.getText());
        String[] Nombre = new UsuarioDAO().Login(UVO);

        if (Nombre[0] == null && Nombre[1] == null) {
            System.out.println("Usuario y/o Password incorrectos");
        } else {
            if (Nombre[0].equals(UVO.getName()) && Nombre[1].equals(UVO.getPass())) {
                System.out.println("Creo q funciono");
            }
        }
    }
}
