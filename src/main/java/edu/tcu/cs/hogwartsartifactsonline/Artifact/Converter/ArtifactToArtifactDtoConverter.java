package edu.tcu.cs.hogwartsartifactsonline.Artifact.Converter;

import edu.tcu.cs.hogwartsartifactsonline.Artifact.Artifact;
import edu.tcu.cs.hogwartsartifactsonline.Artifact.Dto.ArtifactDto;
import edu.tcu.cs.hogwartsartifactsonline.Wizard.Converter.WizardToWizardDtoConverter;
import edu.tcu.cs.hogwartsartifactsonline.Wizard.Dto.WizardDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArtifactToArtifactDtoConverter implements Converter<Artifact, ArtifactDto> {

    private final WizardToWizardDtoConverter wizardToWizardDtoConverter;

    public ArtifactToArtifactDtoConverter(WizardToWizardDtoConverter wizardToWizardDtoConverter) {
        this.wizardToWizardDtoConverter = wizardToWizardDtoConverter;
    }

    @Override
    public ArtifactDto convert(Artifact source) {
        ArtifactDto artifactDto = new ArtifactDto(source.getId(),
                source.getName(),
                source.getDescription(),
                source.getImageURL(),
                source.getOwner() != null
                        ? this.wizardToWizardDtoConverter.convert(source.getOwner())
                        :null);
        return artifactDto;

    }

}
