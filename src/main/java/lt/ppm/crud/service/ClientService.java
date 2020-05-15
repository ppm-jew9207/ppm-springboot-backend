package lt.ppm.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ppm.crud.exception.RecordNotFoundException;
import lt.ppm.crud.model.ClientEntity;
import lt.ppm.crud.repository.ClientRepository;

 
@Service
public class ClientService {
     
    @Autowired
    ClientRepository repository;
     
    public List<ClientEntity> getAll()
    {
        List<ClientEntity> list = repository.findAll();
         
        if(list.size() > 0) {
            return list;
        } else {
            return new ArrayList<ClientEntity>();
        }
    }
     
    public ClientEntity getById(Long id) throws RecordNotFoundException
    {
        Optional<ClientEntity> customer = repository.findById(id);
         
        if(customer.isPresent()) {
            return customer.get();
        } else {
            throw new RecordNotFoundException("No Customer record exist for given id");
        }
    }
     
    public ClientEntity createOrUpdate(ClientEntity entity) throws RecordNotFoundException
    {
        Optional<ClientEntity> customer = repository.findById(entity.getId());
         
        if(customer.isPresent())
        {
        	ClientEntity newEntity = customer.get();
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setPhone(entity.getPhone());
            newEntity.setEmail(entity.getEmail());
            
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteById(Long id) throws RecordNotFoundException
    {
        Optional<ClientEntity> customer = repository.findById(id);
         
        if(customer.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No customer record exist for given id");
        }
    }
}