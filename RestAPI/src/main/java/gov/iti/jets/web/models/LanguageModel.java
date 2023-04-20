package gov.iti.jets.web.models;

import java.util.Date;

public class LanguageModel {
    private Short languageId;
    private String name;
    private Date lastUpdate;

    public Short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Short languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
