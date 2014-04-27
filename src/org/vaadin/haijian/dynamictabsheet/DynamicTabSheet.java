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
package org.vaadin.haijian.dynamictabsheet;

import org.vaadin.haijian.dynamictabsheet.gwt.client.DynamicTabSheetServerRpc;

import com.vaadin.server.Resource;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

import fi.jasoft.dragdroplayouts.DDTabSheet;
import fi.jasoft.dragdroplayouts.client.ui.LayoutDragMode;
import fi.jasoft.dragdroplayouts.drophandlers.DefaultTabSheetDropHandler;

public class DynamicTabSheet extends DDTabSheet implements
        AddButtonClickListener {

    private AddButtonClickListener addButtonClickListener = this;

    private DynamicTabSheetServerRpc rpc = new DynamicTabSheetServerRpc() {

        @Override
        public void onAddNewTab() {
            addButtonClickListener.onAddNewTab();
        }
    };

    public DynamicTabSheet() {
        setDragMode(LayoutDragMode.CLONE);
        setDropHandler(new DefaultTabSheetDropHandler());
        registerRpc(rpc);
        addStyleName("dynamictabsheet");
    }

    public DynamicTabSheet(AddButtonClickListener addNewTabHandler) {
        this();
        setAddButtonClickListener(addNewTabHandler);
    }

    @Override
    public void onAddNewTab() {
        CssLayout emptyContent = new CssLayout();
        emptyContent.setCaption("Empty");
        addComponent(emptyContent);
    }

    @Override
    public void addComponent(Component c) {
        super.addComponent(c);
        Tab tab = getTab(c);
        decorateTab(tab);
    }

    private void decorateTab(Tab tab) {
        tab.setClosable(true);
        tab.setDescription(tab.getCaption());
    }

    @Override
    public Tab addTab(Component c) {
        Tab tab = super.addTab(c);
        decorateTab(tab);
        return tab;
    }

    @Override
    public Tab addTab(Component c, String caption) {
        Tab tab = super.addTab(c, caption);
        decorateTab(tab);
        return tab;
    }

    @Override
    public Tab addTab(Component c, int position) {
        Tab tab = super.addTab(c, position);
        decorateTab(tab);
        return tab;
    }

    @Override
    public Tab addTab(Component c, String caption, Resource icon) {
        Tab tab = super.addTab(c, caption, icon);
        decorateTab(tab);
        return tab;
    }

    @Override
    public Tab addTab(Component c, String caption, Resource icon, int position) {
        Tab tab = super.addTab(c, caption, icon, position);
        decorateTab(tab);
        return tab;
    }

    public void setAddButtonClickListener(
            AddButtonClickListener addButtonClickListener) {
        this.addButtonClickListener = addButtonClickListener;
    }

}
