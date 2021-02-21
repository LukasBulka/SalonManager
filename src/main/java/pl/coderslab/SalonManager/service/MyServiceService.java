package pl.coderslab.SalonManager.service;

import org.springframework.stereotype.Service;
import pl.coderslab.SalonManager.model.MyService;
import pl.coderslab.SalonManager.repository.MyServiceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MyServiceService {

    private final MyServiceRepository myServiceRepository;

    public MyServiceService(MyServiceRepository myServiceRepository) {
        this.myServiceRepository = myServiceRepository;
    }

    public List<MyService> findAllServices() {
        return myServiceRepository.findAll();
    }

    public MyService saveMyService(MyService myService) {
        return myServiceRepository.save(myService);
    }

    public Optional<MyService> findMyServiceById(Long id) {
        return myServiceRepository.findById(id);
    }

    public void deleteMyService(MyService myService) {
        myServiceRepository.delete(myService);
    }
}
