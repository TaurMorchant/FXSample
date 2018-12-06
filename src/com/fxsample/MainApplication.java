package com.fxsample;

import com.fxsample.model.SomeModel;
import com.fxsample.model.SomeModelContainer;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application
{
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        MainApplication.primaryStage = primaryStage;
        primaryStage.setTitle("Main Window");

        //Initial Model
        SomeModelContainer modelContainer = new SomeModelContainer();
        modelContainer.addModel(new SomeModel("Model 1"));
        modelContainer.addModel(new SomeModel("Model 2"));
        modelContainer.addModel(new SomeModel("Model 3"));

        ViewAPI.getInstance().setModelAndRedraw(modelContainer);
    }

    public static void launch(String[] args)
    {
        Application.launch(args);
    }

    public static Stage getPrimaryStage()
    {
        return primaryStage;
    }
}
