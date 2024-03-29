package ca.bc.gov.app.repository.legacy;

import ca.bc.gov.app.entity.legacy.ForestClientEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ForestClientRepository extends
    ReactiveCrudRepository<ForestClientEntity, String>,
    ReactiveQueryByExampleExecutor<ForestClientEntity>,
    ReactiveSortingRepository<ForestClientEntity, String> {

  Flux<ForestClientEntity> findBy(Pageable page);

  @Query("""
      select * from FOREST_CLIENT x
       where x.CLIENT_TYPE_CODE = 'B'
       and x.CLIENT_STATUS_CODE = 'ACT'""")
  Flux<ForestClientEntity> findAllFirstNationBandClients();

  @Query("""
      select * from FOREST_CLIENT x
       where (x.REGISTRY_COMPANY_TYPE_CODE || x.CORP_REGN_NMBR) = :incorporationNumber
       or x.CLIENT_NAME = :companyName""")
  Flux<ForestClientEntity> findClientByIncorporationOrName(
      @Param("incorporationNumber") String incorporationNumber,
      @Param("companyName") String companyName
  );

  @Query("""
      SELECT *
      FROM FOREST_CLIENT
      WHERE
      UTL_MATCH.JARO_WINKLER_SIMILARITY(UPPER(CLIENT_NAME),UPPER(:companyName)) >= 85""")
  Flux<ForestClientEntity> matchBy(String companyName);

  @Query("""
      select * from FOREST_CLIENT x
       where (x.REGISTRY_COMPANY_TYPE_CODE || x.CORP_REGN_NMBR) = :incorporationNumber""")
  Flux<ForestClientEntity> findByIncorporationNumber(String incorporationNumber);
}
