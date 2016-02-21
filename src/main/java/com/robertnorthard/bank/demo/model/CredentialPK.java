package com.robertnorthard.bank.demo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Represents composite primary key for credential table.
 * 
 * @author robertnorthard
 */
@Embeddable
public class CredentialPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNT_ID")
    private int accountId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIOMETRIC_TYPE")
    private int biometricType;

    public CredentialPK() {
    }

    public CredentialPK(int accountId, int biometricType) {
        this.accountId = accountId;
        this.biometricType = biometricType;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBiometricType() {
        return biometricType;
    }

    public void setBiometricType(int biometricType) {
        this.biometricType = biometricType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) accountId;
        hash += (int) biometricType;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CredentialPK)) {
            return false;
        }
        CredentialPK other = (CredentialPK) object;
        if (this.accountId != other.accountId) {
            return false;
        }
        if (this.biometricType != other.biometricType) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.robertnorthard.bank.demo.model.CredentialPK[ accountId=" + accountId + ", biometricType=" + biometricType + " ]";
    }
    
}
