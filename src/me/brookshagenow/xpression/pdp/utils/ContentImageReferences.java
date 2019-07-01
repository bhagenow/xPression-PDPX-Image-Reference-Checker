/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.brookshagenow.xpression.pdp.utils;

import me.brookshagenow.xpression.pdp.utils.beans.ImageReference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hagenb2
 */
public class ContentImageReferences {
    private static final String DSCIMGTAG = "&lt;dscimg&gt;";
    private static final String REFID = "refId=&quot;";
    private static final String NAME = "name=&quot;";
    private static final String END = "&quot;";
    
    public static List<ImageReference> getImageReferences(String contentData) {
        List<ImageReference> refs = new ArrayList<ImageReference>();
        
        if (contentData != null) {
            int idx = 0;
            while ((idx = contentData.indexOf(DSCIMGTAG, idx)) > -1) {
                int initIdx = idx + DSCIMGTAG.length();

                // START FINDING refID
                idx = contentData.indexOf(REFID, initIdx);
                int refID = -1;
                if (idx > -1) {
                    idx += REFID.length();
                    int start = idx;
                    int end = contentData.indexOf(END, idx);
                    idx = end + END.length();
                    String temp = contentData.substring(start, end);
                    refID = Integer.parseInt(temp);
                }
                // END FINDING refID
                
                // START FINDING name
                idx = contentData.indexOf(NAME, initIdx);
                String name = null;
                if (idx > -1) {
                    idx += NAME.length();
                    int start = idx;
                    int end = contentData.indexOf(END, idx);
                    idx = end + END.length();
                    name = contentData.substring(start, end);
                }
                // END FINDING name
                
                if (refID > -1 && name != null) {
                    ImageReference ref = new ImageReference();
                    ref.setRefID(refID);
                    ref.setName(name);
                    refs.add(ref);
                }
            }
            
        }
        
        return refs;
    }
}
