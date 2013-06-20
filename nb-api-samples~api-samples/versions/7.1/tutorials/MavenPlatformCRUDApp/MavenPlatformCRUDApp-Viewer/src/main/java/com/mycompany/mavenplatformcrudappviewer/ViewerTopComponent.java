/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenplatformcrudappviewer;

import com.mycompany.mavenplatformcrudapp.dbaccess.Customer;
import java.awt.BorderLayout;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JTextArea;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//com.mycompany.mavenplatformcrudappviewer//Viewer//EN",
autostore = false)
@TopComponent.Description(preferredID = "ViewerTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "com.mycompany.mavenplatformcrudappviewer.ViewerTopComponent")
@ActionReference(path = "Menu/Window" /*
 * , position = 333
 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_ViewerAction",
preferredID = "ViewerTopComponent")
@Messages({
    "CTL_ViewerAction=Viewer",
    "CTL_ViewerTopComponent=Viewer Window",
    "HINT_ViewerTopComponent=This is a Viewer window"
})
public final class ViewerTopComponent extends TopComponent {

    public ViewerTopComponent() {

        initComponents();

        setName(Bundle.CTL_ViewerTopComponent());
        setToolTipText(Bundle.HINT_ViewerTopComponent());

        setLayout(new BorderLayout());
        JTextArea area = new JTextArea();
        add(area, BorderLayout.CENTER);

        EntityManager entityManager = Persistence.createEntityManagerFactory("com.mycompany_MavenPlatformCRUDApp-dbaccess_nbm_1.0-SNAPSHOTPU").createEntityManager();
        Query query = entityManager.createNamedQuery("Customer.findAll");
        List<Customer> resultList = query.getResultList();
        for (Customer c : resultList) {
            area.append(c.getName() + " (" + c.getCity() + ")" + "\n");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
