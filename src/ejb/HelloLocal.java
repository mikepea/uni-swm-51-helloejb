// HelloLocal.java
//

package hello;

import javax.ejb.*;

public interface HelloLocal extends EJBLocalObject
{
    public String sayHello(String myName)
        throws EJBException;
}
