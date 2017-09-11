package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Sto;

public interface TableService {
	public List<Sto> findAll();
	public Sto addTable(Sto table);
	public Sto findById(long id);
	public void delete(Sto table);
}
