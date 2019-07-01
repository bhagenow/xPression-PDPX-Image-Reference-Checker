/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.brookshagenow.xpression.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import me.brookshagenow.xpression.pdp.utils.ContentImageReferences;
import me.brookshagenow.xpression.pdp.utils.beans.ImageReference;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.io.*;
import java.math.BigInteger;

import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;

import java.util.Enumeration;

import me.brookshagenow.xpression.pdp.beans.contents.Contents;
import me.brookshagenow.xpression.pdp.beans.contents.ContentItem;
import me.brookshagenow.xpression.pdp.beans.contents.ImageUsage;

/**
 *
 * @author hagenb2
 */
public class ImageRefScanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
/*
 * Unremark this and remark out the GUI code below if you want to run from a command line
 * 
        File pdp = null;
        if (args.length == 1) {
            pdp = new File(args[0]);
            if (!pdp.isFile() || !pdp.canRead()) {
                System.err.println(args[0] + " is not a file or can not be read.");
                System.exit(1);
            }
            try {
                System.out.println(getBadImageRefs(pdp));
            }
            catch (Throwable t) {
                t.printStackTrace();
            }
        } else {
            System.err.println("You must provide a path to a PDP or PDPX file.");
            System.exit(1);
        }

 */

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PDPImageRefScannerGUI();
            }
        });
    }

    public static String getBadImageRefs(File pdp) throws Throwable {

        int refCount = 0;
        int noRefCount = 0;
        int badContentCount = 0;
        int badRefCount = 0;

        StringBuilder result = new StringBuilder();
        final String NEW_LINE = System.getProperty("line.separator");
        byte[] buffer = new byte[512];
        int readCount = -1;
        List<ZipEntry> contentItems = new ArrayList<ZipEntry>();

        try (ZipFile zip = new ZipFile(pdp)) {
	        ZipEntry contentsEntry = zip.getEntry("Contents.xml");
	        InputStream is = zip.getInputStream(contentsEntry);
	        StringBuilder sbContents = new StringBuilder();
	        while ((readCount = is.read(buffer)) > -1) {
	            for (int i = 0; i < readCount; i++) {
	                sbContents.append((char)buffer[i]);
	            }
	        }
	        is.close();
	        is = null;

	        StringReader contents = new StringReader(sbContents.toString().trim());

	        Enumeration<? extends ZipEntry> entries = zip.entries();
	        while (entries.hasMoreElements()) {
	            ZipEntry temp = (ZipEntry)entries.nextElement();
	            if (temp.getName().startsWith("ContentData")) {
	                contentItems.add(temp);
	            }
	        }

	        StringBuilder sb = null;

	        Contents masterContents = null;
	        Map<BigInteger, ContentItem> contentMap = new HashMap<BigInteger, ContentItem>();
	        try {
	            JAXBContext jc = JAXBContext.newInstance( Contents.class );
	            Unmarshaller u = jc.createUnmarshaller();
	            masterContents = (Contents)u.unmarshal(contents);
	            if (masterContents == null)
	                throw new Exception("Contents.xml could not be unmarshalled!");

	            ContentItem temp = null;
	            List<ContentItem> contList = masterContents.getContentItem();
	            Iterator<ContentItem> it = contList.iterator();
	            while (it.hasNext()) {
	                temp = it.next();
	                contentMap.put(temp.getContentId(), temp);
	            }
	        }
	        catch (Exception e) {
	            System.err.println(e.getMessage());
	            System.exit(1);
	        }

	        Iterator<ZipEntry> itZE = contentItems.iterator();
	        while (itZE.hasNext()) {
	            sb = new StringBuilder();
	            ZipEntry temp = itZE.next();

	            is = zip.getInputStream(temp);
	            sb = new StringBuilder();
	            while ((readCount = is.read(buffer)) > -1) {
	                for (int i = 0; i < readCount; i++) {
	                    sb.append((char)buffer[i]);
	                }
	            }
	            is.close();
	            is = null;

	            List<ImageReference> refs = ContentImageReferences.getImageReferences(sb.toString());
	            if (!refs.isEmpty()) {
	                refCount++;
	                BigInteger key = BigInteger.valueOf(Long.parseLong(temp.getName().substring(11)));
	                ContentItem item = contentMap.get(key);
	                List<ImageUsage> imgUsages = item.getImageUsage();
	                Iterator<ImageReference> contentImgRefs = refs.iterator();
	                if (imgUsages.isEmpty()) {
	                    badContentCount++;
	                    result.append(NEW_LINE);
	                    result.append("Content ID: ");
	                    result.append(key.toString());
	                    result.append(NEW_LINE);
	                    result.append("Content Name: ");
	                    result.append(item.getName());
	                    result.append(NEW_LINE);
	                    result.append("Content Language: ");
	                    result.append(item.getLANGUAGE());
	                    result.append(NEW_LINE);
	                    result.append("Last Modified: ");
	                    result.append(item.getLastModifiedTime());
	                    result.append(NEW_LINE);
	                    result.append("Author: ");
	                    result.append(item.getAuthor());
	                    result.append(NEW_LINE);
	                    while (contentImgRefs.hasNext()) {
	                        badRefCount++;
	                        ImageReference ref = contentImgRefs.next();
	                        result.append("  Image refID: ");
	                        result.append(ref.getRefID());
	                        result.append("  Image Name: ");
	                        result.append(ref.getName());
	                        result.append(NEW_LINE);
	                    }
	                } else {
	                    boolean printedItemInfo = false;
	                    List<BigInteger> refIDs =  new ArrayList<BigInteger>();
	                    Iterator<ImageUsage> it = imgUsages.iterator();
	                    while (it.hasNext()) {
	                        refIDs.add(it.next().getUsageId());
	                    }
	                    while (contentImgRefs.hasNext()) {
	                        ImageReference ref = contentImgRefs.next();
	                        BigInteger bigRefID = BigInteger.valueOf((long)ref.getRefID());
	                        if (!refIDs.contains(bigRefID)) {
	                            badRefCount++;
	                            if (!printedItemInfo) {
	                                badContentCount++;
	                                result.append(NEW_LINE);
	                                result.append("Content ID: ");
	                                result.append(key.toString());
	                                result.append(NEW_LINE);
	                                result.append("Content Name: ");
	                                result.append(item.getName());
	                                result.append(NEW_LINE);
	                                result.append("Content Language: ");
	                                result.append(item.getLANGUAGE());
	                                result.append(NEW_LINE);
	                                result.append("Last Modified: ");
	                                result.append(item.getLastModifiedTime());
	                                result.append(NEW_LINE);
	                                result.append("Author: ");
	                                result.append(item.getAuthor());
	                                result.append(NEW_LINE);
	                                printedItemInfo = true;
	                            }
	                            result.append("  Image refID: ");
	                            result.append(ref.getRefID());
	                            result.append("  Image Name: ");
	                            result.append(ref.getName());
	                            result.append(NEW_LINE);
	                        }
	                    }
	                }
	            } else {
	                //System.out.println("No image refs!");
	                noRefCount++;
	            }
	        }
        }

        if (badRefCount > 0) {
            result.insert(0, NEW_LINE);
            result.insert(0, "The following bad image references were found:");
            result.insert(0, NEW_LINE);
            result.insert(0, NEW_LINE);
        }

        result.insert(0, badRefCount);
        result.insert(0, "Total bad image references: ");
        result.insert(0, NEW_LINE);
        result.insert(0, badContentCount);
        result.insert(0, "Content items with bad image references: ");
        result.insert(0, NEW_LINE);
        result.insert(0, refCount);
        result.insert(0, "Content items with image references: ");
        result.insert(0, NEW_LINE);
        result.insert(0, noRefCount);
        result.insert(0, "Content items without image references: ");

        return result.toString();
    }
}
