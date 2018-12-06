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

import com.fxsample.model.SomeModel;
import com.fxsample.model.SomeModelContainer;

/**
 * @author VLLA0712
 * @version 1.0 06.12.2018
 */
public class Main
{
    public static void main(String[] args)
    {
        //Thread that simulate asynchronous model update
        System.out.println("Start of thread-updater");
        Thread thread = new Thread(() ->
        {
            try
            {
                Thread.sleep(5000);

                System.out.println("Asynchronous model updating");

                SomeModelContainer modelContainer = new SomeModelContainer();
                modelContainer.addModel(new SomeModel("New Model 4"));
                modelContainer.addModel(new SomeModel("New Model 5"));
                modelContainer.addModel(new SomeModel("New Model 6"));
                modelContainer.addModel(new SomeModel("New Model 7"));
                modelContainer.addModel(new SomeModel("New Model 8"));
                modelContainer.addModel(new SomeModel("New Model 9"));

                ViewAPI.getInstance().setModelAndRedraw(modelContainer);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();

        System.out.println("Launch Main Window");
        MainApplication.launch(args);
    }
}
