package ua.goit;

import java.util.Objects;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address(Builder builder) {
        this.street = builder.street;
        this.suite = builder.suite;
        this.city = builder.city;
        this.zipcode = builder.zipcode;
        this.geo = builder.geo;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public static class Builder {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder suite(String suite) {
            this.suite = suite;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder zipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public Builder geo(Geo geo) {
            this.geo = geo;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) &&
                Objects.equals(suite, address.suite) &&
                Objects.equals(city, address.city) &&
                Objects.equals(zipcode, address.zipcode) &&
                Objects.equals(geo, address.geo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, suite, city, zipcode, geo);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                '}';
    }
}
