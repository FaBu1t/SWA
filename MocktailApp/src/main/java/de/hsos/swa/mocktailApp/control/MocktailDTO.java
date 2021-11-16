package de.hsos.swa.mocktailApp.control;

import javax.validation.constraints.NotBlank;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "MocktailDTO", description = "Mocktail representation to create")
public class MocktailDTO {
    @NotBlank
    @Schema(title = "Mocktail ID", required = true)
    public int id;
    @NotBlank
    @Schema(title = "Mocktail name", required = true)
    public String name;
    public String zutaten;
    public String autor;
}
