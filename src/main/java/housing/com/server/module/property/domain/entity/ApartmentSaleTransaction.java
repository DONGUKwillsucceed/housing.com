package housing.com.server.module.property.domain.entity;

import housing.com.server.module.property.domain.type.PropertyType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="Apartment_Sale_Transaction", schema = "Housing")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApartmentSaleTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "apartment_name", nullable = false)
    private String apartmentName;
    @Basic
    @Column(name = "apartment_build_year", nullable = false)
    private int apartmentBuildYear;
    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;
    @Basic
    @Column(name = "deal_year", nullable = false)
    private int dealYear;
    @Basic
    @Column(name = "deal_month", nullable = false)
    private int dealMonth;
    @Basic
    @Column(name = "deal_day", nullable = false)
    private int dealDay;
    @Basic
    @Column(name="space", nullable = false)
    private double space;
    @Basic
    @Column(name="floor", nullable = false)
    private int floor;
    @Basic
    @Column(name="dong", nullable = false)
    private String dong;
    @Basic
    @Column(name = "jibun", nullable = false)
    private String jibun;
    @Basic
    @Column(name = "type", nullable = false)
    private PropertyType type;
    @ManyToOne(targetEntity = AreaCode.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "area_Code")
    public AreaCode areacode;

    @Builder
    public ApartmentSaleTransaction(String apartmentName, int apartmentBuildYear, int amount, int dealYear, int dealMonth, int dealDay, double space, int floor, AreaCode areaCode, String dong, String jibun, PropertyType type) {
        this.apartmentName = apartmentName;
        this.apartmentBuildYear = apartmentBuildYear;
        this.amount = amount;
        this.dealYear = dealYear;
        this.dealMonth = dealMonth;
        this.dealDay = dealDay;
        this.space = space;
        this.floor = floor;
        this.areacode = areaCode;
        this.dong = dong;
        this.jibun = jibun;
        this.type = type;
    }
}
