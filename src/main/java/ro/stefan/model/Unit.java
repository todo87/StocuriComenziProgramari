package ro.stefan.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table
public class Unit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) @Column(name="id")
    private Long id;

    @NotEmpty
    @Column(name = "unit")
    private String unit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit1 = (Unit) o;

        return unit.equals(unit1.unit);

    }

    @Override
    public int hashCode() {
        return unit.hashCode();
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", unit='" + unit + '\'' +
                '}';
    }
}
