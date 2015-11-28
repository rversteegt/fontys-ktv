package remote.ws.mok.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;

/**
 *
 * @author Robert
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Assignment {
    
    private String artifact;
    
    private String name;
    
    private String participantDescription;
    
    private String spectatorDescription;
    
    private String creatorName;
    
    private String creatorOrganisation;
    
    private String creatorLink;
    
    private Set<Hint> hints;

    public String getArtifact() {
        return artifact;
    }

    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParticipantDescription() {
        return participantDescription;
    }

    public void setParticipantDescription(String participantDescription) {
        this.participantDescription = participantDescription;
    }

    public String getSpectatorDescription() {
        return spectatorDescription;
    }

    public void setSpectatorDescription(String spectatorDescription) {
        this.spectatorDescription = spectatorDescription;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorOrganisation() {
        return creatorOrganisation;
    }

    public void setCreatorOrganisation(String creatorOrganisation) {
        this.creatorOrganisation = creatorOrganisation;
    }

    public String getCreatorLink() {
        return creatorLink;
    }

    public void setCreatorLink(String creatorLink) {
        this.creatorLink = creatorLink;
    }

    public Set<Hint> getHints() {
        return hints;
    }

    public void setHints(Set<Hint> hints) {
        this.hints = hints;
    }
    
    
}
