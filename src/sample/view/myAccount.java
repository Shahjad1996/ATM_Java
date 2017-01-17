package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class myAccount {
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl4;
    @FXML
    private Button btnInfo;

    String currentuser = "";

    public void setUserName() {
        try {
            FileInputStream fin = new FileInputStream("User.txt");
            int i = 0;
            while ((i = fin.read()) != -1) {
                currentuser = currentuser + "" + ((char) i);
            }
            fin.close();
        } catch (Exception e) {
        }


    }



    @FXML
    public void onBtnClickInfo(ActionEvent ae) throws IOException {

        currentuser="";
        setUserName();
        Properties p = new Properties();


            FileInputStream fis = new FileInputStream(currentuser + ".txt");
            p.load(fis);
            String myname = p.getProperty("NAME");
            String mypass = p.getProperty("PASSWORD");
            String mybal =p.getProperty("BALANCE");
            String myfname=p.getProperty("FULL_NAME");
        //System.out.println(myname);
            lbl1.setText(myfname);
            lbl2.setText(myname);
            lbl3.setText(mybal);
            lbl4.setText(mypass);



    }
}