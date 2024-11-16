package models;

public class Endereco {
    private double latitude;
    private double longitude;
    private String rua;
    private String numero;

    public Endereco(double latitude, double longitude, String rua, String numero) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.rua = rua;
        this.numero = numero;
    }

    // Getters e Setters
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String toString() {
        return "Latitude: " + latitude + "\nLongitude: " + longitude + "\nRua: " + rua + "\nNúmero: " + numero;
    }
}