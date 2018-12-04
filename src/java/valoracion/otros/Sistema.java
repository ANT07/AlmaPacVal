/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valoracion.otros;

import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;
import javax.servlet.ServletContext;

/**
 *
 * @author anthony
 */
public class Sistema implements SystemEventListener{

    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        ServletContext application = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        List<ValoracionLog> valoracionLogs = new ArrayList<>();
        application.setAttribute("valoracionLogs", valoracionLogs);
    }

    @Override
    public boolean isListenerForSource(Object source) {
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
