package housing.com.server.module.property.domain.entity;

import housing.com.server.module.property.domain.entity.AreaCode;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "house_sale_transaction", schema = "Housing")
public class HouseSaleTransaction {
    @Basic
    @Column(name = "house_build_year")
    private int houseBuildYear;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "deal_year")
    private int dealYear;
    @Basic
    @Column(name = "deal_month")
    private int dealMonth;
    @Basic
    @Column(name = "deal_day")
    private int dealDay;
    @Basic
    @Column(name = "amount")
    private int amount;
    @Basic
    @Column(name = "total_space")
    private int totalSpace;
    @Basic
    @Column(name = "land_area")
    private int landArea;
    @Basic
    @Column(name = "house_type")
    private String houseType;
    @Basic
    @Column(name = "dong")
    private String dong;
    @Basic
    @Column(name = "jibun")
    private String jibun;
    @ManyToOne(targetEntity = AreaCode.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "area_Code")
    public AreaCode areacode;
    @Builder
    public HouseSaleTransaction(int houseBuildYear, int dealDay, int dealMonth, int dealYear, int amount, int totalSpace, int landArea, String houseType, AreaCode areaCode, String dong, String jibun){
        this.amount = amount;
        this.dealDay = dealDay;
        this.areacode = areaCode;
        this.houseBuildYear = houseBuildYear;
        this.dealMonth = dealMonth;
        this.dealYear = dealYear;
        this.totalSpace = totalSpace;
        this.landArea = landArea;
        this.houseType = houseType;
        this.dong = dong;
        this.jibun = jibun;
    }
}
