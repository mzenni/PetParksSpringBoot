package pet.park.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany; 

@Entity
@Data
public class Contributor {
	// tell JPA to work, where primary key is
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contributorId;
	
	private String contributorName;
	
	@Column(unique = true)
	private String contributorEmail;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "contributor", cascade = CascadeType.ALL) // the One to many relationship
	private Set<PetPark> petParks = new HashSet<>(); 
}
