/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.commission.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity
@Table(name="commission_runs",uniqueConstraints=@UniqueConstraint(columnNames="runNo"))
public class CommissionRun {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false,length=40) private String runNo;
    @Column(nullable=false,length=40) private String planNo;
    @Column(nullable=false,length=60) private String beneficiary;
    @Column(nullable=false,precision=18,scale=2) private BigDecimal eligibleRevenue;
    @Column(nullable=false,precision=8,scale=4) private BigDecimal baseRate;
    @Column(nullable=false,precision=18,scale=2) private BigDecimal acceleratorThreshold;
    @Column(nullable=false,precision=8,scale=4) private BigDecimal acceleratorRate;
    @Column(nullable=false,precision=18,scale=2) private BigDecimal capAmount;
    @Column(nullable=false,precision=18,scale=2) private BigDecimal calculatedAmount=BigDecimal.ZERO;
    @Column(nullable=false,precision=18,scale=2) private BigDecimal clawbackAmount=BigDecimal.ZERO;
    private int disputedItems;
    private boolean planApproved;
    private boolean dataLocked;
    private boolean complianceChecked;
    @Column(nullable=false,length=30) private String state;
    @Version private long version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected CommissionRun(){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public CommissionRun(String runNo,String planNo,String beneficiary,BigDecimal eligibleRevenue,
            BigDecimal baseRate,BigDecimal acceleratorThreshold,BigDecimal acceleratorRate,BigDecimal capAmount,
            int disputedItems,boolean planApproved,boolean dataLocked,boolean complianceChecked){
        this.runNo=runNo;this.planNo=planNo;this.beneficiary=beneficiary;this.eligibleRevenue=eligibleRevenue;
        this.baseRate=baseRate;this.acceleratorThreshold=acceleratorThreshold;
        this.acceleratorRate=acceleratorRate;this.capAmount=capAmount;this.disputedItems=disputedItems;
        this.planApproved=planApproved;this.dataLocked=dataLocked;this.complianceChecked=complianceChecked;this.state="DRAFT";
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PrePersist void created(){createdAt=updatedAt=LocalDateTime.now();}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PreUpdate void updated(){updatedAt=LocalDateTime.now();}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void calculate(BigDecimal amount){calculatedAmount=amount;state="CALCULATED";}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void submit(){state="PENDING_REVIEW";} /**
                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                   */
public void approve(){state="APPROVED";}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void pay(){state="PAID";}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void clawback(BigDecimal amount){clawbackAmount=clawbackAmount.add(amount);
        state=clawbackAmount.compareTo(calculatedAmount)>=0?"CLAWED_BACK":"PARTIAL_CLAWBACK";}

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Long getId(){return id;} /**
                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                     */
public String getRunNo(){return runNo;} /**
                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                             */
public String getPlanNo(){return planNo;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getBeneficiary(){return beneficiary;} /**
                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                         */
public BigDecimal getEligibleRevenue(){return eligibleRevenue;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getBaseRate(){return baseRate;} /**
                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                       */
public BigDecimal getAcceleratorThreshold(){return acceleratorThreshold;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getAcceleratorRate(){return acceleratorRate;} /**
                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                     */
public BigDecimal getCapAmount(){return capAmount;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BigDecimal getCalculatedAmount(){return calculatedAmount;} /**
                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                       */
public BigDecimal getClawbackAmount(){return clawbackAmount;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public int getDisputedItems(){return disputedItems;} /**
                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                          */
public boolean isPlanApproved(){return planApproved;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public boolean isDataLocked(){return dataLocked;} /**
                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                       */
public boolean isComplianceChecked(){return complianceChecked;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getState(){return state;} /**
                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                             */
public long getVersion(){return version;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public LocalDateTime getCreatedAt(){return createdAt;} /**
                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                            */
public LocalDateTime getUpdatedAt(){return updatedAt;}
}
