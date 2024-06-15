package uv.arturo.mx.apirest.Service;

import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uv.arturo.mx.apirest.Repository.Repo;
import uv.arturo.mx.apirest.DTO.DataDTO;
import uv.arturo.mx.apirest.Domain.TheData;

@Service
public class MyService {
    
    /**
     * Inatancia automatizada del repositorio, que comunica el servicio con el repositorio.
     */
    @Autowired
    private Repo repo;

    
    /**
     * @return Retorna todos los elemenots de la coleccion de la bd
     */
    public List<TheData> getData(){
        return repo.findAll();
    }

    /**
     * @param title
     * @return
     * Retorna los archivos con el titulo proporcionado
     */
    public Optional<TheData> getByTitle(String title){
        return repo.findByTitle(title);
    }

    public void insert(TheData data){
        repo.insert(data);
    }

    public void delete (int id){
        TheData data = repo.findById(id);
        repo.delete(data);
    }

    public void update (int id, TheData data){
        if(repo.findByTitle(data.getTitle())!=null)
        repo.save(data);
    }



    
}
