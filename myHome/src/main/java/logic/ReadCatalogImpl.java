package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReadDao;
import model.Writing;

@Service
public class ReadCatalogImpl implements ReadCatalog {
	@Autowired
	private ReadDao readDao;
	
	public Writing readWriting(Integer id) {
		return readDao.readWriting(id);
	}

}
