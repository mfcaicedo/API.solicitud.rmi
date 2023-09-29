package API.solicitud.rmi.services.services.solicitudServices;

import API.solicitud.rmi.services.DTOs.SolicitudDTO;

import java.util.List;

public interface ISolicitud {

    public SolicitudDTO findById(Integer id);

    public List<SolicitudDTO> findAll();

    public SolicitudDTO save(SolicitudDTO solicitudDTO);

    public SolicitudDTO update(Integer id,SolicitudDTO solicitudDTO);

    public boolean delete(Integer id);


}
