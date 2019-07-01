/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.brookshagenow.xpression.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JButton;

/**
 *
 * @author bhagenow
 */
public class PDPImageRefScannerActionListener implements ActionListener {

    private final JFrame parent;
    private final JTextArea resultArea;

    public PDPImageRefScannerActionListener(JFrame parent, JTextArea area) {
        this.parent = parent;
        this.resultArea = area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Open PDP/PDPX")) {
            ((JButton)e.getSource()).setEnabled(false);

            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new pdpFileFilter());
            if (fc.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
                try {
                    resultArea.setText(ImageRefScanner.getBadImageRefs(fc.getSelectedFile()));
                }
                catch (Throwable t) {
                    resultArea.setText("Unable to process file: ");
                    resultArea.append(fc.getSelectedFile().getAbsolutePath());
                    resultArea.append("\n\n");
                    resultArea.append(t.getMessage());
                }
            }

            ((JButton)e.getSource()).setEnabled(true);
        }
    }

}
