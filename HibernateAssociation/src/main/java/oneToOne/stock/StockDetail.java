package oneToOne.stock;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "stock_detail", catalog = "assosiations_db")
public class StockDetail implements Serializable{


    @GenericGenerator(name = "generator", strategy = "foreign",
    parameters = @Parameter(name = "property", value = "stock"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "stock_id", unique = true, nullable = false)
    private Integer stockId;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Stock stock;

    @Column(name = "comp_name", nullable = false, length = 100)
    private String compName;

    @Column(name = "comp_desc", nullable = false)
    private String compDesc;

    @Column(name = "remark", nullable = false)
    private String remark;

    @Temporal(TemporalType.DATE)
    @Column(name = "listed_date", nullable = false, length = 10)
    private Date listedDate;

    public StockDetail() {
    }

    public StockDetail(Integer stockId, Stock stock, String compName,
                       String compDesc, String remark, Date listedDate) {
        this.stockId = stockId;
        this.stock = stock;
        this.compName = compName;
        this.compDesc = compDesc;
        this.remark = remark;
        this.listedDate = listedDate;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompDesc() {
        return compDesc;
    }

    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getListedDate() {
        return listedDate;
    }

    public void setListedDate(Date listedDate) {
        this.listedDate = listedDate;
    }
}
