package ro.stefan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class City extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "county_id")
    private County County;

    @NotNull
    @Column(name = "siruta")
    private Long siruta;

    @NotNull
    @Column(name = "longitude")
    private BigDecimal longitude;

    @NotNull
    @Column(name = "latitude")
    private BigDecimal latitude;

    @NotNull
    @Column(name = "name", length = 64)
    private String name;

    @NotNull
    @Column(name = "region", length = 64)
    private String region;

    public County getCounty() {
        return County;
    }

    public void setCounty(County county) {
        County = county;
    }

    public Long getSiruta() {
        return siruta;
    }

    public void setSiruta(Long siruta) {
        this.siruta = siruta;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (!County.equals(city.County)) return false;
        if (!siruta.equals(city.siruta)) return false;
        if (!longitude.equals(city.longitude)) return false;
        if (!latitude.equals(city.latitude)) return false;
        if (!name.equals(city.name)) return false;
        return region.equals(city.region);

    }

    @Override
    public int hashCode() {
        int result = County.hashCode();
        result = 31 * result + siruta.hashCode();
        result = 31 * result + longitude.hashCode();
        result = 31 * result + latitude.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + region.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "County=" + County +
                ", siruta=" + siruta +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
