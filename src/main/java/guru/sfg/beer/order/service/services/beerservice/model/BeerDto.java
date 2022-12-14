package guru.sfg.beer.order.service.services.beerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * Extended by Pierrot on 2022-12-14.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto implements Serializable {
    private UUID id;

    private String beerName;

    private String beerStyle;

    private String upc;


}
