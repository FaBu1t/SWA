package de.hsos.swa.pizza4me.control;

import java.util.List;

import de.hsos.swa.pizza4me.entity.Kunde;

public interface KundenService {

    public Kunde kundeHinzufuegen(Kunde kunde);

    public boolean kundeLoeschen(int id);

    public Kunde kundeAendern(Kunde kunde);

    public Kunde kundeAnzeigen(int id);

    public List<Kunde> alleKundenAnzeigen();

}
