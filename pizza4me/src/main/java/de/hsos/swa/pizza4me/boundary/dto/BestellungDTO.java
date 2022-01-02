package de.hsos.swa.pizza4me.boundary.dto;

import java.util.ArrayList;
import java.util.List;

import de.hsos.swa.pizza4me.entity.Bestellposten;
import de.hsos.swa.pizza4me.entity.Bestellung;

public class BestellungDTO {
    public List<BestellpostenDTO> bDto;
    public boolean bestellt = false;

    public BestellungDTO() {
    }

    public BestellungDTO(List<BestellpostenDTO> bDto, boolean bestellt) {
        this.bDto = bDto;
        this.bestellt = bestellt;
    }

    public static class Converter {
        public static BestellungDTO toBestellungDTO(Bestellung bestellung) {
            List<BestellpostenDTO> bestellpostenDTOs = new ArrayList<>();
            for (Bestellposten b : bestellung.getBestellposten()) {
                bestellpostenDTOs.add(BestellpostenDTO.Converter.toBestellpostenDTO(b));
            }
            BestellungDTO bestellungDTO = new BestellungDTO(bestellpostenDTOs, bestellung.isBestellt());
            return bestellungDTO;
        }

        public static Bestellung toBestellung(BestellungDTO bestellungDto) {
            Bestellung bestellung = new Bestellung();
            bestellung.setBestellt(bestellungDto.bestellt);
            for (BestellpostenDTO b : bestellungDto.bDto) {
                bestellung.addBestellposten(BestellpostenDTO.Converter.toBestellposten(b));
            }

            return bestellung;
        }
    }

}
