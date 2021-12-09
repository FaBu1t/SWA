package de.hsos.swa.pizza4me.boundary.dto;

import java.util.ArrayList;
import java.util.List;

import de.hsos.swa.pizza4me.entity.Bestellung;
import de.hsos.swa.pizza4me.entity.Kunde;

public class KundeDTO {
    public AdresseDTO adresse;
    public List<BestellungDTO> bestellung; 

    public KundeDTO(){}

    public KundeDTO(AdresseDTO adresseDTO, List<BestellungDTO> bestellungDTO){
        this.bestellung=bestellungDTO;
        this.adresse= adresseDTO;
    }

    public static class Converter{
        public static KundeDTO toKundeDTO(Kunde kunde){
            List<BestellungDTO> bestellungen = new ArrayList<>();
            for(Bestellung b : kunde.getBestellungen()){
                bestellungen.add(BestellungDTO.Converter.toBestellungDTO(b));
            }

            return new KundeDTO(AdresseDTO.Converter.toAdresseDTO(kunde.getAdresse()), bestellungen);
        }

        public static Kunde toKunde(KundeDTO kundeDTO){
            List<Bestellung> bestellungen = new ArrayList<>();
            for(BestellungDTO b :kundeDTO.bestellung){
                bestellungen.add(BestellungDTO.Converter.toBestellung(b));
            }
            Kunde kunde= new Kunde();
            kunde.setAdresse(AdresseDTO.Converter.toAdresse(kundeDTO.adresse));
            kunde.setBestellungen(bestellungen);
            return kunde;
            
        }
    }
    
}
