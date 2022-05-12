package entity;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "COUNTRIES")
@NamedQueries({
        @NamedQuery(name = "Country.findAll",
                query = "select e from CountriesEntity e order by e.name"),
        @NamedQuery(name = "Country.findById",
                query = "select e from CountriesEntity e where e.id = :id"),
        @NamedQuery(name = "Country.findByName",
                query = "select e from CountriesEntity e where e.name LIKE :name"),
})
public class CountriesEntity extends AbstractEntity implements Serializable {
    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUNTRY_ID")
    @SequenceGenerator(name = "COUNTRY_ID", sequenceName = "S_COUNTRIES", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "CODE")
    private String code;
    @Basic
    @Column(name = "CONTINENT")
    private String continent;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountriesEntity that = (CountriesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (continent != null ? !continent.equals(that.continent) : that.continent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        return result;
    }

    /**
     * one to many relationship
     * @return
     */

    @OneToMany
    private List<CitiesEntity> oneToMany;

    public List<CitiesEntity> getOneToMany() {
        return oneToMany;
    }

    public void setOneToMany(List<CitiesEntity> oneToMany) {
        this.oneToMany = oneToMany;
    }
}
