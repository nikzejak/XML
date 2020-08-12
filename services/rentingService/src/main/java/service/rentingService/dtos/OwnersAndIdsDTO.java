package service.rentingService.dtos;

import service.rentingService.model.Client;

import java.util.ArrayList;
import java.util.List;

public class OwnersAndIdsDTO {
    private List<String> ids;
    private Client client;

    public OwnersAndIdsDTO() {
        ids=new ArrayList<>();
    }

    public OwnersAndIdsDTO(List<String> ids, Client client) {
        this.ids = ids;
        this.client = client;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
