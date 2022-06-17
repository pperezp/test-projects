package cl.spring.course.service;

import cl.spring.course.domain.President;
import cl.spring.course.repository.PresidentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PresidentServiceImpl implements PresidentService {

    @Autowired
    private PresidentDao presidentDao;

    @Override
    @Transactional
    public void save(President president) {
        presidentDao.save(president);
    }

    @Override
    @Transactional(readOnly = true)
    public List<President> read() {
        return (List<President>) presidentDao.findAll();
    }

    @Override
    @Transactional
    public void delete(President president) {
        presidentDao.delete(president);
    }

    @Override
    @Transactional(readOnly = true)
    public President readById(Integer id) {
        return presidentDao.findById(id).orElse(null);
    }
}
