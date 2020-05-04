 
package DAO;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Hp
 */

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {
    
    @Override
    public Set<Class<?>> getClasses(){
        
        Set<Class<?>> resources = new java.util.HashSet<>();
        
        return resources;
    }
    
}
