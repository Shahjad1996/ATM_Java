package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Shahjad on 21-Oct-16.
 */
public class Controller implements Initializable {


    @FXML
    private StackPane acContent;
    @FXML
    private ScrollPane leftSideBarScroolPan;
    @FXML
    private ToggleButton sideMenuToogleBtn;
    @FXML
    private ImageView imgMenuBtn;
    @FXML
    private BorderPane appContent;
    @FXML
    private Button btnLogOut;
    @FXML
    private MenuItem miPopOver;
    @FXML
    private AnchorPane acDashBord;
    @FXML
    private AnchorPane acHead;
    @FXML
    private AnchorPane acMain;
    @FXML
    private MenuButton mbtnUsrInfoBox;
    @FXML
    private Button btnHome;
    @FXML
    private ImageView imgHomeBtn;
    @FXML
    private Button btnStore;
    @FXML
    private ImageView imgStoreBtn;
    @FXML
    private Button btnEmplopye;
    @FXML
    private ImageView imgEmployeBtn;
    @FXML
    private Button btnSell;
    @FXML
    private ImageView imgSellBtn;
    @FXML
    private Button btnSettings;
    @FXML
    private ImageView imgSettingsBtn;
    @FXML
    private Button btnAbout;
    @FXML
    private ImageView imgAboutBtn;
    @FXML
    private Label lblUsrName;
    @FXML
    private Label lblUsrNamePopOver;
    @FXML
    private Label lblFullName;
    @FXML
    private Label lblRoleAs;
    @FXML
    private Hyperlink hlEditUpdateAccount;
    @FXML
    private Circle imgUsrTop;
    @FXML
    private Circle circleImgUsr;
    @FXML
    private Label UsrName;

    String currentuser="";
    String defultStyle = "-fx-border-width: 0px 0px 0px 5px;"
            + "-fx-border-color:none";

    String activeStyle = "-fx-border-width: 0px 0px 0px 5px;"
            + "-fx-border-color:royalblue";
    public void setUserName()
    {
        try{
            FileInputStream fin=new FileInputStream("User.txt");
            int i=0;
            while((i=fin.read())!=-1){
                currentuser=currentuser+""+((char)i);
            }
            fin.close();
        }catch(Exception e){}

        UsrName.setText(currentuser);
        lblUsrNamePopOver.setText(currentuser);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*try{
            FileInputStream fin=new FileInputStream("User.txt");
            int i=0;
            while((i=fin.read())!=-1){
                currentuser=currentuser+""+((char)i);
            }
            fin.close();
        }catch(Exception e){}*/

        Image usrImg = new Image("/sample/img/user.png");
        imgUsrTop.setFill(new ImagePattern(usrImg));
        //System.out.println(currentuser);
        circleImgUsr.setFill(new ImagePattern(usrImg));
        /*UsrName.setText(currentuser);
        lblUsrNamePopOver.setText(currentuser);*/
    }
    Image home = new Image("/sample/icon/home.png");
    Image homeRed = new Image("/sample/icon/homeRed.png");
    Image stock = new Image("/sample/icon/stock.png");
    Image stockRed = new Image("/sample/icon/stockRed.png");
    Image sell = new Image("/sample/icon/sell2.png");
    Image sellRed = new Image("/sample/icon/sell2Red.png");
    Image employee = new Image("/sample/icon/employe.png");
    Image employeeRed = new Image("/sample/icon/employeRed.png");
    Image setting = new Image("/sample/icon/settings.png");
    Image settingRed = new Image("/sample/icon/settingsRed.png");
    Image about = new Image("/sample/icon/about.png");
    Image aboutRed = new Image("/sample/icon/aboutRed.png");

    @FXML
    public void btnHomeOnClick(ActionEvent event){
        homeActive();
        currentuser="";
        UsrName.setText(currentuser);
        lblUsrNamePopOver.setText(currentuser);
        setUserName();
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/sample/view/Home.fxml").openStream());
        } catch (IOException e) {

        }
        AnchorPane root = fxmlLoader.getRoot();
        acContent.getChildren().clear();
        acContent.getChildren().add(root);



    }
    @FXML
    private void mbtnOnClick(ActionEvent event) {

    }
    @FXML
    private void btnAboutOnClick(ActionEvent event) {

        try {
            aboutActive();
            currentuser="";
            UsrName.setText(currentuser);
            lblUsrNamePopOver.setText(currentuser);
            setUserName();

            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/sample/view/AboutMe.fxml").openStream());

            AnchorPane anchorPane = fXMLLoader.getRoot();
            acContent.getChildren().clear();
            acContent.getChildren().add(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnWithdrawOnClick(ActionEvent event) {

        try {
            aboutWithdraw();
            currentuser="";
            UsrName.setText(currentuser);
            lblUsrNamePopOver.setText(currentuser);
            setUserName();
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/sample/view/withdraw.fxml").openStream());

            AnchorPane anchorPane = fXMLLoader.getRoot();
            acContent.getChildren().clear();
            acContent.getChildren().add(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnDepositOnClick(ActionEvent event) {

        try {
            aboutDeposit();
            currentuser="";
            UsrName.setText(currentuser);
            lblUsrNamePopOver.setText(currentuser);
            setUserName();
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/sample/view/deposit.fxml").openStream());

            AnchorPane anchorPane = fXMLLoader.getRoot();
            acContent.getChildren().clear();
            acContent.getChildren().add(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnLogout(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/sample/view/Login.fxml"));
        loader.load();
        Parent parent = loader.getRoot();
        Scene adminPanelScene = new Scene(parent);
        Stage adminPanelStage = new Stage();

        adminPanelStage.setScene(adminPanelScene);

        adminPanelStage.show();
    }

    @FXML
    private void btnStoreOnClick(ActionEvent event) throws IOException {

        try {
            storeActive();
            currentuser="";
            UsrName.setText(currentuser);
            lblUsrNamePopOver.setText(currentuser);
            setUserName();
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/sample/view/Account.fxml").openStream());

//            SellController sellController = fXMLLoader.getController();
//            sellController.acMainSells.getStylesheets().add("/sample.style/MainStyle.css");
//            sellController.tbtnSellOnAction(event);
            AnchorPane anchorPane = fXMLLoader.getRoot();
            acContent.getChildren().clear();
            acContent.getChildren().add(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnSettingsOnClick(ActionEvent event) throws IOException {
        settingsActive();
        currentuser="";
        UsrName.setText(currentuser);
        lblUsrNamePopOver.setText(currentuser);
        setUserName();
        //inithilize Setting Controller
        //SettingsController settingController = new SettingsController();
        //inithilize UserNameMedia
        //userNameMedia usrMedia = new userNameMedia();
        // Define a loader to inithilize Settings.fxml controller
        FXMLLoader settingLoader = new FXMLLoader();
        //set the location of Settings.fxml by fxmlloader
        settingLoader.load(getClass().getResource("/sample/view/Settings.fxml").openStream());

        /*
        Send id to userMedia
        usrMedia.setId(id);
        take control of settingController elements or node
        SettingsController settingControl = settingLoader.getController();
        settingControl.bpSettings.getStylesheets().add("/sample.style/MainStyle.css");
        settingControl.setUsrMedia(usrMedia);
        settingControl.miMyASccountOnClick(event);
        settingControl.settingPermission();
        */

        AnchorPane acPane = settingLoader.getRoot();
        //acContent clear and make useul for add next node
        acContent.getChildren().clear();
        //add a node call "acPane" to acContent
        acContent.getChildren().add(acPane);

    }
    private void homeActive() {
        imgHomeBtn.setImage(homeRed);
        imgStoreBtn.setImage(employee);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(sell);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(activeStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }
    private void aboutActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(employee);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(sell);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(aboutRed);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(activeStyle);
    }
    private void storeActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(employeeRed);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(sell);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(activeStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }
    private void settingsActive() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(employee);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(sell);
        imgSettingsBtn.setImage(settingRed);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(activeStyle);
        btnAbout.setStyle(defultStyle);
    }
    private void aboutWithdraw() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(employee);
        imgSellBtn.setImage(sellRed);
        imgEmployeBtn.setImage(sell);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(activeStyle);
        btnEmplopye.setStyle(defultStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }
    private void aboutDeposit() {
        imgHomeBtn.setImage(home);
        imgStoreBtn.setImage(employee);
        imgSellBtn.setImage(sell);
        imgEmployeBtn.setImage(sellRed);
        imgSettingsBtn.setImage(setting);
        imgAboutBtn.setImage(about);
        btnHome.setStyle(defultStyle);
        btnStore.setStyle(defultStyle);
        btnSell.setStyle(defultStyle);
        btnEmplopye.setStyle(activeStyle);
        btnSettings.setStyle(defultStyle);
        btnAbout.setStyle(defultStyle);
    }

}
