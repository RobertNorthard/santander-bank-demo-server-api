package com.robertnorthard.bank.demo.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author robertnorthard
 */
@Entity
@Table(name = "BIOMETRIC_TYPE", catalog = "", schema = "BANKDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BiometricType.findAll", query = "SELECT b FROM BiometricType b"),
    @NamedQuery(name = "BiometricType.findById", query = "SELECT b FROM BiometricType b WHERE b.id = :id"),
    @NamedQuery(name = "BiometricType.findByType", query = "SELECT b FROM BiometricType b WHERE b.type = :type")})
public class BiometricType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 128)
    @Column(name = "TYPE")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "biometricType1", fetch = FetchType.LAZY)
    private List<Credential> credentialList;

    public BiometricType() {
    }

    public BiometricType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<Credential> getCredentialList() {
        return credentialList;
    }

    public void setCredentialList(List<Credential> credentialList) {
        this.credentialList = credentialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BiometricType)) {
            return false;
        }
        BiometricType other = (BiometricType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.robertnorthard.bank.demo.model.BiometricType[ id=" + id + " ]";
    }
    
}
