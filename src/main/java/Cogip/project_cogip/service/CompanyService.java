package Cogip.project_cogip.service;

import Cogip.project_cogip.dto.CompanyDto;
import Cogip.project_cogip.dto.CompanyGetDto;
import Cogip.project_cogip.dto.ContactDto;
import Cogip.project_cogip.dto.InvoicesDto;
import Cogip.project_cogip.entities.Companies;
import Cogip.project_cogip.entities.Types;
import Cogip.project_cogip.repository.CompanyRepository;
import Cogip.project_cogip.repository.ContactRepository;
import Cogip.project_cogip.repository.InvoicesRepository;
import Cogip.project_cogip.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final TypeRepository typeRepository;
    private final InvoicesRepository invoicesRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, TypeRepository typeRepository, InvoicesRepository invoicesRepository, ContactRepository contactRepository) {
        this.companyRepository = companyRepository;
        this.typeRepository = typeRepository;
        this.invoicesRepository = invoicesRepository;
        this.contactRepository = contactRepository;
    }

    public void CreateCompany(CompanyDto companyDto) {
        Types type = typeRepository.findById(companyDto.getTypeId()).orElseThrow(() -> new RuntimeException("type not valid"));
        Companies company = new Companies();
        company.setName(companyDto.getName());
        company.setCountry(companyDto.getCountry());
        company.setTva(companyDto.getTva());
        company.setType(type);
        companyRepository.save(company);
    }

    public List<CompanyGetDto> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(companies -> new CompanyGetDto(companies))
                .toList();

    }


    public CompanyGetDto getCompanyById(int id) {
        return companyRepository.findById(id)
                .map(CompanyGetDto::new)
                .orElse(null);
    }

    public String updateCompanyById(CompanyDto companyDto, int id) {
        Companies company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        Types type = typeRepository.findById(companyDto.getTypeId())
                .orElseThrow(() -> new RuntimeException("Type not found"));

        company.setName(companyDto.getName());
        company.setCountry(companyDto.getCountry());
        company.setTva(companyDto.getTva());
        company.setType(type);
        companyRepository.save(company);
        return "the company is updated";
    }

    public String deleteById(int id) {
        Companies company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no company found"));
        companyRepository.delete(company);
        return "the company is deleted";
    }

    public List<InvoicesDto> getAllInvoicesByCompanyId(int id) {

        if(companyRepository.existsById(id)) {

            return invoicesRepository.findAllByCompany_Id(id)
                    .stream()
                    .map(InvoicesDto::new)
                    .toList();

        }else{
            throw new RuntimeException("company not found");
        }
    }


    public List<ContactDto> getAllContactByCompanyId(int id) {
        if(companyRepository.existsById(id)) {
            return contactRepository.findAllByCompanyId(id)
                    .stream()
                    .map(contact -> new ContactDto(contact))
                    .toList();
        }else{
            throw new RuntimeException("company not found");
        }
    }
}
