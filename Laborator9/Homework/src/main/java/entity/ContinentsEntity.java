package entity;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CONTINENTS")
@NamedQueries({
        @NamedQuery(name = "Continent.findAll",
                query = "select e from ContinentsEntity e order by e.name"),
        @NamedQuery(name = "Continent.findById",
                query = "select e from ContinentsEntity e where e.id = :id"),
        @NamedQuery(name = "Continent.findByName",
                query = "select e from ContinentsEntity e where e.name LIKE :name"),
})
public class ContinentsEntity extends AbstractEntity implements Serializable {
    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONT_ID")
    @SequenceGenerator(name = "CONT_ID", sequenceName = "S_CONTINENTS", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "NAME")
    private String name;

    public ContinentsEntity(String name){
        this.name = name;
    }

    public ContinentsEntity() {

    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentsEntity that = (ContinentsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


    @OneToMany
    private List<CountriesEntity> oneToMany;

    public List<CountriesEntity> getOneToMany() {
        return oneToMany;
    }
    /**
     * set the one to many relationship
     * @param oneToMany list of countries
     */
    public void setOneToMany(List<CountriesEntity> oneToMany) {
        this.oneToMany = oneToMany;
    }
}
