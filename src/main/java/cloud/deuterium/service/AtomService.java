package cloud.deuterium.service;

import cloud.deuterium.entity.Atom;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by Milan Stojkovic 25-Dec-2021
 * https://medium.com/geekculture/creating-a-crud-app-with-quarkus-reactive-hibernate-panache-and-graphql-using-a-postgresql-216ecd75ee52
 */

@ApplicationScoped
public class AtomService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public Multi<Atom> getAll() {
        log.info("Getting all Atoms from DB");
        return Atom.streamAll();
    }

    public Uni<Atom> getById(Long id) {
        log.info("Getting Atom with id={}", id);
        return Atom.findById(id);
    }

    public Uni<Atom> saveNew(Atom atom) {
        log.info("Save new Atom: {}", atom);
        return Panache.withTransaction(atom::persist);
    }

    public Uni<Boolean> deleteById(Long id) {
        log.info("Delete Atom with id={}", id);
        return Panache.withTransaction(() -> Atom.deleteById(id));
    }

}
