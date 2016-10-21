package ManyToMany.stock;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stock3", catalog = "assosiations_db", uniqueConstraints = {
            @UniqueConstraint(columnNames = "stock_code"),
            @UniqueConstraint(columnNames = "stock_name")})
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id", nullable = false, unique = true)
    private Integer stockId;

    @Column(name = "stock_code", nullable = false, unique = true, length = 10)
    private String stockCode;

    @Column(name = "stock_name", nullable = false, unique = true, length = 20)
    private String stockName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "stock_category", catalog = "assosiations_db", joinColumns = {
            @JoinColumn(name = "STOCK_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID",
                    nullable = false, updatable = false) })
    private Set<Category> categories = new HashSet<Category>(0);

    public Stock() {
    }

    public Stock(String stockCode, String stockName, Set<Category> categories) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.categories = categories;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
