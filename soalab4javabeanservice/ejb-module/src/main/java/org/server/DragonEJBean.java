package org.server;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import org.server.jpa.Dragon;
import org.server.remoteInterfaces.DragonEJBRemote;

@Remote(DragonEJBRemote.class)
@Stateless(name = "DragonEJBean")
public class DragonEJBean implements DragonEJBRemote {

    private String getServiceUrl() {
        return "http://haproxy:2626/api/dragons";
    }

    @Override
    public Dragon findDeepestDragon(String type) {
        Client client = ClientBuilder.newClient();
        try {
            return client.target(getServiceUrl())
                    .queryParam("page", 1)
                    .queryParam("size", 1)
                    .queryParam("sort", "d.cave.depth")
                    .queryParam("direct", type.equalsIgnoreCase("max") ? "desc" : "asc")
                    .request(MediaType.APPLICATION_JSON).get(Dragon[].class)[0];
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            client.close();
        }
    }

    @Override
    public void killDragon(Integer dragonId) {
        Client client = ClientBuilder.newClient();
        try {
            client.target(getServiceUrl()).path(dragonId.toString()).request().delete();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }
}
