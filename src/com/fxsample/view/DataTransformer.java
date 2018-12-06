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
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 * @author VLLA0712
 * @version 1.0 06.12.2018
 */
//Dates for tasks may be transformed by same way
public class DataTransformer implements Callback<TableColumn.CellDataFeatures<SomeModel, String>, ObservableValue<String>>
{
    @Override
    public ObservableValue<String> call(TableColumn.CellDataFeatures<SomeModel, String> param)
    {
        SimpleObjectProperty<String> property = new SimpleObjectProperty<>();

        property.setValue("transformed data: [" + param.getValue().getData() + "]");

        return property;
    }
}
