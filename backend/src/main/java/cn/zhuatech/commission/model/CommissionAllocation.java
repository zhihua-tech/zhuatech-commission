/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.commission.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name="commission_allocations",uniqueConstraints=@UniqueConstraint(columnNames={"runId","beneficiary"}))
public class CommissionAllocation {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private Long runId;
    @Column(nullable=false,length=60) private String beneficiary;
    @Column(nullable=false,precision=7,scale=4) private BigDecimal creditPercent;
    @Column(nullable=false,precision=18,scale=2) private BigDecimal payableAmount;
    private LocalDateTime createdAt;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected CommissionAllocation(){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public CommissionAllocation(Long runId,String beneficiary,BigDecimal creditPercent,BigDecimal payableAmount){
        this.runId=runId;this.beneficiary=beneficiary;this.creditPercent=creditPercent;this.payableAmount=payableAmount;
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PrePersist void created(){createdAt=LocalDateTime.now();}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Long getId(){return id;} /**
                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                     */
public Long getRunId(){return runId;} /**
                                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                           */
public String getBeneficiary(){return beneficiary;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getCreditPercent(){return creditPercent;} /**
                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                 */
public BigDecimal getPayableAmount(){return payableAmount;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDateTime getCreatedAt(){return createdAt;}
}
