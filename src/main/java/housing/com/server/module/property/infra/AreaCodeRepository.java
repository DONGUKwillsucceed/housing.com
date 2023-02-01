package housing.com.server.module.property.infra;

import housing.com.server.module.property.domain.entity.AreaCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaCodeRepository extends JpaRepository<AreaCode, String> {
    AreaCode findAreaCodeBy법정동코드(double 법정동코드);
}
