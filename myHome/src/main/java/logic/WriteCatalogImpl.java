package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReadDao;
import dao.WriteDao;
import model.Bbs;
import model.Condition;

@Service
public class WriteCatalogImpl implements WriteCatalog {
	@Autowired
	private WriteDao writeDao;
	@Autowired
	private ReadDao readDao;
	public Integer getMaxBbsId() {
		return writeDao.getMaxId();
	}

	public void putBbs(Bbs bbs) {
		writeDao.insertBBS(bbs);
	}

	public List<Bbs> readBbs(Condition c) {
		return readDao.readBbs(c);
	}

	public Integer getBbsCount() {
		return readDao.getBbsCount();
	}

	public Bbs getBbsDetail(Integer id) {
		return readDao.getBbsDetail(id);
	}

}








