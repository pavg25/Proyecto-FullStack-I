package MicroServicio02.MicroServicio02.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import MicroServicio02.MicroServicio02.models.Perfume;




public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
    
}
