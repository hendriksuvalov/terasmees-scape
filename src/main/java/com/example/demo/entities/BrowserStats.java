package com.example.demo.entities;


import javax.persistence.*;

@Table(name="browserstats")
@Entity
public class BrowserStats {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="browser")
    private String browser;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Column(name="os")
    private String os;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Column(name="uri")
    private String uri;

    public BrowserStats(String browser, String os, String uri) {

        this.browser = browser;
        this.os = os;
        this.uri = uri;
    }





}
