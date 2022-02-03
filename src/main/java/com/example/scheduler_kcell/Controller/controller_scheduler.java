package com.example.scheduler_kcell.Controller;

import com.example.scheduler_kcell.Model.model_scheduler;
import com.example.scheduler_kcell.Repo.repo_scheduler;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/scheduler")
public class controller_scheduler {

    @Autowired
    private repo_scheduler repoScheduler;

    @GetMapping
    public List<model_scheduler> findAll(){
        return repoScheduler.findAll();
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasAuthority('scheduler:read')")
    public Optional<model_scheduler> getById(@PathVariable Long id) {
        return repoScheduler.findById(id);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('scheduler:write')")
    public model_scheduler save(@Valid @NotNull @RequestBody model_scheduler model_scheduler){
        return repoScheduler.save(model_scheduler);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('scheduler:write')")
    public model_scheduler update(@Valid @NotNull @RequestBody model_scheduler model_scheduler){
        return repoScheduler.save(model_scheduler);
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("hasAuthority('scheduler:write')")
    public void delete(@PathVariable Long id){
        repoScheduler.deleteById(id);
    }
}