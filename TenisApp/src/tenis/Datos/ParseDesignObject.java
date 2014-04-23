package tenis.Datos;

import org.parse4j.ParseObject;
import org.parse4j.ParseClassName;


/**
 *
 * @author L. Antonio Hidalgo
 */
@ParseClassName("ParseDesignObject")
public class ParseDesignObject extends ParseObject {
    public ParseDesignObject() {
        
    }
    
    public void setDesignName(String pDesignName) {
        put("Name", pDesignName);
    }
    
    public String getDesignName() {
        return getString("Name");
    }
    
    //Since JSONArrays are also strings, there is no need to use more 
    //than one pair in the DB to save all of the specific Figure types.
    
    /*public void setDesignCircles(String pCircleParams) {
        put("Circles", pCircleParams);
    }
    
    public String getDesignCircles() {
        return getString("Circles");
    }
    
    public void setDesignLines(String pLineParams) {
        put("Lines", pLineParams);
    }
    
    public String getDesignLines() {
        return getString("Lines");
    }*/
}