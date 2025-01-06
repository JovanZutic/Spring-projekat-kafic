package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the magacin database table.
 * 
 */
@Entity
@NamedQuery(name="Magacin.findAll", query="SELECT m FROM Magacin m")
public class Magacin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="magacin_id")
	private int magacinId;

	private int kolicina;

	//bi-directional many-to-one association to Pice
	@ManyToOne
	private Pice pice;

	public Magacin() {
	}

	public int getMagacinId() {
		return this.magacinId;
	}

	public void setMagacinId(int magacinId) {
		this.magacinId = magacinId;
	}

	public int getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public Pice getPice() {
		return this.pice;
	}

	public void setPice(Pice pice) {
		this.pice = pice;
	}

}