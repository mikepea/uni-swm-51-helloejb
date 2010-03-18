// HelloLocalHome.java
//

package hello;

import javax.ejb.*;

public interface HelloLocalHome extends EJBLocalHome
{
    public HelloLocal create()
        throws CreateException, EJBException;
}
