// Hello.java

package Hello;

import javax.ejb.*;
import java.rmi.*;

public interface Hello extends EJBObject
{
    public String sayHello(String myName)
        throws RemoteException;
}
