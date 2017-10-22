package gui;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javafx.fxml.FXML;

public class StartSceneController extends AbstractSceneController {
    @FXML
	private Button startButton;
	@FXML
    private TextField serverAddrTextField;
    @FXML
    private Label errorLabel;
    
    public StartSceneController(int id, SceneManager manager) {
        super(id, manager);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String addressString = serverAddrTextField.getText();
        InetAddress address = validateAddress(addressString);

        if(address != null){
            notifyClosure(address);
        } else {
            errorLabel.setText("Invalid server address");
        }
    }

    private InetAddress validateAddress(String address) {
		InetAddress addr;
		try {
			addr = InetAddress.getByName(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			addr = null;
		}
		return addr;
	}
}