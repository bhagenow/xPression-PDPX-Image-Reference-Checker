/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.brookshagenow.xpression.utils;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Brooks
 */
public class pdpFileFilter extends FileFilter {

    @Override
    public boolean accept(File pathname) {
        boolean result = false;

        if (pathname.isDirectory()) {
            result = true;
        } else {
            String temp = pathname.getName().toLowerCase();
            if (temp.endsWith(".pdpx") || temp.endsWith(".pdp") || temp.endsWith(".zip")) {
                result = true;
            }
        }

        return result;
    }

    @Override
    public String getDescription() {
        return "PDP/PDPX/ZIP Files";
    }
}