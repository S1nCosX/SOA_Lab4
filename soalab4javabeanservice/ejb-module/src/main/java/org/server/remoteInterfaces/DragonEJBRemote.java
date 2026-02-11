package org.server.remoteInterfaces;

import org.server.jpa.Dragon;

import javax.ejb.Remote;

@Remote
public interface DragonEJBRemote {
    Dragon findDeepestDragon(String type);

    void killDragon(Integer dragonId);
}

