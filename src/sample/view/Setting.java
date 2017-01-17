package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Shehzad on 17-Nov-16.
 */
public class Setting {
    @FXML
    private TextField currpass;
    @FXML
    private TextField newpass;


    @FXML
    private Label correctpass;
    @FXML
    private Label statuspass;
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
    public void onBtnChangePass(ActionEvent ae) throws IOException {

        currentuser="";
        setUserName();
        Properties p = new Properties();


        FileInputStream fis = new FileInputStream(currentuser + ".txt");
        p.load(fis);
        String myname = p.getProperty("NAME");
        String mypass = p.getProperty("PASSWORD");
        String mybal =p.getProperty("BALANCE");
        String myfname=p.getProperty("FULL_NAME");


        String currentpass=currpass.getText();
        String latestpass=newpass.getText();
        if(mypass.equals(currentpass))
        {
            FileOutputStream fos = new FileOutputStream(currentuser + ".txt");
            Properties p1 = new Properties();
            p1.setProperty("NAME", myname);
            p1.setProperty("PASSWORD", String.valueOf(latestpass));
            p1.setProperty("FULL_NAME",myfname);
            //int mbal=Integer.parseInt(mybal)-Integer.parseInt(addamount);
            p1.setProperty("BALANCE",String.valueOf(mybal));
            p1.save(fos, "ACCOUNT DETAILS...");
            correctpass.setText("");
            statuspass.setText("Password changed successfully !!!");

            //withdrawField.setText("       Successful");

        }
        else
        {
            statuspass.setText("");
            correctpass.setText("Incorrect password !!!");
        }



    }

}
