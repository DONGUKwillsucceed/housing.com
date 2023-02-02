package housing.com.server.module.property.infra;

import housing.com.server.module.property.domain.entity.AreaCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaCodeRepository extends JpaRepository<AreaCode, String> {
    AreaCode findAreaCodeBy법정동코드(String 법정동코드);
    List<AreaCode> findAll();
}
