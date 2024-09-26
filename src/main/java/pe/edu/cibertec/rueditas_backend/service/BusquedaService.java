package pe.edu.cibertec.rueditas_backend.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.rueditas_backend.dto.BusquedaRequestDTO;

import java.io.IOException;

public interface BusquedaService {

    public String[] buscarVehiculo(String nroPlaca) throws IOException;

}
