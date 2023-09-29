package API.solicitud.rmi.models;

import API.solicitud.rmi.models.enums.TipoRevistaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class Solicitud {

    private Integer id;
    private LocalDate fechaSolicitud;
    private TipoRevistaEnum tipoRevista;
    private String ISSNRevista;
    private String tituloRevista;
    private LocalDate creadaEn;
    private LocalDate actualizadaEn;

}
