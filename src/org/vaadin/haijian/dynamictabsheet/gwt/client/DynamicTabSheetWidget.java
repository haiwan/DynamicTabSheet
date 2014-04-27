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

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.ComplexPanel;

import fi.jasoft.dragdroplayouts.client.ui.tabsheet.VDDTabSheet;

public class DynamicTabSheetWidget extends VDDTabSheet {
    private static final String CLASSNAME_ADD_TAB_BTN = "add-tab-btn";

    private DynamicTabSheetServerRpc rpc;

    private final ComplexPanel tabBar;

    private final Element spacer;

    private Element addBtn;

    public DynamicTabSheetWidget() {
        super();

        // Get the tabBar
        tabBar = (ComplexPanel) getChildren().get(0);

        // Get the spacer
        Element tBody = tabBar.getElement();

        spacer = tBody.getChild(tBody.getChildCount() - 1).getChild(0)
                .getChild(0).getChild(0).cast();

        appendAddButton();
    }

    private void appendAddButton() {
        addBtn = DOM.createSpan();
        addBtn.setInnerText("+");
        addBtn.setClassName(CLASSNAME_ADD_TAB_BTN);
        spacer.appendChild(addBtn);
    }

    @Override
    public void onBrowserEvent(Event event) {
        if (event.getTypeInt() == Event.ONCLICK
                && event.getEventTarget().cast() == addBtn) {
            rpc.onAddNewTab();
            event.stopPropagation();
            event.preventDefault();
        }

        super.onBrowserEvent(event);
    }

    public DynamicTabSheetServerRpc getRpc() {
        return rpc;
    }

    public void setRpc(DynamicTabSheetServerRpc rpc) {
        this.rpc = rpc;
    }

}
