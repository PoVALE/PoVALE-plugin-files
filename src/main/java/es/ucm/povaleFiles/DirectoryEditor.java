package es.ucm.povaleFiles;

import es.ucm.povale.parameter.ParameterEditor;
import es.ucm.povaleFiles.entities.FSDirectory;
import es.ucm.povaleFiles.entities.FSFile;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javax.swing.JFileChooser;

public class DirectoryEditor extends ParameterEditor<FSFile> {

    private HBox pane;
    private DirectoryChooser dirChooser;
    private Button selectButton;
    private TextField path;
    private Stage stage;
    private Map<String,String> parameters;

    public DirectoryEditor(Map<String,String> parameters) {
        this.parameters = parameters;
        this.pane = new HBox();
        this.dirChooser = new DirectoryChooser();
        

        this.selectButton = new Button("Abrir");
        this.path = new TextField();
        this.path.setPrefColumnCount(17);
        
        selectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DirectoryChooser directoryChooser = new DirectoryChooser();
                File selectedDirectory = 
                        directoryChooser.showDialog(stage);
                 
                if(selectedDirectory == null){
                    path.setText("No Directory selected");
                }else{
                    path.setText(selectedDirectory.getAbsolutePath());
                }
            }
        });
        pane.getChildren().addAll(path, selectButton);
    }

    @Override
    public Pane getPane() {
        return this.pane;
    }

    @Override
    public FSFile getEntity() {
        return new FSDirectory(Paths.get(path.getText()));
    }

    @Override
    public boolean isValid() {
        return (path != null);
    }
    
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }


}
