package service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import service.AdminService.model.GetCarBrandRequest;
import service.AdminService.model.GetCarBrandResponse;
import service.AdminService.model.GetMessageRequest;
import service.AdminService.model.GetMessageResponse;

@Service
public class SoapClient {

    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public GetMessageResponse getMessageStatus(GetMessageRequest request){
        template = new WebServiceTemplate(marshaller);

        GetMessageResponse getMessageResponse = (GetMessageResponse) template.marshalSendAndReceive(
                "http://localhost:8082/ws", request);

        return getMessageResponse;
    }

    public GetCarBrandResponse getCarBrandStatus(GetCarBrandRequest request){
        template = new WebServiceTemplate(marshaller);

        GetCarBrandResponse getCarBrandResponse = (GetCarBrandResponse) template.marshalSendAndReceive(
                "http://localhost:8082/ws", request);

        return getCarBrandResponse;
    }

}
