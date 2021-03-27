package top.zwzx.supermarket_001.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    private Integer id;

    public String getBillCode() {
        return billCode;
    }

    private String billCode;
    private String productName;
    private String productDesc;
    private String productUnit;
    private String productCount;
    private Float totalPrice;
    private Integer isPayment;

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    private Integer createdBy;

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    private Date creationDate;
    private Integer modifyBy;
    private Date modifyDate;
    private Integer providerId;
}
