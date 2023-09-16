package edu.mum.cs.cs425.studentmgmt.model;


import jakarta.persistence.Entity;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Transcript {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;

    @Nonnull
    private String degreeTitle;

    public Transcript() {}

    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Long getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(Long transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    @Override
    public String toString() {
        return String.format("Transcript [transcriptId=%s, degreeTitle=%s]", transcriptId, degreeTitle);
    }

}
