/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.brookshagenow.xpression.utils;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.BorderLayout;

/**
 *
 * @author bhagenow
 */
public class PDPImageRefScannerGUI extends JFrame {
    private static final long serialVersionUID = -6107305550108992692L;

	public PDPImageRefScannerGUI() {
        setTitle("PDP Image Reference Scanner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea result = new JTextArea(10, 50);
        result.setEditable(false);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        JButton openPDPButton = new JButton("Open PDP/PDPX");
        openPDPButton.addActionListener(new PDPImageRefScannerActionListener(this, result));
        container.add(openPDPButton, BorderLayout.NORTH);

        JScrollPane scrollpane = new JScrollPane(result);
        scrollpane.setPreferredSize(new Dimension(600,300));
        container.add(scrollpane, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }
}
