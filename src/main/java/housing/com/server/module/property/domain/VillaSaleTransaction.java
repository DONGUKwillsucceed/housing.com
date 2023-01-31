package housing.com.server.module.property.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "villa_sale_transaction", schema = "Housing")
public class VillaSaleTransaction {
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
    @Column(name = "amount")
    private int amount;
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
    public VillaSaleTransaction(String villaName, int villaBuildYear, int dealYear, int dealMonth, int dealDay, int amount, int floor, int space, int landArea, int areaCode, String dong, String jibun){
        this.villaName = villaName;
        this.villaBuildYear= villaBuildYear;
        this.dealYear = dealYear;
        this.dealMonth = dealMonth;
        this.dealDay = dealDay;
        this.amount = amount;
        this.floor = floor;
        this.space = space;
        this.landArea = landArea;
        this.areaCode = areaCode;
        this.dong = dong;
        this.jibun = jibun;
    }

}
