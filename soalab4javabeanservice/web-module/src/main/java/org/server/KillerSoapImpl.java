package org.server;

import org.server.jpa.Dragon;
import org.server.remoteInterfaces.DragonEJBRemote;

import javax.ejb.EJB;
import javax.jws.WebService;

@WebService (
        endpointInterface = "org.server.IKillerSoap"
)
public class KillerSoapImpl implements IKillerSoap{

    @EJB(lookup = "java:global/ejb-module/DragonEJBean!org.server.remoteInterfaces.DragonEJBRemote")
    DragonEJBRemote dragonEJB;

    @Override
    public Dragon findByCaveDepth(String type) {
        return dragonEJB.findDeepestDragon(type);
    }

    @Override
    public void kill(Integer dragonId) {
        dragonEJB.killDragon(dragonId);
    }
}
