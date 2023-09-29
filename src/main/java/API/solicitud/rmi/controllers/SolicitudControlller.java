package API.solicitud.rmi.controllers;

import API.solicitud.rmi.services.DTOs.SolicitudDTO;
import API.solicitud.rmi.services.services.solicitudServices.ISolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/solicitud")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SolicitudControlller {

    @Autowired
    private ISolicitud solicitudService;

    @GetMapping(value = "", produces = "application/json")
    public List<SolicitudDTO> findAll() {
        return this.solicitudService.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public SolicitudDTO findById(@PathVariable Integer id) {
        return this.solicitudService.findById(id);
    }

    @PostMapping(value = "",produces = "application/json")
    public SolicitudDTO save(@RequestBody SolicitudDTO solicitudDTO) {
        return this.solicitudService.save(solicitudDTO);
    }

    @PutMapping(value = "/{id}",produces = "application/json")
    public SolicitudDTO update(@PathVariable Integer id, @RequestBody SolicitudDTO solicitudDTO) {
        return this.solicitudService.update(id, solicitudDTO);
    }

    @DeleteMapping(value = "/",produces = "application/json")
    public boolean delete(@RequestParam Integer idEliminar) {
        return this.solicitudService.delete(idEliminar);
    }

}
