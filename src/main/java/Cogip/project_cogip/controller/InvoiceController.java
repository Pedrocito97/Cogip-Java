package Cogip.project_cogip.controller;

import Cogip.project_cogip.dto.InvoicesDto;
import Cogip.project_cogip.entities.Invoices;
import Cogip.project_cogip.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public ResponseEntity<String> createInvoice(@RequestBody InvoicesDto invoiceDto) {
        invoiceService.createInvoice(invoiceDto);
        return ResponseEntity.ok("Invoice created");
    }

    @GetMapping
    public ResponseEntity<List<InvoicesDto>> getInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoicesDto> getInvoice(@PathVariable int id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateInvoice(@PathVariable int id, @RequestBody InvoicesDto invoiceDto) {
        invoiceService.updateInvoiceById(id, invoiceDto);
        return ResponseEntity.ok("Invoice updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable int id) {
        invoiceService.deleteById(id);
        return ResponseEntity.ok("Invoice deleted");
    }
}
