package ra.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface IGeneric<T,E> {
    Page<T> findAll(Pageable pageable, Sort sort);
    Optional<T> findById(E e);
    void save(T t);
    void delete(E e);
}
