package cl.bennu.controljornadabackend.service;

import cl.bennu.controljornadabackend.mapper.MaritalStatusMapper;
import cl.bennu.controljornadabackend.model.MaritalStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MaritalStatusService {

    private @Autowired MaritalStatusMapper maritialStatusMapper;

    public List<MaritalStatus> getAllMaritalStatus() {
        return maritialStatusMapper.getAll();
    }

    @Transactional
    public void save(MaritalStatus maritialStatus) {
        if (null == maritialStatus.getId()) {
            maritialStatusMapper.insert(maritialStatus);
        } else {
            maritialStatusMapper.update(maritialStatus);
        }
    }

    public MaritalStatus getById(Long templateId) {
        return maritialStatusMapper.get(templateId);
    }

    public void delete(Long templateId) {
        maritialStatusMapper.delete(templateId);
    }

}
