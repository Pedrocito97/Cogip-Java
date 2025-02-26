package Cogip.project_cogip.controller;

import Cogip.project_cogip.dto.CompanyGetDto;
import Cogip.project_cogip.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {

    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/{id}/companies")
    public List<CompanyGetDto> getCompaniesByTypeId(@PathVariable int id) {
        return typeService.getCompaniesByTypeId(id);
    }
}
