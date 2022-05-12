package entity;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CITIES")
@NamedQueries({
        @NamedQuery(name = "City.findAll",
                query = "select e from CitiesEntity e order by e.name"),
        @NamedQuery(name = "City.findById",
                query = "select e from CitiesEntity e where e.id = :id"),
        @NamedQuery(name = "City.findByName",
                query = "select e from CitiesEntity e where e.name LIKE :name"),
})
public class CitiesEntity extends AbstractEntity implements Serializable {
    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITY_ID")
    @SequenceGenerator(name = "CITY_ID", sequenceName = "S_CITIES", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "COUNTRY")
    private String country;
    @Basic
    @Column(name = "POPULATION")
    private long population;

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="AGREEMENT",
            joinColumns={@JoinColumn(name="ID_CITY1")},
            inverseJoinColumns={@JoinColumn(name="ID_CITY2")})
    private Set<CitiesEntity> city2 = new HashSet<CitiesEntity>();

    @ManyToMany(mappedBy="city2")
    private Set<CitiesEntity> city1 = new HashSet<CitiesEntity>();



    public CitiesEntity() {
    }

    public CitiesEntity(String name, String country, long population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        CitiesEntity that = (CitiesEntity) o;

        if (id != that.id) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
