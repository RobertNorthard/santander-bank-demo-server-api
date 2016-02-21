package com.robertnorthard.bank.demo.controllers;

import com.robertnorthard.bank.demo.model.Credential;
import com.robertnorthard.bank.demo.model.CredentialPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author robertnorthard
 */
@Stateless
@Path("/credential")
public class CredentialFacadeREST extends AbstractFacade<Credential> {
    @PersistenceContext(unitName = "com.robertnorthard_api_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private CredentialPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;accountId=accountIdValue;biometricType=biometricTypeValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.robertnorthard.bank.demo.model.CredentialPK key = new com.robertnorthard.bank.demo.model.CredentialPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> accountId = map.get("accountId");
        if (accountId != null && !accountId.isEmpty()) {
            key.setAccountId(new java.lang.Integer(accountId.get(0)));
        }
        java.util.List<String> biometricType = map.get("biometricType");
        if (biometricType != null && !biometricType.isEmpty()) {
            key.setBiometricType(new java.lang.Integer(biometricType.get(0)));
        }
        return key;
    }

    public CredentialFacadeREST() {
        super(Credential.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Credential entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, Credential entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.robertnorthard.bank.demo.model.CredentialPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Credential find(@PathParam("id") PathSegment id) {
        com.robertnorthard.bank.demo.model.CredentialPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Credential> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Credential> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
