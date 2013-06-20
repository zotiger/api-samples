/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.damaico.brick.editor;

import com.tinkerforge.BrickMaster;
import com.tinkerforge.Device;
import com.tinkerforge.IPConnection.TimeoutException;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
    dtd = "-//de.damaico.brick.editor//BrickEditor//EN",
autostore = false)
@TopComponent.Description(
    preferredID = "BrickEditorTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "de.damaico.brick.editor.BrickEditorTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
    displayName = "#CTL_BrickEditorAction",
preferredID = "BrickEditorTopComponent")
@Messages(
{
    "CTL_BrickEditorAction=BrickEditor",
    "CTL_BrickEditorTopComponent=BrickEditor Window",
    "HINT_BrickEditorTopComponent=This is a BrickEditor window"
})
public final class BrickEditorTopComponent extends TopComponent implements LookupListener
{

    public BrickEditorTopComponent()
    {
        initComponents();
        setName(Bundle.CTL_BrickEditorTopComponent());
        setToolTipText(Bundle.HINT_BrickEditorTopComponent());

        Lookup.getDefault().lookupAll(Device.class);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        labelVersion = new javax.swing.JLabel();
        temperaturTextField = new javax.swing.JTextField();
        labelTemperatur = new javax.swing.JLabel();
        version = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(labelVersion, org.openide.util.NbBundle.getMessage(BrickEditorTopComponent.class, "BrickEditorTopComponent.labelVersion.text")); // NOI18N

        temperaturTextField.setText(org.openide.util.NbBundle.getMessage(BrickEditorTopComponent.class, "BrickEditorTopComponent.temperaturTextField.text")); // NOI18N
        temperaturTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                temperaturTextFieldActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(labelTemperatur, org.openide.util.NbBundle.getMessage(BrickEditorTopComponent.class, "BrickEditorTopComponent.labelTemperatur.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(version, org.openide.util.NbBundle.getMessage(BrickEditorTopComponent.class, "BrickEditorTopComponent.version.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTemperatur)
                    .addComponent(labelVersion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(version)
                    .addComponent(temperaturTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVersion)
                    .addComponent(version))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTemperatur)
                    .addComponent(temperaturTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(249, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void temperaturTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_temperaturTextFieldActionPerformed
    {//GEN-HEADEREND:event_temperaturTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_temperaturTextFieldActionPerformed

    Lookup.Result<BrickMaster> devices;    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelTemperatur;
    private javax.swing.JLabel labelVersion;
    private javax.swing.JTextField temperaturTextField;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened()
    {
        //Register to the global context and declare your interest
        devices = Utilities.actionsGlobalContext().lookupResult(BrickMaster.class);
               
        devices.addLookupListener(this);
    }

    @Override
    public void componentClosed()
    {
        devices.removeLookupListener(this);
    }

    void writeProperties(java.util.Properties p)
    {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p)
    {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    public void resultChanged(LookupEvent ev)
    {
        for (Device device : devices.allInstances())
        {
            labelVersion.setText(device.getVersion().toString());

        }
    }
}
