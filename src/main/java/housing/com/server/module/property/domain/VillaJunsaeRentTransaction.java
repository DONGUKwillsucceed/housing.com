package housing.com.server.module.property.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "villa_junsae_rent_transaction", schema = "Housing")
public class VillaJunsaeRentTransaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "villa_name")
    private String villaName;
    @Basic
    @Column(name = "villa_build_year")
    private Integer villaBuildYear;
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
    @Column(name = "floor")
    private int floor;
    @Basic
    @Column(name = "space")
    private int space;
    @Basic
    @Column(name = "land_area")
    private int landArea;
    @Basic
    @Column(name = "area_code")
    private double areaCode;
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
    public VillaJunsaeRentTransaction(String villaName, int villaBuildYear, int dealDay, int dealMonth, int dealYear, int rent, int deposit, String termOfContract, int floor, int space, int landArea, int areaCode, String dong, String jibun){
        this.villaName = villaName;
        this.villaBuildYear = villaBuildYear;
        this.dealDay = dealDay;
        this.dealMonth = dealMonth;
        this.dealYear = dealYear;
        this.rent = rent;
        this.deposit = deposit;
        this.termOfContract = termOfContract;
        this.floor = floor;
        this.space = space;
        this.landArea = landArea;
        this.areaCode = areaCode;
        this.dong = dong;
        this.jibun = jibun;
    }
}
