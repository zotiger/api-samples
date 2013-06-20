/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myorg.myeditor;

import java.awt.BorderLayout;
import org.myorg.api.Event;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.NbBundle;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.TopComponent;

/**
 *
 * @author Geertjan
 */
@TopComponent.Description(
        preferredID = "MyEditorTopComponent",
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(
        mode = "editor",
openAtStartup = true)
@ActionID(
        category = "Window",
id = "org.myorg.myeditor.MyEditorTopComponent")
@ActionReference(
        path = "Menu/Window")
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_MyEditorActio")
@NbBundle.Messages({
    "CTL_MyEditorActio=MyEditor"
})
public class MyEditor extends TopComponent implements ExplorerManager.Provider {

    private final ExplorerManager mgr = new ExplorerManager();

public MyEditor() {

    initComponents();
    Event obj = new Event();
    associateLookup(ExplorerUtils.createLookup(mgr, getActionMap()));

    setLayout(new BorderLayout());
    add(new BeanTreeView(), BorderLayout.CENTER);

    setDisplayName("MyEditor " + obj.getIndex());

    mgr.setRootContext(new AbstractNode(Children.create(new EventChildFactory(), true)));

}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public ExplorerManager getExplorerManager() {
        return mgr;
    }
    
}
