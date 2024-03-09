package edu.tcu.cs.hogwartsartifactsonline.Artifact.Dto;

import edu.tcu.cs.hogwartsartifactsonline.Wizard.Dto.WizardDto;
import jakarta.validation.constraints.NotEmpty;

public record ArtifactDto(String id,
                          @NotEmpty(message = "Name is required.")
                          String name,
                          @NotEmpty(message = "Description is required.")
                          String description,
                          @NotEmpty(message = "imageUrl is required.")
                          String imageUrl,
                          WizardDto owner) {
}
