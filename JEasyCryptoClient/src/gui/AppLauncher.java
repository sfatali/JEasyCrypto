package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.net.InetAddress;
import java.net.SocketException;
import java.io.*;

import core.*;

public class AppLauncher extends Application implements SceneManager {
    private final int START_SCENE_ID = 1;
    private final int MAIN_SCENE_ID = 1;
    private final String START_SCENE_PATH = "../views/startScene.fxml";
    private final String MAIN_SCENE_PATH = "../views/mainScene.fxml";
    
    private CryptoClient cryptoClient;
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;
            primaryStage.setTitle("JEasyCrypto");
            StartSceneController controller = new StartSceneController(START_SCENE_ID, this);
            Scene scene = loadScene(controller, START_SCENE_PATH);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop(){
        cleanUp();
    }

    public void handleSceneClose(int id, Object obj) {
        if(id == START_SCENE_ID) {
            try {
                InetAddress address = (InetAddress) obj;
                cryptoClient = new CryptoClient(address);

                MainSceneController controller = new MainSceneController(MAIN_SCENE_ID, this, cryptoClient);
                cryptoClient.setObserver(controller);
                Scene scene = loadScene(controller, MAIN_SCENE_PATH);
                primaryStage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
                cleanUp();
                System.exit(0);
            } 
        }
        else {
            System.exit(0);
        }
    }

    private Scene loadScene(AbstractSceneController controller, String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setController(controller);
        Parent root = loader.load();
        return new Scene(root, 600, 400); 
    }

    private void cleanUp() {
        if(cryptoClient != null){
            cryptoClient.stop();
        }
    }
}