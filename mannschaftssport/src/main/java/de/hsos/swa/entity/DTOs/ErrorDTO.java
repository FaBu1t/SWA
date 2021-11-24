package de.hsos.swa.entity.DTOs;

public class ErrorDTO {
    public int code;
    public int status;
    public String source;
    public String title;
    public String detail;
    
    public ErrorDTO(String title) {
        this.title = title;
    }

    public ErrorDTO() {
    }

    
}
