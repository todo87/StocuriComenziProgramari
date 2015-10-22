package ro.stefan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class County extends BaseEntity {

    @NotNull
    @Column(name = "code",length = 64)
    private String code;

    @NotNull
    @Column(name = "name",length = 64)
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        County county = (County) o;

        if (code != null ? !code.equals(county.code) : county.code != null) return false;
        return !(name != null ? !name.equals(county.name) : county.name != null);

    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "County{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
