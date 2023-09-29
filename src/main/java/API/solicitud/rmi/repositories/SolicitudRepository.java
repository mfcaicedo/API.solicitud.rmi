package API.solicitud.rmi.repositories;

import API.solicitud.rmi.models.Solicitud;
import API.solicitud.rmi.models.enums.TipoRevistaEnum;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SolicitudRepository {

    private final ArrayList<Solicitud> listaDeSolicitudes;

    public SolicitudRepository() {

        this.listaDeSolicitudes= new ArrayList<>();
        autoGenerarSolicitudes();

    }

    private void autoGenerarSolicitudes() {

        Solicitud solicitud1 = new Solicitud(1, LocalDate.now(), TipoRevistaEnum.NACIONAL, "ISSN1",
                "Titulo1", LocalDate.now(), LocalDate.now());
        this.listaDeSolicitudes.add(solicitud1);
        Solicitud solicitud2 = new Solicitud(2, LocalDate.now(), TipoRevistaEnum.INTERNACIONAL, "ISSN2",
                "Titulo2", LocalDate.now(), LocalDate.now());
        this.listaDeSolicitudes.add(solicitud2);
        Solicitud solicitud3 = new Solicitud(3, LocalDate.now(), TipoRevistaEnum.NACIONAL, "ISSN3",
                "Titulo3", LocalDate.now(), LocalDate.now());
        this.listaDeSolicitudes.add(solicitud3);
        Solicitud solicitud4 = new Solicitud(4, LocalDate.now(), TipoRevistaEnum.INTERNACIONAL, "ISSN4",
                "Titulo4", LocalDate.now(), LocalDate.now());
        this.listaDeSolicitudes.add(solicitud4);

    }

    public List<Solicitud> findAll() {

        System.out.println("Invocando a listar Solicitudes");
        return this.listaDeSolicitudes;

    }

    public Solicitud findById(Integer id) {

        System.out.println("Invocando a consultar una solicitud");
        Solicitud objSolicitud = new Solicitud();

        for (Solicitud solicitud : listaDeSolicitudes) {
            if(solicitud.getId() == id) {
                objSolicitud = solicitud;
               break;
            }
        }

        return objSolicitud;
    }

    public Solicitud save(Solicitud solicitud) {

        solicitud.setCreadaEn(LocalDate.now());
        solicitud.setActualizadaEn(LocalDate.now());

        System.out.println("Invocando a almacenar solicitud");
        Solicitud objSolicitud = null;
        if (this.listaDeSolicitudes.add(solicitud)) {
            objSolicitud = solicitud;
        }

        return objSolicitud;
    }

    public Solicitud update(Integer id, Solicitud solicitud) {

        solicitud.setActualizadaEn(LocalDate.now());
        solicitud.setCreadaEn(findById(id).getCreadaEn());

        System.out.println("Invocando a actualizar una solicitud");
        Solicitud objSolicitud = new Solicitud();

        for (int i = 0; i < this.listaDeSolicitudes.size(); i++) {
            if(this.listaDeSolicitudes.get(i).getId() == id) {
                this.listaDeSolicitudes.set(i, solicitud);
                objSolicitud = solicitud;
                break;
            }
        }

        return objSolicitud;
    }

    public boolean delete(Integer id) {

        System.out.println("Invocando a eliminar una solicitud");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeSolicitudes.size(); i++) {
            if(this.listaDeSolicitudes.get(i).getId() == id) {
                this.listaDeSolicitudes.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

}
