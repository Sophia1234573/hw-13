package ua.goit;

import java.util.Objects;

public class Company {

    private String name;
    private String catchPhrase;
    private String bs;

    public Company() {
    }
    public Company(Builder builder) {
        this.name = builder.name;
        this.catchPhrase = builder.catchPhrase;
        this.bs = builder.bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public static class Builder{
        private String name;
        private String catchPhrase;
        private String bs;

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder catchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
            return this;
        }
        public Builder bs(String bs) {
            this.bs = bs;
            return this;
        }
        public Company build() {
            return new Company(this);
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) &&
                Objects.equals(catchPhrase, company.catchPhrase) &&
                Objects.equals(bs, company.bs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, catchPhrase, bs);
    }
}
