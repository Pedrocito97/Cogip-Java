package Cogip.project_cogip.service;

import Cogip.project_cogip.dto.CompanyDto;
import Cogip.project_cogip.dto.CompanyGetDto;
import Cogip.project_cogip.entities.Companies;
import Cogip.project_cogip.repository.CompanyRepository;
import Cogip.project_cogip.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private TypeRepository typeRepository;
    private CompanyRepository companyRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository, CompanyRepository companyRepository) {
        this.typeRepository = typeRepository;
        this.companyRepository = companyRepository;
    }


    public List<CompanyGetDto> getCompaniesByTypeId(int id) {

        if(typeRepository.existsById(id)) {
            return companyRepository.findCompaniesByTypeId(id)
                    .stream()
                    .map(company -> new CompanyGetDto(company))
                    .toList();

        }else{
            throw new RuntimeException("Type with id " + id + " not found");
        }
    }
}
