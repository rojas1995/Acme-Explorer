/**
 *
 */

package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Sponsorship;

@Repository
public interface SponsorshipRepository extends JpaRepository<Sponsorship, Integer> {

	@Query("select s.sponsorships from Sponsor s where s.id = ?1")
	Collection<Sponsorship> findAllBySponsor(Integer sponsorId);

}
