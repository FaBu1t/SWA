package de.hsos.swa.pizza4me.boundary.dto;

import de.hsos.swa.pizza4me.entity.Adresse;

public class AdresseDTO {
   public String strasse;
   public String ort;
   public int plz;

   public AdresseDTO(){}

   public AdresseDTO(String strasse,String ort,int plz){
       this.strasse=strasse;
       this.ort=ort;
       this.plz=plz;
   }

   public static class Converter{

    public static AdresseDTO toAdresseDTO(Adresse adresse){
        return  new AdresseDTO(adresse.getStrasse(),adresse.getOrt(),adresse.getPlz());
    }

    public static Adresse toAdresse(AdresseDTO adresseDto){
        return new Adresse(adresseDto.strasse, adresseDto.ort,adresseDto.plz);
    }
   }

    
}
