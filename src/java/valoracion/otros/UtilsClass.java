/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valoracion.otros;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author anthony
 */
public class UtilsClass {
    public String obtenerHora(Date date){
        SimpleDateFormat formatoHora = new SimpleDateFormat("h:mm:ss a");
        return formatoHora.format(date);
    }
}
