package de.hsos.swa.pizza4me.control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import de.hsos.swa.pizza4me.entity.Bestellposten;
import de.hsos.swa.pizza4me.entity.Bestellung;
import de.hsos.swa.pizza4me.entity.Kunde;

@RequestScoped
public interface BestellungService {

    public int bestellungHinzufuegen(int kundenId);

    public List<Kunde> bestellungLoeschen(int bestellungId);

    public Bestellung bestellpostenHinzufuegen(int bestellungId, Bestellposten bestellposten);

    public Bestellung bestellpostenLoeschen(int bestellpostenId);

    public Bestellung bestellpostenAendern(int BestellpostenId, Bestellposten neuerBestellposten);

    public boolean bestellungAbschliessen(int bestellungId);

    public Bestellung bestellungAnzeigen(int bestellungId);

    public List<Bestellung> alleBestellungenAnzeigen();

    public boolean isAbgeschlossen(int bestellungId);

    public List<List<Bestellung>> alleBestellungenfureKundenAnzeigen(int kundenId);

    public int findBestellungId(int bestellpostenId);
}
