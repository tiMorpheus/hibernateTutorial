package oneToOne.stock;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "stock" , catalog = "assosiations_db", uniqueConstraints = {
        @UniqueConstraint(columnNames = "stock_name"),
        @UniqueConstraint(columnNames = "stock_code")})
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id", unique = true, nullable = false)
    private Integer stockId;

    @Column(name = "stock_code", unique = true, nullable = false, length = 10)
    private String stockCode;

    @Column(name = "stock_name", unique = true, nullable = false, length = 20)
    private String stockName;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
    private StockDetail stockDetail;

    public Stock() {
    }

    public Stock(Integer stockId, String stockCode, String stockName, StockDetail stockDetail) {
        this.stockId = stockId;
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.stockDetail = stockDetail;
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

    public StockDetail getStockDetail() {
        return stockDetail;
    }

    public void setStockDetail(StockDetail stockDetail) {
        this.stockDetail = stockDetail;
    }
}
