package services;


import models.Agents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestService {

@Autowired
private RestTemplate restTemplate;





    public ResponseEntity<List<Agents>> getJson() {


     return restTemplate.exchange("http://10.37.1.19:8080/DEVELOPE/odata/standard.odata/Catalog_Контрагенты?$format=json&$filter=НеИспользуется%20eq%20true", HttpMethod.GET, null, new ParameterizedTypeReference<List<Agents>>() {
     });
    }
}
