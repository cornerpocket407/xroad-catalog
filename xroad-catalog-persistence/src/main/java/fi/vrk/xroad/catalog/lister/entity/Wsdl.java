package fi.vrk.xroad.catalog.lister.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString(exclude = "service")
public class Wsdl {
    // TODO: from sequence
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @OneToOne(optional=false)
    @JoinColumn(name="SERVICE_ID", unique=true, nullable=false, updatable=false)
    private Service service;
    private String data;
    private String dataHash;
    private String externalId;
    private Date created;
    private Date updated;
    private Date removed;

    public Wsdl() {
    }

    public Wsdl(Service service, String data, String dataHash, String externalId) {
        this.service = service;
        this.data = data;
        this.dataHash = dataHash;
        this.externalId = externalId;
        this.created = new Date();
        this.updated = this.created;
    }

    public Wsdl(Service service, String data, String dataHash, String externalId, Date created, Date updated, Date removed) {
        this.service = service;
        this.data = data;
        this.dataHash = dataHash;
        this.externalId = externalId;
        this.created = created;
        this.updated = updated;
        this.removed = removed;
    }
}