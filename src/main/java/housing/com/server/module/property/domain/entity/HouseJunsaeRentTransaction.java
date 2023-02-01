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
@Table(name = "house_junsae_rent_transaction", schema = "Housing")
public class HouseJunsaeRentTransaction {
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
    @Column(name = "rent")
    private int rent;
    @Basic
    @Column(name = "deposit")
    private int deposit;
    @Basic
    @Column(name = "term_of_contract")
    private String termOfContract;
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
    public HouseJunsaeRentTransaction(int houseBuildYear, int dealYear, int dealDay, int dealMonth, int deposit, int rent, int totalSpace, int landArea, String houseType, String termOfContract, String dong, String jibun, AreaCode areaCode){
        this.dealYear = dealYear;
        this.dealDay = dealDay;
        this.dealMonth = dealMonth;
        this.deposit = deposit;
        this.rent = rent;
        this.totalSpace = totalSpace;
        this.landArea = landArea;
        this.houseType = houseType;
        this.termOfContract = termOfContract;
        this.dong = dong;
        this.jibun = jibun;
        this.areacode = areaCode;
        this.houseBuildYear = houseBuildYear;
    }
}
