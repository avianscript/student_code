package com.techelevator.memes.model;

/**
 * Class used to create meme via API
 */
public class CaptionedMeme {

    private String templateId;
    private String username;
    private String password;
    private String topText;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTopText() {
        return topText;
    }

    public void setTopText(String topText) {
        this.topText = topText;
    }
}
