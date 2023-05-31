package ra.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
}
