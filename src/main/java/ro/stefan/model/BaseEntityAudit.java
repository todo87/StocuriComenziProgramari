package ro.stefan.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class BaseEntityAudit extends BaseEntity{

    @NotNull
    @Column(name = "createdAt")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy, HH:mm")
    protected LocalDateTime createdAt;

    @NotNull
    @Column(name = "createdBy")
    protected String createdBy;

    @Column(name = "modifiedAt")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy, HH:mm")
    protected LocalDateTime modifiedAt;

    @Column(name = "modifiedBy")
    protected String modifiedBy;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new LocalDateTime();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    @PreUpdate
    public void setModifiedAt() {
        this.modifiedAt = new LocalDateTime();
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
