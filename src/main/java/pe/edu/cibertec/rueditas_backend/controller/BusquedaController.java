package pe.edu.cibertec.rueditas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.rueditas_backend.dto.BusquedaRequestDTO;
import pe.edu.cibertec.rueditas_backend.dto.BusquedaResponseDTO;
import pe.edu.cibertec.rueditas_backend.service.imp.BusquedaServiceImp;

import java.io.IOException;

@RestController
@RequestMapping("/autos")
public class BusquedaController {

    @Autowired
    BusquedaServiceImp busquedaServiceImp;

    @PostMapping("/buscar")
    public BusquedaResponseDTO Buscar(@RequestParam(name = "nroplaca") String nroplaca){

        try {
            String[] vehiculo = busquedaServiceImp.buscarVehiculo(nroplaca);

            if (vehiculo != null){
                return new BusquedaResponseDTO("00", "", vehiculo[0], vehiculo[1], vehiculo[2], vehiculo[3], vehiculo[4]);
            }else {

                return new BusquedaResponseDTO("01", "No se encontro el vehiculo", "", "", "", "", "");
            }

        } catch (IOException e) {
            return new BusquedaResponseDTO("98", "Error : " + e.getMessage(),"", "", "", "", "");
        }

    }

}
