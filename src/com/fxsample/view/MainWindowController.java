/*
 This software is the confidential information and copyrighted work of
 NetCracker Technology Corp. ("NetCracker") and/or its suppliers and
 is only distributed under the terms of a separate license agreement
 with NetCracker.
 Use of the software is governed by the terms of the license agreement.
 Any use of this software not in accordance with the license agreement
 is expressly prohibited by law, and may result in severe civil
 and criminal penalties. 
 
 Copyright (c) 1995-2016 NetCracker Technology Corp.
 
 All Rights Reserved.
 
*/
package com.fxsample.view;

import com.fxsample.model.SomeModel;
import com.fxsample.model.SomeModelContainer;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * @author VLLA0712
 * @version 1.0 06.12.2018
 */
public class MainWindowController
{
    @FXML
    private TableView<SomeModel> table;
    @FXML
    private TableColumn<SomeModel, String> dataColumn;
    @FXML
    private TableColumn<SomeModel, String> transformedDataColumn;

    @FXML
    private void initialize()
    {
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        transformedDataColumn.setCellValueFactory(new DataTransformer());

//        This is also a working version
//        transformedDataColumn.setCellValueFactory(param ->
//                new SimpleObjectProperty<>("transformed data: [" + param.getValue().getData() + "]"));
    }

    @FXML
    public void newWindow() throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/fxsample/view/anotherWindow.fxml"));

        Parent root = loader.load();
        Scene secondScene = new Scene(root, 400, 200);
        Stage newWindow = new Stage();
        newWindow.setTitle("Another Window");
        newWindow.setScene(secondScene);
        newWindow.show();

        SomeModel model = table.getFocusModel().getFocusedItem();
        AnotherWindowController anotherWindowController = loader.getController();
        anotherWindowController.setModel(model);
    }

    public void redraw(SomeModelContainer modelContainer)
    {
        table.setItems(prepareObservableList(modelContainer));
    }

    private ObservableList<SomeModel> prepareObservableList(SomeModelContainer modelContainer)
    {
        return FXCollections.observableArrayList(modelContainer.getModels());
    }
}
