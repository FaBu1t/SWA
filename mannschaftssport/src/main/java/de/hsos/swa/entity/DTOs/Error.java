package de.hsos.swa.entity.DTOs;

public class Error {
    public int code;
    public int status;
    public String source;
    public String title;
    public String detail;
    public Error(String title) {
        this.title = title;
    }

    
}
