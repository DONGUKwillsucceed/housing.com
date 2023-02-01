package housing.com.server.module.property.domain.entity;

import housing.com.server.module.property.domain.entity.ApartmentSaleTransaction;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "area_code", schema = "Housing")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AreaCode {
    @Id
    @Column(name = "법정동코드")
    private double 법정동코드;
    @Basic
    @Column(name = "시도명")
    private String 시도명;
    @Basic
    @Column(name = "시군구명")
    private String 시군구명;
    @Basic
    @Column(name = "읍면동명")
    private String 읍면동명;
    @Basic
    @Column(name = "리명")
    private String 리명;
    @Basic
    @Column(name = "순위")
    private Integer 순위;
    @Basic
    @Column(name = "생성일자")
    private String 생성일자;
    @Basic
    @Column(name = "삭제일자")
    private String 삭제일자;
    @Basic
    @Column(name = "과거법정동코드")
    private Integer 과거법정동코드;

    @OneToMany(mappedBy = "areacode",fetch = FetchType.EAGER)
    public Collection<ApartmentSaleTransaction> apartmentSaleTransactions;
//    @OneToMany(fetch = FetchType.EAGER)
//    public Collection<ApartmentJunsaeRentTransaction> apartmentJunsaeRentTransactions;
//    @OneToMany(fetch = FetchType.EAGER)
//    public Collection<VillaSaleTransaction> villaSaleTransactions;
//    @OneToMany(fetch = FetchType.EAGER)
//    public Collection<VillaJunsaeRentTransaction> villaJunsaeRentTransactions;
//    @OneToMany(fetch = FetchType.EAGER)
//    public Collection<HouseSaleTransaction> houseSaleTransactions;
//    @OneToMany(fetch = FetchType.EAGER)
//    public Collection<HouseJunsaeRentTransaction> houseJunsaeRentTransactions;
}
