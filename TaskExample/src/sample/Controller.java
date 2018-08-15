package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {

    @FXML
    private ListView listView;

    @FXML
    private ProgressBar progressBar;

    private Service<ObservableList<String>> service;

    public void initialize() {
        service = new EmployeeService();

        progressBar.progressProperty().bind(service.progressProperty());
        listView.itemsProperty().bind(service.valueProperty());

        progressBar.visibleProperty().bind(service.runningProperty());

    }

    @FXML
    public void buttonPressed() {
        if(service.getState() == Service.State.SUCCEEDED) {
            service.reset();
            service.start();
        } else if(service.getState() == Service.State.READY) {
            service.start();
        }
    }
}
