package ipc1_proyecto2_202500708;

import vista.Login;

public class IPC1_Proyecto2_202500708 {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();
                login.setVisible(true);
                }
            }
        );
    }
}