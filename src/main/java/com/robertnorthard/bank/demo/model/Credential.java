package com.robertnorthard.bank.demo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author robertnorthard
 */
@Entity
@Table(name = "CREDENTIAL", catalog = "", schema = "BANKDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credential.findAll", query = "SELECT c FROM Credential c"),
    @NamedQuery(name = "Credential.findByAccountId", query = "SELECT c FROM Credential c WHERE c.credentialPK.accountId = :accountId"),
    @NamedQuery(name = "Credential.findByBiometricType", query = "SELECT c FROM Credential c WHERE c.credentialPK.biometricType = :biometricType"),
    @NamedQuery(name = "Credential.findByPassword", query = "SELECT c FROM Credential c WHERE c.password = :password")})
public class Credential implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CredentialPK credentialPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Account account;
    @JoinColumn(name = "BIOMETRIC_TYPE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BiometricType biometricType1;

    public Credential() {
    }

    public Credential(CredentialPK credentialPK) {
        this.credentialPK = credentialPK;
    }

    public Credential(CredentialPK credentialPK, String password) {
        this.credentialPK = credentialPK;
        this.password = password;
    }

    public Credential(int accountId, int biometricType) {
        this.credentialPK = new CredentialPK(accountId, biometricType);
    }

    public CredentialPK getCredentialPK() {
        return credentialPK;
    }

    public void setCredentialPK(CredentialPK credentialPK) {
        this.credentialPK = credentialPK;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BiometricType getBiometricType1() {
        return biometricType1;
    }

    public void setBiometricType1(BiometricType biometricType1) {
        this.biometricType1 = biometricType1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (credentialPK != null ? credentialPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credential)) {
            return false;
        }
        Credential other = (Credential) object;
        if ((this.credentialPK == null && other.credentialPK != null) || (this.credentialPK != null && !this.credentialPK.equals(other.credentialPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.robertnorthard.bank.demo.model.Credential[ credentialPK=" + credentialPK + " ]";
    }
    
}
