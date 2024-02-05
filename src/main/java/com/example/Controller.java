package com.example;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller implements Initializable { // "implements Initializable" is used for ChoiceBox to work properly
    @FXML
    Label genderLabel;
    @FXML
    Label topSLabel;
    @FXML
    Label rightSLabel;
    @FXML
    Label leftSLabel;
    @FXML
    Label progressLabel;
    @FXML
    Label spinnerLabel;
    @FXML
    Label listViewLabel;
    @FXML
    Label treeViewLabel;
    @FXML
    Label someLabel;
    @FXML
    Label keyLabel;
    @FXML
    TextField genderField;
    @FXML
    DatePicker datePicker;
    @FXML
    ColorPicker colorPicker;
    @FXML
    ChoiceBox<String> choiceBox;
    String[] choices = { "Choice1", "Choice2", "Choice3", "Choice4" };
    @FXML
    Slider topSlider;
    @FXML
    Slider leftSlider;
    @FXML
    Slider rightSlider;
    @FXML
    ProgressBar progressBar;
    double progress = 0.0;
    @FXML
    Spinner<Integer> spinner;
    int currentSpinnerValue;
    @FXML
    ListView<String> listView;
    String[] engines = { "I4", "I6", "V6", "V8", "V10" };
    String currentEngine;
    @FXML
    TreeView<String> treeView;

    private Scene scene;
    private Stage stage;
    private Parent root;

    public void radContinue(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    public void btnContinue(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("scene3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    public void boxContinue(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("scene4.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    public void tfContinue(ActionEvent event) throws IOException {
        try {
            int answer = Integer.parseInt(genderField.getText());
            root = FXMLLoader.load(getClass().getResource("scene5.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.toFront();
        } catch (NumberFormatException e) {
            genderLabel.setText("Use digits, or you will get an error");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dateContinue(ActionEvent event) throws IOException {
        LocalDate myDate = datePicker.getValue();
        root = FXMLLoader.load(getClass().getResource("scene6.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    public void colorContinue(ActionEvent event) throws IOException {
        Color myColor = colorPicker.getValue();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene7.fxml"));
        root = loader.load();

        // Get the controller from the loader
        Controller controller = loader.getController();

        // Call the separate method to initialize the ChoiceBox, because the original one is called when program is launched, but scene7 is not loaded, if I have only one scene, I should be able to work with original 'initialize()' method
        controller.initializeChoiceBox();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    public void choiceContinue(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene8.fxml"));
        root = loader.load();

        Controller controller = loader.getController();

        controller.initializeSlider();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    public void sliderContinue(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene9.fxml"));
        root = loader.load();

        Controller controller = loader.getController();
        controller.initializeProgressBar();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    public void progressBarContinue(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene10.fxml"));
        root = loader.load();

        Controller controller = loader.getController();
        controller.initializeSpinner();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    public void spinnerContinue(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene11.fxml"));
        root = loader.load();

        Controller controller = loader.getController();
        controller.initializeListView();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    public void listViewContinue(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene12.fxml"));
        root = loader.load();

        Controller controller = loader.getController();
        controller.initializeTreeView();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    public void treeViewContinue(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene13.fxml"));
        root = loader.load();

        scene = new Scene(root);
        scene.setOnKeyPressed(event1 -> {
            System.out.println("You pressed key " + event1.getCode());
        });
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    public void panesBarEventContinue(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override // this method is created when I add "implements Initializable" to my Controller
    public void initialize(URL location, ResourceBundle resources) {
        // in this program, this method will not be used, because the initializable items aren't added in first scene.
    }

    public void initializeChoiceBox() {
        choiceBox.getItems().addAll(choices);
    }

    public void initializeSlider() {
        topSLabel.setText("Top slider value: " + (int) topSlider.getValue());
        leftSLabel.setText("Left slider value: " + (int) leftSlider.getValue());
        rightSLabel.setText("Right slider value: " + (int) rightSlider.getValue());
        topSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                topSLabel.setText("Top slider value: " + (int) topSlider.getValue());
            }
        });
        leftSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                leftSLabel.setText("Left slider value: " + (int) leftSlider.getValue());
            }
        });
        rightSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                rightSLabel.setText("Right slider value: " + (int) rightSlider.getValue());
            }
        });
    }

    public void initializeProgressBar() {
        progressBar.setStyle("-fx-accent: purple;");
    }

    public void initializeSpinner() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);

        valueFactory.setValue(1);

        spinner.setValueFactory(valueFactory);

        currentSpinnerValue = spinner.getValue();
        spinnerLabel.setText(Integer.toString(currentSpinnerValue));

        spinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                currentSpinnerValue = spinner.getValue();
                spinnerLabel.setText(Integer.toString(currentSpinnerValue));
            }

        });
    }

    public void initializeListView() {
        listView.getItems().addAll(engines);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                currentEngine = listView.getSelectionModel().getSelectedItem();
                listViewLabel.setText("Selected engine: " + currentEngine);
            }
        });
    }

    public void initializeTreeView() {
        TreeItem<String> rootItem = new TreeItem<String>("Files");

        TreeItem<String> branchItem1 = new TreeItem<String>("Pictures",
                new ImageView(new Image(getClass().getResourceAsStream("img/pictures.gif"), 25.0, 25.0, true, true)));
        TreeItem<String> branchItem2 = new TreeItem<String>("Movies",
                new ImageView(new Image(getClass().getResourceAsStream("img/movies.gif"), 25.0, 25.0, true, true)));
        TreeItem<String> branchItem3 = new TreeItem<String>("Music",
                new ImageView(new Image(getClass().getResourceAsStream("img/music.gif"), 25.0, 25.0, true, true)));

        TreeItem<String> leafItem1 = new TreeItem<String>("Picture 1",
                new ImageView(new Image(getClass().getResourceAsStream("img/picture.gif"), 25.0, 25.0, true, true)));
        TreeItem<String> leafItem2 = new TreeItem<String>("Picture 2",
                new ImageView(new Image(getClass().getResourceAsStream("img/picture.gif"), 25.0, 25.0, true, true)));
        TreeItem<String> leafItem3 = new TreeItem<String>("Movie 1",
                new ImageView(new Image(getClass().getResourceAsStream("img/movie.gif"), 25.0, 25.0, true, true)));
        TreeItem<String> leafItem4 = new TreeItem<String>("Movie 2",
                new ImageView(new Image(getClass().getResourceAsStream("img/movie.gif"), 25.0, 25.0, true, true)));
        TreeItem<String> leafItem5 = new TreeItem<String>("Song 1",
                new ImageView(new Image(getClass().getResourceAsStream("img/song.gif"), 25.0, 25.0, true, true)));
        TreeItem<String> leafItem6 = new TreeItem<String>("Song 2",
                new ImageView(new Image(getClass().getResourceAsStream("img/song.gif"), 25.0, 25.0, true, true)));

        branchItem1.getChildren().addAll(leafItem1, leafItem2);
        branchItem2.getChildren().addAll(leafItem3, leafItem4);
        branchItem3.getChildren().addAll(leafItem5, leafItem6);

        rootItem.getChildren().addAll(branchItem1, branchItem2, branchItem3);

        treeView.setShowRoot(false); // Because there's only 1 root, I've hidden it

        treeView.setRoot(rootItem);
    }

    public void selectItem() {
        TreeItem<String> currentTreeItem = treeView.getSelectionModel().getSelectedItem();
        if (currentTreeItem != null)
            treeViewLabel.setText("Selected item: " + currentTreeItem.getValue());
    }

    public void addProgress() {
        if (progress < 0.9) { // Conditions looks strange because double datatype is not very precise, and 1 is actually 0.999999999...
            progress += 0.1;
            progressBar.setProgress(progress);
            progressLabel.setText("Progress: " + Integer.toString((int) Math.round(progress * 100)) + "%");
        }
    }

    public void retractProgress() {
        if (progress > 0.0) { // I let progress bar go below 0 because a nice animation will appear in this case
            progress -= 0.1;
            progressBar.setProgress(progress);
            progressLabel.setText("Progress: " + Integer.toString((int) Math.round(progress * 100)) + "%");
        }
    }

    public void newMethod() {
        someLabel.setText("Something happened!");
    }
}
