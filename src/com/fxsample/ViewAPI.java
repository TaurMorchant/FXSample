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
package com.fxsample;

import com.fxsample.model.SomeModelContainer;
import com.fxsample.view.MainWindowController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * @author VLLA0712
 * @version 1.0 06.12.2018
 */
public class ViewAPI
{
    private static final ViewAPI instance = new ViewAPI();

    public static ViewAPI getInstance()
    {
        return instance;
    }

    private ViewAPI()
    {
    }

    public void setModelAndRedraw(SomeModelContainer modelContainer)
    {
        synchronized (instance)
        {
            System.out.println("Redraw main window with new model");
            Platform.runLater(() ->
            {
                try
                {
                    FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/com/fxsample/view/mainWindow.fxml"));
                    MainApplication.getPrimaryStage().setScene(new Scene(loader.load()));

                    MainWindowController mainWindowController = loader.getController();
                    mainWindowController.redraw(modelContainer);
                    MainApplication.getPrimaryStage().show();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            });
        }
    }
}
