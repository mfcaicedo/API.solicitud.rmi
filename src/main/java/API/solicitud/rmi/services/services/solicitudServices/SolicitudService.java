package API.solicitud.rmi.services.services.solicitudServices;

import API.solicitud.rmi.models.Solicitud;
import API.solicitud.rmi.repositories.SolicitudRepository;
import API.solicitud.rmi.services.DTOs.SolicitudDTO;
import API.solicitud.rmi.services.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudService implements ISolicitud {

    @Autowired
    private Mapper modelMapper;
    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public SolicitudDTO findById(Integer id) {

        Solicitud objSolicitud = this.solicitudRepository.findById(id);
        return this.modelMapper.modelMapper().map(objSolicitud, SolicitudDTO.class);

    }

    @Override
    public List<SolicitudDTO> findAll() {

        List<Solicitud> solicitudes = this.solicitudRepository.findAll();
        return this.modelMapper.modelMapper().map(solicitudes, List.class);

    }

    @Override
    public SolicitudDTO save(SolicitudDTO solicitudDTO) {

        Solicitud solicitud = this.modelMapper.modelMapper().map(solicitudDTO, Solicitud.class);
        return this.modelMapper.modelMapper().map(this.solicitudRepository.save(solicitud), SolicitudDTO.class);

    }

    @Override
    public SolicitudDTO update(Integer id, SolicitudDTO solicitudDTO) {

            Solicitud objSolicitud = this.solicitudRepository.findById(id);
            if (objSolicitud.getId() == 0) {
                return new SolicitudDTO();
            }

            Solicitud solicitud = this.modelMapper.modelMapper().map(solicitudDTO, Solicitud.class);
            return this.modelMapper.modelMapper().map(this.solicitudRepository.update(id, solicitud), SolicitudDTO.class);

    }

    @Override
    public boolean delete(Integer id) { return this.solicitudRepository.delete(id);}

}
