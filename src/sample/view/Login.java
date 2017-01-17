package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.Properties;

/**
 * Created by Shehzad on 16-Nov-16.
 */
public class Login {
    //public String currentuser;
    @FXML
    private StackPane anchorLogin;
    @FXML
    private TextField su_user;
    @FXML
    private TextField su_pass;
    @FXML
    private TextField login_user;
    @FXML
    private TextField login_pass;
    @FXML
    private Label statusup;
    @FXML
    private Label logstatus;
    @FXML
    private TextField su_fname;
    @FXML
    public void signBtnOnClick(ActionEvent event) throws IOException {
        String uname = su_user.getText();
        String pass = su_pass.getText();
        String fname =su_fname.getText();
        FileOutputStream fos = new FileOutputStream(uname + ".txt");
        Properties p = new Properties();
        p.setProperty("NAME", uname);
        p.setProperty("PASSWORD", String.valueOf(pass));
        p.setProperty("FULL_NAME",fname);

        p.setProperty("BALANCE",String.valueOf(1000));
        p.save(fos, "ACCOUNT DETAILS...");
        statusup.setText("Account created Successfully !!!");




    }


    @FXML
    public void btnOnClick(ActionEvent event) throws IOException {
        String uname = login_user.getText();
        String pass = login_pass.getText();
        File f = new File(uname + ".txt");

        Properties p = new Properties();
        if (f.exists()) {

            FileInputStream fis = new FileInputStream(uname + ".txt");
            p.load(fis);
            String myname = p.getProperty("NAME");
            String mypass = p.getProperty("PASSWORD");
            //String currentBal = p.getProperty("BALANCE");
            if (myname.equals(uname) && mypass.equals(String.valueOf(pass))) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/view/Application.fxml"));
                loader.load();
                Parent parent = loader.getRoot();
                Scene adminPanelScene = new Scene(parent);
                Stage adminPanelStage = new Stage();

                adminPanelStage.setScene(adminPanelScene);

                adminPanelStage.show();
                try{
                    FileWriter fw=new FileWriter("User.txt");
                    fw.write(myname);
                    fw.close();
                }catch(Exception e){System.out.println(e);}
                //currentuser=myname;
            }
            else{
                logstatus.setText("Incorrect Username or Password !!! ");
            }
        }
        else
        {
            logstatus.setText("Incorrect Username or Password !!! ");
        }
    }
}