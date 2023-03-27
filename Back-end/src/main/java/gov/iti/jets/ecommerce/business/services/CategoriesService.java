package gov.iti.jets.ecommerce.business.services;

import java.util.List;


import gov.iti.jets.ecommerce.business.dtos.CategoriesProductDTO;

public interface CategoriesService {
    
    public List<CategoriesProductDTO> getAll();

    public CategoriesProductDTO getById(int id);

    public void addCategory(CategoriesProductDTO category);

    public void deleteById(int id);

    public void deleteAll();
}
