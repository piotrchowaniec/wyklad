package info.fingo.data;

import info.fingo.data.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {
                    "address"
            })
    @Override
    Page<Customer> findAll(Pageable pageable);

    @Override
    Iterable<Customer> findAll();

    @Query("from Customer c left join fetch c.address where c.email = :email ")
    Optional<Customer> findByEmail(String email);

}
