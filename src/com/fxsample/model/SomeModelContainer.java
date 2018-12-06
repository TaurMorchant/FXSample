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
package com.fxsample.model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author VLLA0712
 * @version 1.0 06.12.2018
 */
public class SomeModelContainer
{
    private List<SomeModel> models;

    public SomeModelContainer()
    {
        models = new LinkedList<>();
    }

    public List<SomeModel> getModels()
    {
        return models;
    }

    public void addModel(SomeModel model)
    {
        models.add(model);
    }
}
