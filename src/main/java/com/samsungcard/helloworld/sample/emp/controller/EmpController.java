package com.samsungcard.helloworld.sample.emp.controller;

import com.samsungcard.helloworld.global.common.message.UserMessage;
import com.samsungcard.helloworld.sample.emp.dto.EmpDto;
import com.samsungcard.helloworld.sample.emp.entity.Emp;
import com.samsungcard.helloworld.sample.emp.mapper.EmpMapper;
import com.samsungcard.helloworld.sample.emp.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmpController {
    private final EmpService empService;
    private final EmpMapper empMapper;

    @GetMapping("/edit")
    public String viewEdit(Model model) {
        model.addAttribute("empDto", EmpDto.builder().build());
        return "emp-add-edit";
    }

    @GetMapping("/edit/{id}")
    public String editEmpById(@PathVariable("id") Long id, Model model) {
        EmpDto empDto = empMapper.toEmpDto(empService.find(id));
        model.addAttribute("empDto", empDto);
        return "emp-add-edit";
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("empList", empMapper.toEmpDto(empService.listAll()));
        return "emp-list";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        empService.remove(id);
        redirectAttributes.addFlashAttribute("messages",
                UserMessage.REMOVED.with("사원"));
        return "redirect:/emp/list";
    }

    @PostMapping("/add")
    public String add(@Valid EmpDto empDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            return "emp-add-edit";
        }

        if (empDto.getId() == null) {
            Emp emp = empMapper.toEntity(empDto);
            empService.add(emp);
            redirectAttributes.addFlashAttribute("messages",
                    UserMessage.CREATED.with("사원"));
        } else {
            Emp emp = empMapper.toEntity(empDto);
            empService.modify(emp);
            redirectAttributes.addFlashAttribute("messages",
                    UserMessage.MODIFIED.with("사원"));
        }
        return "redirect:/emp/list";
    }
}
