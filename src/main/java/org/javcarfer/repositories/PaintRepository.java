package org.javcarfer.repositories;

import org.javcarfer.domain.Paint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintRepository extends JpaRepository<Paint,Integer> {
}
