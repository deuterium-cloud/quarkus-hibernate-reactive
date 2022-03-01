package cloud.deuterium.resource;

import cloud.deuterium.entity.Atom;
import cloud.deuterium.service.AtomService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Milan Stojkovic 25-Dec-2021
 */

@ApplicationScoped
@Path("/api/v1/atoms")
public class AtomResource {

    @Inject
    AtomService atomService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<Atom> getAll() {
        return atomService.getAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Uni<Atom> getById(@PathParam("id") Long id) {
        return atomService.getById(id);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Uni<Atom> save(Atom atom) {
        return atomService.saveNew(atom);
    }

    @Produces(MediaType.TEXT_PLAIN)
    @DELETE
    @Path("/{id}")
    public Uni<Boolean> delete(@PathParam("id") Long id) {
        return atomService.deleteById(id);
    }

}
