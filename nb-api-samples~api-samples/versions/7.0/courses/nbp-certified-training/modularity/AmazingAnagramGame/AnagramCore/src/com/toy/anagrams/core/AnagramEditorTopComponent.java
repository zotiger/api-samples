/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toy.anagrams.core;

import com.toy.anagrams.api.WordLibrary;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.openide.awt.Mnemonics;
import org.openide.util.LookupEvent;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Lookup;
import org.openide.util.Lookup.Result;
import org.openide.util.LookupListener;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//com.toy.anagrams.core//AnagramEditor//EN",
autostore = false)
@TopComponent.Description(preferredID = "AnagramEditorTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "com.toy.anagrams.core.AnagramEditorTopComponent")
@ActionReference(path = "Menu/Edit" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_AnagramEditorAction",
preferredID = "AnagramEditorTopComponent")
public final class AnagramEditorTopComponent 
    extends TopComponent implements LookupListener {

    private int wordIdx = 0;
    private WordLibrary wordLibrary;
    private final Collection<? extends WordLibrary> wordLibraries;

            DefaultComboBoxModel dcbm = new DefaultComboBoxModel();

    
    public AnagramEditorTopComponent() {

        initComponents();

        //        wordLibrary = WordLibrary.getDefault();

        //Look in META-INF/services
        //for implementations of WordLibrary:
        wordLibraries = Lookup.getDefault().lookupAll(WordLibrary.class);
        for (WordLibrary wl : wordLibraries) {
            dcbm.addElement(wl);
        }
        
        jComboBox1.setModel(dcbm);

        wordLibrary = (WordLibrary) jComboBox1.getSelectedItem();

        setName(NbBundle.getMessage(AnagramEditorTopComponent.class, "CTL_AnagramEditorTopComponent"));
        setToolTipText(NbBundle.getMessage(AnagramEditorTopComponent.class, "HINT_AnagramEditorTopComponent"));

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        mainPanel = new JPanel();
        scrambledLabel = new JLabel();
        scrambledWord = new JTextField();
        guessLabel = new JLabel();
        guessedWord = new JTextField();
        feedbackLabel = new JLabel();
        buttonsPanel = new JPanel();
        guessButton = new JButton();
        nextTrial = new JButton();
        jComboBox1 = new JComboBox();

        mainPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        mainPanel.setMinimumSize(new Dimension(297, 200));
        mainPanel.setLayout(new GridBagLayout());
        Mnemonics.setLocalizedText(scrambledLabel, NbBundle.getMessage(AnagramEditorTopComponent.class, "AnagramEditorTopComponent.scrambledLabel.text"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 0, 12, 6);
        mainPanel.add(scrambledLabel, gridBagConstraints);

        scrambledWord.setColumns(20);
        scrambledWord.setEditable(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(0, 0, 12, 0);
        mainPanel.add(scrambledWord, gridBagConstraints);

        guessLabel.setDisplayedMnemonic('Y');
        Mnemonics.setLocalizedText(guessLabel, NbBundle.getMessage(AnagramEditorTopComponent.class, "AnagramEditorTopComponent.guessLabel.text"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 0, 20, 6);
        mainPanel.add(guessLabel, gridBagConstraints);

        guessedWord.setColumns(20);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(0, 0, 20, 0);
        mainPanel.add(guessedWord, gridBagConstraints);
        Mnemonics.setLocalizedText(feedbackLabel, NbBundle.getMessage(AnagramEditorTopComponent.class, "AnagramEditorTopComponent.feedbackLabel.text"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(0, 0, 20, 0);
        mainPanel.add(feedbackLabel, gridBagConstraints);

        buttonsPanel.setLayout(new GridBagLayout());

        guessButton.setMnemonic('G');
        Mnemonics.setLocalizedText(guessButton, NbBundle.getMessage(AnagramEditorTopComponent.class, "AnagramEditorTopComponent.guessButton.text"));
        guessButton.setToolTipText(NbBundle.getMessage(AnagramEditorTopComponent.class, "AnagramEditorTopComponent.guessButton.toolTipText")); // NOI18N
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                guessButtonguessedWordActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridheight = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 6);
        buttonsPanel.add(guessButton, gridBagConstraints);

        nextTrial.setMnemonic('N');
        Mnemonics.setLocalizedText(nextTrial, NbBundle.getMessage(AnagramEditorTopComponent.class, "AnagramEditorTopComponent.nextTrial.text"));
        nextTrial.setToolTipText(NbBundle.getMessage(AnagramEditorTopComponent.class, "AnagramEditorTopComponent.nextTrial.toolTipText")); // NOI18N
        nextTrial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                nextTrialActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weighty = 1.0;
        buttonsPanel.add(nextTrial, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(buttonsPanel, gridBagConstraints);

        jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(jComboBox1, gridBagConstraints);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void guessButtonguessedWordActionPerformed(ActionEvent evt) {//GEN-FIRST:event_guessButtonguessedWordActionPerformed
        if (wordLibrary.isCorrect(wordIdx, guessedWord.getText())) {
            feedbackLabel.setText("Correct! Try a new word!");
            getRootPane().setDefaultButton(nextTrial);
        } else {
            feedbackLabel.setText("Incorrect! Try again!");
            guessedWord.setText("");
        }

        guessedWord.requestFocusInWindow();
}//GEN-LAST:event_guessButtonguessedWordActionPerformed

    private void nextTrialActionPerformed(ActionEvent evt) {//GEN-FIRST:event_nextTrialActionPerformed
        wordIdx = (wordIdx + 1) % wordLibrary.getSize();

        feedbackLabel.setText(" ");
        scrambledWord.setText(wordLibrary.getScrambledWord(wordIdx));
        guessedWord.setText("");
        getRootPane().setDefaultButton(guessButton);

        guessedWord.requestFocusInWindow();
}//GEN-LAST:event_nextTrialActionPerformed

    private void jComboBox1ItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        wordLibrary = (WordLibrary) jComboBox1.getSelectedItem();

    }//GEN-LAST:event_jComboBox1ItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel buttonsPanel;
    private JLabel feedbackLabel;
    private JButton guessButton;
    private JLabel guessLabel;
    private JTextField guessedWord;
    private JComboBox jComboBox1;
    private JPanel mainPanel;
    private JButton nextTrial;
    private JLabel scrambledLabel;
    private JTextField scrambledWord;
    // End of variables declaration//GEN-END:variables

    Result<WordLibrary> result;
    
    @Override
    public void componentOpened() {
       result = Lookup.getDefault().lookupResult(WordLibrary.class);
       result.addLookupListener(this);
    }

    @Override
    public void componentClosed() {
        result.removeLookupListener(this);
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

    @Override
    public void resultChanged(LookupEvent ev) {
        JOptionPane.showMessageDialog(null, "change...");
        dcbm = new DefaultComboBoxModel();
        Collection<? extends WordLibrary> allImpls = 
                result.allInstances();
        for (WordLibrary wl : allImpls) {
            dcbm.addElement(wl);
        }
    }
    
}
