package ManyToMany.stock;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CATEGORY_ID", unique = true, nullable = false)
    private Integer categoryId;

    @Column(name = "NAME", nullable = false, length = 10)
    private String name;

    @Column(name = "[DESC]", nullable = false)
    private String desc;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private Set<Stock> stocks;

    public Category() {
    }

    public Category(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }
}
