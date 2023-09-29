package API.solicitud.rmi.services.DTOs;

import API.solicitud.rmi.models.enums.TipoRevistaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SolicitudDTO {

        private Integer id;
        private LocalDate fechaSolicitud;
        private TipoRevistaEnum tipoRevista;
        private String ISSNRevista;
        private String tituloRevista;

}
