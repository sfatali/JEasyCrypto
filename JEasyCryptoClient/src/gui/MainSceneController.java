package gui;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.net.InetAddress;

import core.*;

public class MainSceneController extends AbstractSceneController implements ClientObserver {
    private String ERROR_MSG = "There is a problem with the connection to the server. Try to restart the application.";

    private CryptoClient cryptoClient;

    @FXML
    private Button encodeButton;
    @FXML
    private Button decodeButton;
    @FXML
    private Button helpButton;
	@FXML
    private TextField methodTextField;
    @FXML
    private TextArea inputTextArea;
    @FXML
    private TextArea outputTextArea;
    @FXML
    private TextArea keyTextArea;

    public MainSceneController(int id, SceneManager manager, CryptoClient cryptoClient) {
        super(id, manager);
        this.cryptoClient = cryptoClient;
    }

    @FXML
    private void handleEncryptAction(ActionEvent event) {
        String method = methodTextField.getText();
        String data = inputTextArea.getText();
        String key = keyTextArea.getText();
        try{
            cryptoClient.sendEncryptRequest(method, data, key);
        } catch (Exception e) {
            e.printStackTrace();
            outputTextArea.setText(ERROR_MSG);
        }
    }

    @FXML
    private void handleDecryptAction(ActionEvent event) {
        String method = methodTextField.getText();
        String data = inputTextArea.getText();
        String key = keyTextArea.getText();
        try{
            cryptoClient.sendDecryptRequest(method, data, key);
        } catch (Exception e) {
            e.printStackTrace();
            outputTextArea.setText(ERROR_MSG);
        }
    }

    @FXML
    private void handleHelpAction(ActionEvent event) {
        try{
            cryptoClient.sendCapabilityRequest();
        } catch (Exception e) {
            e.printStackTrace();
            outputTextArea.setText(ERROR_MSG);
        }
    }

    public void handleResponse(String response) {
        outputTextArea.setText(response);
    }
}