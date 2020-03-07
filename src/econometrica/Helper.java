/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econometrica;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author themhz
 */
public class Helper {
    
    public static String formatDecimal(String number){
        Locale defaultLocale = Locale.getDefault();       
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
        DecimalFormat df2 = new DecimalFormat("#.##", symbols);  
        
        return df2.format(Float.parseFloat(number));
    }
}
