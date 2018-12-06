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
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * @author VLLA0712
 * @version 1.0 06.12.2018
 */
public class AnotherWindowController extends javafx.stage.Window
{
    @FXML
    private Label dataLabel;

    public void setModel(SomeModel model)
    {
        dataLabel.setText(model.getData());
    }
}
