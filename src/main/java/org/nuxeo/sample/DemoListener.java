/**
 * 
 */

package org.nuxeo.sample;

import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.NuxeoException;
import org.nuxeo.ecm.core.event.Event;
import org.nuxeo.ecm.core.event.EventContext;
import org.nuxeo.ecm.core.event.EventListener;
import org.nuxeo.ecm.core.event.impl.DocumentEventContext;

/**
 * @author nohavy
 */
public class DemoListener implements EventListener {

	public void handleEvent(Event event) throws NuxeoException {
    	EventContext ctx = event.getContext();
    	DocumentModel doc = ((DocumentEventContext) ctx).getSourceDocument();
    	
    	String titre = doc.getTitle();
    	String titre2 = titre + "demo ça marche";
    	doc.setPropertyValue("dc:title", titre2);
    	ctx.getCoreSession().saveDocument(doc);
    }
}
