package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.services.beerservice.BeerService;
import guru.sfg.beer.order.service.services.beerservice.model.BeerDto;
import guru.sfg.beer.order.service.web.model.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class BeerOrderLineDecorator implements BeerOrderLineMapper {
    private BeerService beerService;
    private BeerOrderLineMapper beerOrderLineMapper;

    @Autowired
    public void setBeerService(BeerService beerService) {
        this.beerService = beerService;
    }

    @Autowired
    public void setBeerOrderLineMapper(BeerOrderLineMapper beerOrderLineMapper) {
        this.beerOrderLineMapper = beerOrderLineMapper;
    }

    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine orderLine) {
        Optional<BeerDto> optBeerByID = beerService.getBeerByID(orderLine.getBeerId());

        optBeerByID.ifPresent(beerDto -> orderLine.setBeerId(beerDto.getId()));

        return beerOrderLineMapper.beerOrderLineToDto(orderLine);
    }

    @Override
    public BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto orderLineDto) {
       return beerOrderLineMapper.dtoToBeerOrderLine(orderLineDto);
    }
}
