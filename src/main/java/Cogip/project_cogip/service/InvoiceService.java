package Cogip.project_cogip.service;

import Cogip.project_cogip.dto.InvoicesDto;
import Cogip.project_cogip.entities.Companies;
import Cogip.project_cogip.entities.Invoices;
import Cogip.project_cogip.repository.CompanyRepository;
import Cogip.project_cogip.repository.InvoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private InvoicesRepository invoicesRepository;
    private CompanyRepository companyRepository;

    @Autowired
    public InvoiceService(InvoicesRepository invoicesRepository, CompanyRepository companyRepository) {
        this.invoicesRepository = invoicesRepository;
        this.companyRepository = companyRepository;
    }

    public void createInvoice(InvoicesDto invoiceDto) {
        Companies company = companyRepository.findById(invoiceDto.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));
        Invoices invoice = new Invoices();
        invoice.setCompany(company);
        invoice.setPrice(invoiceDto.getPrice());
        invoice.setRef(invoiceDto.getRef());
        invoicesRepository.save(invoice);
    }

    public List<InvoicesDto> getAllInvoices() {
        return invoicesRepository.findAll()
                .stream()
                .map(invoice -> new InvoicesDto(invoice))
                .toList();
    }

    public InvoicesDto getInvoiceById(int id) {
        if(invoicesRepository.existsById(id)) {
            return new InvoicesDto(invoicesRepository.findById(id).get());
        }else{
            throw new RuntimeException("Invoice not found");
        }


    }

    public void updateInvoiceById(int id, InvoicesDto invoiceDto) {
        Invoices invoice = invoicesRepository.findById(id).get();
        invoice.setPrice(invoiceDto.getPrice());
        invoice.setRef(invoiceDto.getRef());
        invoicesRepository.save(invoice);
    }

    public void deleteById(int id) {
        invoicesRepository.deleteById(id);
    }
}
