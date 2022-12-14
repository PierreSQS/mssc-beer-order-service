package guru.sfg.beer.order.service.services.beerservice;

import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    Optional<BeerDto> getBeerByID(UUID uuid);
    Optional<BeerDto> getBeerByUPC(String upc);
}
