package gov.iti.jets.ecommerce.business.servicesImpl;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.iti.jets.ecommerce.business.dtos.CategoriesProductDTO;
import gov.iti.jets.ecommerce.business.mappers.CategoriesMapper;
import gov.iti.jets.ecommerce.business.services.CategoriesService;
import gov.iti.jets.ecommerce.persistence.entities.Category;
import gov.iti.jets.ecommerce.exceptions.ResourceNotFoundException;
import gov.iti.jets.ecommerce.persistence.repositories.CategoriesRepo;


@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepo categoriesRepo;

    @Autowired
    private CategoriesMapper categoryMapper;

    @Override
    public List<CategoriesProductDTO> getAll() {

        return categoryMapper.categoriesToCategoriesDTO(categoriesRepo.findAllCategories());
    }

    @Override
    public CategoriesProductDTO getById(int id) {
        Optional<Category> category =categoriesRepo.findById(id);
        if (category.isEmpty())
        {throw new ResourceNotFoundException(id);}
        return categoryMapper.map(category.get());
        
    }


    @Override
    public void addCategory(CategoriesProductDTO category) {
        
            categoriesRepo.save(categoryMapper.categoryDtoToCategory(category));
        
        
    }
    
    @Override
    public void deleteById(int id)
    {
        categoriesRepo.deleteCategoryById(id);
    }

    @Override
    public void deleteAll()
    {
        categoriesRepo.deleteAll();
    }

}
