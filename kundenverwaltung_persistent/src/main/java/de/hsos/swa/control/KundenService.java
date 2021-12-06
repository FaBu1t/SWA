package de.hsos.swa.control;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;

import de.hsos.swa.entity.Adresse;
import de.hsos.swa.entity.Kunde;

public interface KundenService {

    public void kundenAnlegen(String vorname, String nachname);

    public Collection<Kunde> kundenAbfragen();

    public Kunde kundeAbfragen(long kundennr);

    public boolean kundeLoeschen(long kundennr);

    public void adresseAnlegen(long kundennr, Adresse adr);

    public void adresseAendern(long kundennr, Adresse neueAdr);

    public Adresse adresseAbfragen(long kundennr);

    public boolean adresseLoeschen(long kundennr);
}
