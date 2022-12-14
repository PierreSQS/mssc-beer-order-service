package guru.sfg.beer.order.service.services.beerservice;

import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceRestTemplateImpl implements BeerService {

    private static final String BEER_SERV_PATH="/api/v1/beer";
    private static final String UPC_SERV_PATH=BEER_SERV_PATH+"/beerUpc";

    private final RestTemplate restTemplate;

    @Value("${sfg.brewery.beer-service-host}")
    private String beerServiceHost;

    public BeerServiceRestTemplateImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Optional<BeerDto> getBeerByID(UUID beerUuid) {
        log.debug("Calling #getBeerByID() in the Beer Service");

        String url = String.format("%s/%s/%s",beerServiceHost,BEER_SERV_PATH, beerUuid);

        ResponseEntity<BeerDto> beerDtoRespEntity =
                restTemplate.getForEntity(url, BeerDto.class);

        return Optional.ofNullable(beerDtoRespEntity.getBody());
    }

    @Override
    public Optional<BeerDto> getBeerByUPC(String upc) {
        log.debug("Calling #getBeerByUPC() in the Beer Service");

        String url = String.format("%s/%s/%s",beerServiceHost,UPC_SERV_PATH, upc);

        ResponseEntity<BeerDto> beerDtoRespEntity = restTemplate.getForEntity(url, BeerDto.class);
        return Optional.ofNullable(beerDtoRespEntity.getBody());
    }
}
