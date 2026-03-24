package com.java360.pmanager.domain.applicationservice;

import com.java360.pmanager.domain.entity.Project;
import com.java360.pmanager.domain.model.ProjectStatus;
import com.java360.pmanager.domain.repository.ProjectRepository;
import com.java360.pmanager.infrastructure.dto.SaveProjectDataDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public Project createProject(SaveProjectDataDto saveProjectDataDto) {

        Project project = Project
                .builder()
                .name(saveProjectDataDto.getName())
                .description(saveProjectDataDto.getDescription())
                .initialDate(saveProjectDataDto.getInitialDate())
                .finalDate(saveProjectDataDto.getFinalDate())
                .status(ProjectStatus.PENDING)
                .build();

        projectRepository.save(project);

        log.info("Project created successfully {}", project);
        return project;
    }
}
