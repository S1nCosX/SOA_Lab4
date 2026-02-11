package org.server;

import org.server.jpa.Dragon;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public interface IKillerSoap {
    @WebMethod
    Dragon findByCaveDepth(String type);

    @WebMethod
    void kill(Integer dragonId);
}
