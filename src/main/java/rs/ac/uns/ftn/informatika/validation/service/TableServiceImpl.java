package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.validation.domain.Sto;
import rs.ac.uns.ftn.informatika.validation.repository.TableRepository;
@Service
@Transactional
public class TableServiceImpl implements TableService {

	@Autowired
	private TableRepository tableRepository;
	
	@Override
	public List<Sto> findAll() {
		return tableRepository.findAll();
	}

	@Override
	public Sto addTable(Sto table) {
		return tableRepository.save(table);
	}

	@Override
	public Sto findById(long id) {
		return tableRepository.findById(id);
	}

	@Override
	public void delete(Sto table) {
		tableRepository.delete(table);
	}

}
