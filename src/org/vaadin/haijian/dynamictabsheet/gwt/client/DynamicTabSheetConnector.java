/*
 * Copyright 2014 Haijian Wang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.haijian.dynamictabsheet.gwt.client;

import org.vaadin.haijian.dynamictabsheet.DynamicTabSheet;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;

import fi.jasoft.dragdroplayouts.client.ui.tabsheet.DDTabsheetConnector;

@Connect(DynamicTabSheet.class)
public class DynamicTabSheetConnector extends DDTabsheetConnector {
    /**
     * {@inheritDoc}
     */
    private DynamicTabSheetServerRpc rpc = RpcProxy.create(
            DynamicTabSheetServerRpc.class, this);

    @Override
    protected Widget createWidget() {
        DynamicTabSheetWidget widget = GWT.create(DynamicTabSheetWidget.class);
        widget.setRpc(rpc);
        return widget;
    }

    @Override
    public DynamicTabSheetWidget getWidget() {
        return (DynamicTabSheetWidget) super.getWidget();
    }

    @Override
    public DynamicTabSheetState getState() {
        return (DynamicTabSheetState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
    }
}
